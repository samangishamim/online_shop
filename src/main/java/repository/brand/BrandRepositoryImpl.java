package repository.brand;

import Base.Repository.BaseRepositoryImpl;
import model.Brand;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        return new Brand(brandName);
    }

    @Override
    public ArrayList<Brand> listOfBrand() throws SQLException {
        //todo SELECT  * FROM brand ;
        String sql = "SELECT * FROM brands";
        try (PreparedStatement ps = connection.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Brand> brandList = new ArrayList<>();
            while (resultSet.next()) {
                brandList.add(mapResultSetToEntity(resultSet));
            }
            return brandList;
        }
    }
}
