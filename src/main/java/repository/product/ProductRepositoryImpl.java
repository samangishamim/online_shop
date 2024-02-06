package repository.product;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        ps.setInt(2, entity.getCategoryId());
        ps.setInt(3, entity.getStockQuantity());
        ps.setBigDecimal(4, entity.getProductPrice());
        ps.setInt(5, entity.getBrandId());
    }

    @Override
    public Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        String productName = resultSet.getString(2);
        int categoryId = resultSet.getInt(3);
        int stockQuantity = resultSet.getInt(4);
        BigDecimal price = resultSet.getBigDecimal(5);
        int brandId = resultSet.getInt(6);
        return new Product(id, productName, categoryId, stockQuantity, price, brandId);
    }

    @Override
    public ArrayList<Product> listOfProduct() throws SQLException {
        //todo SELECT  * FROM product ;
        String sql = "SELECT * FROM products";
        try (PreparedStatement ps = connection.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = ps.executeQuery();

            ArrayList<Product> productList = new ArrayList<>();
            while (resultSet.next()) {
                productList.add(mapResultSetToEntity(resultSet));
            }
            return productList;
        }
    }

    @Override
    public void UpdateStockQuantity(int productId, int quantity, boolean add) throws SQLException {
        //todo
        String sql = "";
        if (add) {
            sql = "UPDATE products set stock_quantity= stock_quantity +? Where id=?;";
        } else {
            sql = "UPDATE products set stock_quantity= stock_quantity -? Where id=?;";
        }
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
            ps.executeUpdate();
        }
    }

    @Override
    public boolean CheckStockQuantity(int productId, int quantity) throws SQLException {
        String sql="SELECT * FROM products WHERE stock_quantity>= ?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, productId);
         return ps.executeQuery().next();
        }
    }
}
