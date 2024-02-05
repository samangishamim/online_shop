package repository.brand;

import Base.Repository.BaseRepositoryImpl;
import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepositoryImpl extends BaseRepositoryImpl<Integer, Brand> implements BrandRepository {
    public BrandRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "brands";
    }

    @Override
    public String getFieldName() {
        return "(name)";
    }

    @Override
    public String getQuestionMark() {
        return "(?)";
    }

    @Override
    public String getUpdateFields() {
        return "name=?";
    }

    @Override
    public void setFields(PreparedStatement ps, Brand entity, boolean isCountOnly) throws SQLException {
        ps.setString(1, entity.getBrandName());
    }

    @Override
    public Brand mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String brandName = resultSet.getString(1);
        return  new Brand(brandName);
    }
}
