package repository.brand;

import Base.Repository.BaseRepositoryImpl;
import model.Brand;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepositoryImpl extends BaseRepositoryImpl<Integer, Brand> implements BrandRepository{
    public BrandRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public String getQuestionMark() {
        return null;
    }

    @Override
    public String getUpdateFields() {
        return null;
    }

    @Override
    public void setFields(PreparedStatement ps, Brand entity, boolean isCountOnly) throws SQLException {

    }

    @Override
    public Brand mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }
}
