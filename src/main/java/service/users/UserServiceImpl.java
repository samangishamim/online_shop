package service.users;

import Base.Service.BaseServiceImpl;
import model.Users;
import repository.users.UsersRepository;

import java.sql.SQLException;

public class UserServiceImpl extends BaseServiceImpl<Integer, Users, UsersRepository> implements UserService{
    public UserServiceImpl(UsersRepository repository) {
        super(repository);
    }

    @Override
    public void SignUp() throws SQLException {

    }

    @Override
    public boolean signIn() throws SQLException {
        return false;
    }
}
