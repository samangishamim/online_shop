package service;

import Utility.ApplicationContext;
import model.Brand;
import model.Category;
import model.Product;
import service.admin.AdminsService;
import service.brand.BrandService;
import service.category.CategoryService;
import service.product.ProductService;
import service.shoppingcart.ShoppingCartService;
import service.users.UserService;

import java.sql.SQLException;
import java.util.Scanner;

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
                case 1 -> categoryService.save(new Category());
                case 2 -> {
                    System.out.println("enter the category id to edit ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();
//                    categoryService.update();
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
                case 1 -> productService.save(new Product());
                case 2 -> {
                    System.out.println("enter the product id to edit ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
//                    productService.update();
                }
                case 3 -> {
                    System.out.println("enter the product id to delete ");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    productService.delete(productId);

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
                case 1 -> shoppingCartService.addShoppingCart(choice);
                case 2 -> {
//                    shoppingCartService.update();
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
            System.out.println("1-add ");
            System.out.println("2-delete ");
            System.out.println("3-edit ");
            System.out.println("0-exit");


            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> brandService.save(new Brand());
                case 2 -> {
                    System.out.println("enter the brand id to delete ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
                    brandService.delete(brandId);

                }
                case 3 -> {
                    System.out.println("enter the brand id to edit ");
                    int brandId = scanner.nextInt();
                    scanner.nextLine();
//                    brandService.update();

                }
                case 0 -> {
                    System.out.println("exit from shareholder-brand Menu ");
                    break;
                }
            }
        }
    }
}
