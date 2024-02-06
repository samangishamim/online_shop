package service.admin;

import Base.Service.BaseService;
import model.Admins;

import java.sql.SQLException;

public interface AdminsService extends BaseService<Integer, Admins> {
    public void SignUp() throws SQLException;
    public boolean doSigning (String username,String password) throws SQLException;
    public boolean signing() throws SQLException;
}
