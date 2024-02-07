import Utility.ApplicationContext;
import model.Category;
import model.Product;
import repository.users.UsersRepository;
import service.Menu;
import service.admin.AdminsService;
import service.brand.BrandService;
import service.category.CategoryService;
import service.product.ProductService;
import service.shoppingcart.ShoppingCartService;
import service.users.UserService;

import java.math.BigDecimal;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext.initialize();
//        AdminsService adminsService=ApplicationContext.getAdminsService();
//        adminsService.save(new Admins("samangi","Aa@12345"));
//        adminsService.save(new Admins("darvishiani","Aa@12345"));
//        System.out.println(adminsService.findById(1));
//        adminsService.delete(2);
//        adminsService.addCategory("item");

        // todo: test for brand

//        BrandService brandService= ApplicationContext.getBrandService();
//        brandService.save(new Brand("kale"));
//        brandService.save(new Brand("bosch"));
//        System.out.println(brandService.findById(2));
//        brandService.delete(2);


        //todo : test for category

//        CategoryService categoryService=ApplicationContext.getCategoryService();
//        categoryService.save(new Category("electronic items"));
//        categoryService.save(new Category("clothes items"));


        //todo: test for product

//        ProductService productService = ApplicationContext.getProductService();
//        productService.save(new Product(4,"jarobarghi",2,20,new BigDecimal(200000),1));
//        productService.save(new Product("kafsh",2,20,new BigDecimal(300000),1));
//        System.out.println(productService.findById(2));
//        productService.delete(2);


        //todo : test for user

//        UserService userService = ApplicationContext.getUserService();
//        userService.SignUp();
//        userService.signing();


        //todo : test for admin

//        AdminsService adminsService=ApplicationContext.getAdminsService();
//        adminsService.SignUp();
//    adminsService.signing();


        ///todo test for shoppingcart

        ShoppingCartService shoppingCartService=ApplicationContext.getShoppingCartService();
//        shoppingCartService.addShoppingCart(1);
//shoppingCartService.removeShoppingCart(1);
        Menu menu=new Menu();
        menu.menu();
    }


}
