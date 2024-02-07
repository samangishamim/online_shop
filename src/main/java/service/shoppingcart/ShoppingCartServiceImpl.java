package service.shoppingcart;

import Base.Service.BaseServiceImpl;
import Utility.ApplicationContext;
import model.Product;
import model.ShoppingCart;
import repository.shoppingcart.ShoppingCartRepository;
import service.product.ProductService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartServiceImpl extends BaseServiceImpl<Integer, ShoppingCart, ShoppingCartRepository>
        implements ShoppingCartService {
    public ShoppingCartServiceImpl(ShoppingCartRepository repository) {
        super(repository);
    }

    Scanner scanner = new Scanner(System.in);

    @Override
    public void addShoppingCart(int userId) throws SQLException {
        System.out.println("**** add shopping cart **** ");
        ApplicationContext.initialize();
        ProductService productService = ApplicationContext.getProductService();

        productService.listOfProduct().forEach(System.out::println);//foreach
//        ArrayList<Product> productArrayList = productService.listOfProduct();
//        for (Product product : productArrayList) {
//            System.out.println(product);
//        }
        while (true) {
            Product product = null;
            int productId = 0;
            while (true) {
                System.out.println("enter the product id: ");
                productId = scanner.nextInt();
                scanner.nextLine();
                product = productService.findById(productId);
                if (product != null)
                    break;
            }

            System.out.println("enter the quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            if (!productService.CheckStockQuantity(productId, quantity)) {
                System.out.println("not enough in stock");
                return;
            }

            productService.UpdateStockQuantity(productId, quantity, false);


            BigDecimal price = product.getProductPrice();

            BigDecimal totalAmount = price.multiply(BigDecimal.valueOf(quantity)); //price * quantity

            Date orderDate = new Date(System.currentTimeMillis()); //TIME FOR NOW


            try {
                repository.save(new ShoppingCart(productId, quantity, price, totalAmount, orderDate, userId));
                System.out.println("this product is added to shopping cart");
            } catch (SQLException e) {
                System.out.println("error" + e.getMessage());
            }
            System.out.println("another order [y/n]");
            String yn = scanner.nextLine();
            if (yn.equals("n")) {
                break;
            }
        }

    }

    @Override
    public void showListAndEditShoppingCart(ShoppingCart shoppingCart) {

    }

    @Override
    public void removeShoppingCart(int userId) throws SQLException {
        System.out.println("**** remove product from shopping cart **** ");
        ApplicationContext.initialize();
        ProductService productService = ApplicationContext.getProductService();
        listByUserId(userId).forEach(System.out::println);
        Product product = null;
        int productId = 0;
        while (true) {
            System.out.println("enter the product id: ");
            productId = scanner.nextInt();
            scanner.nextLine();
            product = productService.findById(productId);
            if (product != null)
                break;
        }
        ShoppingCart shoppingCart = findByProductIdUserId(productId, userId);
        deleteByProductIdUserId(product.getId(),userId);
        productService.UpdateStockQuantity(product.getId(), shoppingCart.getQuantity(), true);
    }

    @Override
    public ArrayList<ShoppingCart> listOfShoppingCart() throws SQLException {
        return repository.listOfShoppingCart();
    }

    @Override
    public void deleteByProductIdUserId(int productId,int userId) throws SQLException {
        repository.deleteByProductIdUserId(productId,userId);
    }

    @Override
    public ArrayList<ShoppingCart> listByUserId(int userId) throws SQLException {
        return repository.listByUserId(userId);
    }

    @Override
    public ShoppingCart findByProductIdUserId(int productId, int userId) throws SQLException {
        return repository.findByProductIdUserId(productId, userId);
    }

}
