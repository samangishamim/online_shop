package repository.admin;


import Base.Repository.BaseRepositoryImpl;
import model.Admins;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminsRepositoryImpl extends BaseRepositoryImpl <String , Admins>
        implements  AdminsRepository {
    public AdminsRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getQuestionMark() {
        return null;
    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public String getUpdateFields() {
        return null;
    }

    @Override
    public String setFields(PreparedStatement ps, Admins entity, boolean isCountOnly) {
        return null;
    }

    @Override
    public Admins mapResultSetToEntity(ResultSet resultSet) {
        return null;
    }
}
