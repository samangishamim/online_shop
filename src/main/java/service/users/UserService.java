package service.users;

import Base.Service.BaseService;
import model.Users;

import java.sql.SQLException;

public interface UserService extends BaseService<Integer, Users> {
    public void SignUp() throws SQLException;
    public boolean doSigning (String username,String password) throws SQLException;
    public boolean signing() throws SQLException;
}
