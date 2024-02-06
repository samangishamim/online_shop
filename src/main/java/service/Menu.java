package service;

import Utility.ApplicationContext;
import service.admin.AdminsService;
import service.brand.BrandService;
import service.category.CategoryService;
import service.product.ProductService;
import service.shoppingcart.ShoppingCartService;
import service.users.UserService;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ApplicationContext.initialize();
        AdminsService adminsService=ApplicationContext.getAdminsService();
        BrandService brandService= ApplicationContext.getBrandService();
        CategoryService categoryService=ApplicationContext.getCategoryService();
        ProductService productService = ApplicationContext.getProductService();
        UserService userService = ApplicationContext.getUserService();
        AdminsService adminsService=ApplicationContext.getAdminsService();
        ShoppingCartService shoppingCartService=ApplicationContext.getShoppingCartService();


    }

}
