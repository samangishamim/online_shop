package service;

import Utility.ApplicationContext;
import model.Brand;
import model.Category;
import model.Product;
import model.ShoppingCart;
import service.admin.AdminsService;
import service.brand.BrandService;
import service.category.CategoryService;
import service.product.ProductService;
import service.shoppingcart.ShoppingCartService;
import service.users.UserService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    AdminsService adminsService = ApplicationContext.getAdminsService();
    BrandService brandService = ApplicationContext.getBrandService();
    CategoryService categoryService = ApplicationContext.getCategoryService();
    ProductService productService = ApplicationContext.getProductService();
    UserService userService = ApplicationContext.getUserService();
    AdminsService adminsService1 = ApplicationContext.getAdminsService();
    ShoppingCartService shoppingCartService = ApplicationContext.getShoppingCartService();


    public void menu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("***** main menu *****");
            System.out.println("1-admin sign up");
            System.out.println("2-admin sign in");
            System.out.println("3-user sign up");
            System.out.println("4-user sign in");
            System.out.println("0-exit");
            System.out.println("enter a number ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> adminsService1.SignUp();
                case 2 -> {
                    boolean result = adminsService1.signing();
                    if (result) {
                        subMenu();
                    }
                }
                case 3 -> userService.SignUp();
                case 4 -> {
                    boolean result1 = userService.signing();
                    if (result1) {
                        subMenu1();
                    }
                }
                case 0 -> {
                    System.out.println("byeeeeee");
                    break;
                }

            }
        }


    }

    public void subMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**** sub menu ****");
            System.out.println("1-category");
            System.out.println("2-product");
            System.out.println("3-brand");
            System.out.println("0-exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> categoryMenu();
                case 2 -> productMenu();
                case 3 -> brandMenu();
                case 0 -> {
                    System.out.println("exit from subMenu");
                    break;
                }

            }
        }
    }

    public void categoryMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("***** category menu *****");
            System.out.println("1-add ");
            System.out.println("2-edit ");
            System.out.println("3-delete ");
            System.out.println("0-exit");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter category name: ");
                    String categoryName = scanner.nextLine();

                    Category newCategory = new Category();
                    newCategory.setCategoryName(categoryName);
                    categoryService.save(newCategory);
                    System.out.println("the category has been added");
                }
                case 2 -> {
                    System.out.println("enter the category id to edit ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();

                    Category categoryToUpdate = categoryService.findById(categoryId);
                    if (categoryToUpdate != null) {
                        System.out.println("Enter new category name: ");
                        String newCategoryName = scanner.nextLine();
                        categoryToUpdate.setCategoryName(newCategoryName);
                        categoryService.update(categoryToUpdate);
                    } else {
                        System.out.println("Category with id " + categoryId + " not found.");
                    }
                }
                case 3 -> {
                    System.out.println("enter the category id to delete ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();
                    productService.delete(categoryId);
                    categoryService.delete(categoryId);
                }
                case 0 -> {
                    System.out.println("exit from category Menu ");
                    break;
                }
            }
        }
    }


    public void productMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("***** product menu *****");
            System.out.println("1-add ");
            System.out.println("2-edit ");
            System.out.println("3-delete ");
            System.out.println("0-exit");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.println("Enter category id: ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter stock quantity: ");
                    int stockQuantity = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter product price: ");
                    BigDecimal productPrice = scanner.nextBigDecimal();
                    scanner.nextLine();
                    System.out.println("Enter brand id: ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
                    Product newProduct = new Product();
                    newProduct.setProductName(productName);
                    newProduct.setCategoryId(categoryId);
                    newProduct.setStockQuantity(stockQuantity);
                    newProduct.setProductPrice(productPrice);
                    newProduct.setBrandId(brandId);

                    productService.save(newProduct);
                }
                case 2 -> {

                    System.out.println("enter the product id to edit ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();

                    Product productToUpdate = productService.findById(productId);
                    if (productToUpdate != null) {
                        System.out.println("Enter new product name: ");
                        String newProductName = scanner.nextLine();
                        System.out.println("Enter new category id: ");
                        int newCategoryId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new stock quantity: ");
                        int newStockQuantity = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter new product price: ");
                        BigDecimal newProductPrice = scanner.nextBigDecimal();
                        scanner.nextLine();
                        System.out.println("Enter new brand id: ");
                        int newBrandId = scanner.nextInt();
                        scanner.nextLine();

                        productToUpdate.setProductName(newProductName);
                        productToUpdate.setCategoryId(newCategoryId);
                        productToUpdate.setStockQuantity(newStockQuantity);
                        productToUpdate.setProductPrice(newProductPrice);
                        productToUpdate.setBrandId(newBrandId);

                        productService.update(productToUpdate);
                    } else {
                        System.out.println("Product with id " + productId + " not found.");
                    }
                }
                case 3 -> {
                    System.out.println("Enter the product id to delete: ");
                    int productIdToDelete = scanner.nextInt();
                    scanner.nextLine();
                    productService.delete(productIdToDelete);

                }
                case 0 -> {
                    System.out.println("exit from product Menu ");
                    break;
                }
            }
        }
    }


    public void subMenu1() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("**** sub menu ****");
            System.out.println("1-add shopping cart");
            System.out.println("2-edit shopping cart");
            System.out.println("3-delete shopping cart");
            System.out.println("0-exit");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the user ID for the shopping cart: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    shoppingCartService.addShoppingCart(userId);
                }
                case 2 -> {
                    System.out.println("Enter the shopping cart ID to update: ");
                    int shoppingCartId = scanner.nextInt();
                    scanner.nextLine();
//                    shoppingCartService.update(shoppingCartId);  // Call the method to update the shopping cart
                    break;
                }
                case 3 -> {
                    System.out.println("enter the shopping id to delete ");
                    int shoppingId = scanner.nextInt();
                    scanner.nextLine();
                    productService.delete(shoppingId);
                }
                case 0 -> {
                    System.out.println("exit from subMenu");
                    break;
                }

            }
        }
    }


    public void brandMenu() throws SQLException {
        int choice = -1;
        while (choice != 0) {
            System.out.println("*****  brand  MENU *****");
            System.out.println("1 - Add brand");
            System.out.println("2 - Delete brand");
            System.out.println("3 - Edit brand");
            System.out.println("0 - Exit");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {

                    System.out.println("Enter brand name: ");
                    String brandName = scanner.nextLine();
                    Brand newBrand = new Brand();
                    newBrand.setBrandName(brandName);
                    brandService.save(newBrand);
                }
                case 2 -> {
                    System.out.println("Enter the brand id to delete: ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
                    brandService.delete(brandId);

                }
                case 3 -> {
                    System.out.println("List of brands:");
//                    List<Brand> brandsForEdit = brandService. // Assuming getAll method fetches all brands from the database
//                    for (Brand brand : brandsForEdit) {
//                        System.out.println(brand.getId() + ": " + brand.getBrandName();
                        System.out.println("Enter the brand id to edit: ");
                        int brandId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Enter the new brand name: ");
                        String newBrandName = scanner.nextLine();
                        Brand updatedBrand = new Brand();
                        updatedBrand.setId(brandId);
                        updatedBrand.setBrandName(newBrandName);
                        brandService.update(updatedBrand);

                    }
                    case 0 -> {
                        System.out.println("exit from brand Menu ");
                        break;
                    }
                }
            }
        }

//    private ShoppingCart getUpdatedShoppingCartDetails() {
//        // Prompt the user for updated shopping cart details
//        System.out.println("Enter the updated items for the shopping cart (comma-separated): ");
//        String itemsInput = scanner.nextLine();
//        String[] itemsArray = itemsInput.split(",");
//
//        System.out.println("Enter the updated quantities for the items (comma-separated): ");
//        String quantitiesInput = scanner.nextLine();
//        String[] quantitiesArray = quantitiesInput.split(",");
//
//        // Create a new ShoppingCart object with the updated details
//        ShoppingCart updatedShoppingCart = new ShoppingCart();
//        updatedShoppingCart.setItems(new ArrayList<>(Arrays.asList(itemsArray)));
//        List<Integer> quantitiesList = Arrays.stream(quantitiesArray).map(Integer::parseInt).collect(Collectors.toList());
//        updatedShoppingCart.setQuantity(quantitiesList);
//
//        // You can prompt the user for other details such as total price, shipping details, etc., and set them in the updatedShoppingCart object
//
//        return updatedShoppingCart;
//    }
    }
