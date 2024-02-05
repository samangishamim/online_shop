package Utility;

import connection.DBConfig;
import repository.admin.AdminsRepository;
import repository.admin.AdminsRepositoryImpl;
import repository.brand.BrandRepository;
import repository.brand.BrandRepositoryImpl;
import service.admin.AdminsService;
import service.admin.AdminsServiceImpl;
import service.brand.BrandService;
import service.brand.BrandServiceImpl;

import java.sql.Connection;

public class AplicationContext {
    private static Connection CONNECTION;
    private static AdminsRepository ADMINS_REPOSITORY;
    private static AdminsService ADMINS_SERVICE;
    private static BrandRepository BRAND_REPOSITORY;
    private static BrandService BRAND_SERVICE;

    public static void initialize() {
        if (CONNECTION == null) {
            CONNECTION = DBConfig.getConnection();
        }
        if (ADMINS_REPOSITORY == null) {
            ADMINS_REPOSITORY = new AdminsRepositoryImpl(CONNECTION);
            ADMINS_SERVICE = new AdminsServiceImpl(ADMINS_REPOSITORY);
        }
        if (BRAND_REPOSITORY==null){
            BRAND_REPOSITORY=new BrandRepositoryImpl(CONNECTION);
            BRAND_SERVICE=new BrandServiceImpl(BRAND_REPOSITORY);
        }
    }

    public static AdminsService getAdminsService() {
        return ADMINS_SERVICE;
    }
    public  static  BrandService getBrandService(){
        return BRAND_SERVICE;
    }
}
