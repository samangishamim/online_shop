package Utility;

import connection.DBConfig;
import repository.admin.AdminsRepository;
import repository.admin.AdminsRepositoryImpl;
import service.admin.AdminsService;
import service.admin.AdminsServiceImpl;

import java.sql.Connection;

public class AplicationContext {
    private static Connection CONNECTION;
    private static AdminsRepository ADMINS_REPOSITORY;
    private static AdminsService ADMINS_SERVICE;

    public  static  void initialize(){
        if(CONNECTION == null){
             CONNECTION= DBConfig.getConnection();
        }
        if(ADMINS_REPOSITORY == null){
            ADMINS_REPOSITORY=new AdminsRepositoryImpl(CONNECTION);
            ADMINS_SERVICE=new AdminsServiceImpl(ADMINS_REPOSITORY);
        }

    }

    public  static AdminsService getAdminsService(){
        return  ADMINS_SERVICE;
    }
}
