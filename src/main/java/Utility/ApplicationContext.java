package Utility;

import connection.DBConfig;
import repository.admin.AdminsRepository;
import repository.admin.AdminsRepositoryImpl;
import repository.brand.BrandRepository;
import repository.brand.BrandRepositoryImpl;
import repository.category.CategoryRepository;
import repository.category.CategoryRepositoryImpl;
import repository.product.ProductRepository;
import repository.product.ProductRepositoryImpl;
import repository.shoppingcart.ShoppingCartRepository;
import repository.shoppingcart.ShoppingCartRepositoryImpl;
import repository.users.UsersRepository;
import repository.users.UsersRepositoryImpl;
import service.admin.AdminsService;
import service.admin.AdminsServiceImpl;
import service.brand.BrandService;
import service.brand.BrandServiceImpl;
import service.category.CategoryServiceImpl;
import service.category.CategoryService;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import service.shoppingcart.ShoppingCartService;
import service.shoppingcart.ShoppingCartServiceImpl;
import service.users.UserService;
import service.users.UserServiceImpl;

import java.sql.Connection;

public class ApplicationContext {
    private static Connection CONNECTION;
    private static AdminsRepository ADMINS_REPOSITORY;
    private static AdminsService ADMINS_SERVICE;
    private static BrandRepository BRAND_REPOSITORY;
    private static BrandService BRAND_SERVICE;
    private static CategoryRepository CATEGORY_REPOSITORY;
    private static CategoryService CATEGORY_SERVICE;
    private static ProductRepository PRODUCT_REPOSITORY;
    private static ProductService PRODUCT_SERVICE;
    private static UsersRepository USERS_REPOSITORY;
    private static UserService USER_SERVICE;

    private   static ShoppingCartRepository SHOPPING_CART_REPOSITORY;
    private    static ShoppingCartService SHOPPING_CART_SERVICE;

    public static void initialize() {
        if (CONNECTION == null) {
            CONNECTION = DBConfig.getConnection();
        }
        if (ADMINS_REPOSITORY == null) {
            ADMINS_REPOSITORY = new AdminsRepositoryImpl(CONNECTION);
            ADMINS_SERVICE = new AdminsServiceImpl(ADMINS_REPOSITORY);
        }
        if (BRAND_REPOSITORY == null) {
            BRAND_REPOSITORY = new BrandRepositoryImpl(CONNECTION);
            BRAND_SERVICE = new BrandServiceImpl(BRAND_REPOSITORY);
        }
        if (CATEGORY_REPOSITORY == null) {
            CATEGORY_REPOSITORY = new CategoryRepositoryImpl(CONNECTION);
            CATEGORY_SERVICE = new CategoryServiceImpl(CATEGORY_REPOSITORY);
        }
        if (PRODUCT_REPOSITORY == null) {
            PRODUCT_REPOSITORY = new ProductRepositoryImpl(CONNECTION);
            PRODUCT_SERVICE = new ProductServiceImpl(PRODUCT_REPOSITORY);
        }
        if (USERS_REPOSITORY == null) {
            USERS_REPOSITORY = new UsersRepositoryImpl(CONNECTION);
            USER_SERVICE = new UserServiceImpl(USERS_REPOSITORY);
        }
        if (SHOPPING_CART_REPOSITORY == null) {
            SHOPPING_CART_REPOSITORY = new ShoppingCartRepositoryImpl(CONNECTION);
            SHOPPING_CART_SERVICE = new ShoppingCartServiceImpl(SHOPPING_CART_REPOSITORY);
        }


    }

    public static AdminsService getAdminsService() {
        return ADMINS_SERVICE;
    }

    public static BrandService getBrandService() {
        return BRAND_SERVICE;
    }

    public static CategoryService getCategoryService() {
        return CATEGORY_SERVICE;
    }

    public static ProductService getProductService() {
        return PRODUCT_SERVICE;
    }

    public static  UserService getUserService(){
        return  USER_SERVICE;
    }

    public static ShoppingCartService getShoppingCartService() {
        return SHOPPING_CART_SERVICE;
    }
}
