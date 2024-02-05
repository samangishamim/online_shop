package repository.product;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl extends BaseRepositoryImpl<Integer, Product>
        implements ProductRepository {

    public ProductRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "products";
    }

    @Override
    public String getFieldName() {
        return "(name,category_id,stock_quantity,price,brand_id)";
    }

    @Override
    public String getQuestionMark() {
        return "(?,?,?,?,?)";
    }

    @Override
    public String getUpdateFields() {

        return "name=?,category_id=?,stock_quantity=?,price=?,brand_id=?";
    }

    @Override
    public void setFields(PreparedStatement ps, Product entity, boolean isCountOnly) throws SQLException {
        ps.setString(1, entity.getProductName());
        ps.setInt(2,entity.getCategoryId());
        ps.setInt(3,entity.getStockQuantity());
        ps.setBigDecimal(4,entity.getProductPrice() );
        ps.setInt(5,entity.getBrandId());
    }

    @Override
    public Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String productName = resultSet.getString(2);
        int categoryId = resultSet.getInt(3);
        int stockQuantity = resultSet.getInt(4);
        BigDecimal price = resultSet.getBigDecimal(5);
        int brandId = resultSet.getInt(6);
        return new Product(id,productName,categoryId,stockQuantity,price,brandId);
    }
}
