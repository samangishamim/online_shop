package service.admin;

import Base.Service.BaseServiceImpl;
import Utility.Validation;
import model.Admins;
import model.Users;
import repository.admin.AdminsRepository;
import model.Category;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminsServiceImpl extends BaseServiceImpl<Integer, Admins, AdminsRepository> implements AdminsService{
    public AdminsServiceImpl(AdminsRepository repository) {
        super(repository);
    }
    Scanner scanner =new Scanner(System.in);

    @Override
    public void SignUp() throws SQLException {
        System.out.println("**** signup ****");
        String username;
        do {
            System.out.println("enter your username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty. Please try again.");
            }
        } while (username.isEmpty());
        String password = getPassword();

        try {
            repository.save(new Admins(username,password));
            System.out.println("signup is done");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    @Override
    public boolean doSigning(String username, String password) throws SQLException {
        return repository.doSigning(username, password);
    }

    @Override
    public boolean signing() throws SQLException {
        System.out.println("***** sign in *****");
        String username;
        do {
            System.out.println("enter your username: ");
            username = scanner.nextLine();
            if (username.isEmpty()) {
                System.out.println("Username cannot be empty. Please try again.");
            }
        } while (username.isEmpty());
        System.out.println("enter your password ");
        String password = getPassword();


        return doSigning(username,password);
    }
    private String getPassword() {
        String password;
        while (true) {
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            if (password.isEmpty()) {
                System.out.println("Password cannot be empty. Please try again.");
                continue;
            }
            boolean checkPassword = Validation.checkPassword(password);
            if (checkPassword)
                break;
            else
                System.out.println("this is not strong password");
        }
        return password;
    }


}
