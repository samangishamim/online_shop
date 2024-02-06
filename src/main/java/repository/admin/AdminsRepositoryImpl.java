package repository.admin;


import Base.Repository.BaseRepositoryImpl;
import model.Admins;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminsRepositoryImpl extends BaseRepositoryImpl <Integer , Admins>
        implements  AdminsRepository {
    public AdminsRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return  "admins";
    }
    @Override
    public String getFieldName() {
        return "(username , password)";
    }

    @Override
    public String getQuestionMark() {
        return "(?,?)";
    }


    @Override
    public String getUpdateFields() {
        return "username=? , password=? ";
    }

    @Override
    public void setFields(PreparedStatement ps, Admins entity, boolean isCountOnly) throws SQLException {
        ps.setString(1,entity.getUsername());
        ps.setString(2,entity.getPassword());
    }

    @Override
    public Admins mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String userName = resultSet.getString(1);
        String password = resultSet.getString(2);
        return  new Admins(userName,password);
    }
}
