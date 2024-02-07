package service.users;

import Base.Service.BaseServiceImpl;
import Utility.Validation;
import model.Users;
import repository.users.UsersRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class UserServiceImpl extends BaseServiceImpl<Integer, Users, UsersRepository> implements UserService{
    Scanner scanner=new Scanner(System.in);
    public UserServiceImpl(UsersRepository repository) {
        super(repository);
    }

    @Override
    public void SignUp() throws SQLException {
        System.out.println("**** signup ****");
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        System.out.println("enter your password");
        String password = getPassword();

        try {
            repository.save(new Users(username,password));
            System.out.println("signup is done");
        } catch (SQLException e) {
            System.out.println("error" + e.getMessage());
        }
    }

    @Override
    public boolean doSigning(String username,String password) throws SQLException {
       return repository.doSigning(username, password);
    }

    @Override
    public boolean signing() throws SQLException {
        System.out.println("***** sign in *****");
        System.out.println("enter your username: ");
        String username = scanner.nextLine();
        String password = getPassword();


        return doSigning(username,password);
    }

    private String getPassword() {
        String password;
        while (true) {
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            boolean checkPassword = Validation.checkPassword(password);
            if (checkPassword)
                break;
            else
                System.out.println("this is not strong password");
        }
        return password;
    }
}
