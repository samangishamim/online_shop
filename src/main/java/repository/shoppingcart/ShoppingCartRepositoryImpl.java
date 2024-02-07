package repository.shoppingcart;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Product;
import model.ShoppingCart;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartRepositoryImpl extends BaseRepositoryImpl<Integer, ShoppingCart> implements ShoppingCartRepository {

    public ShoppingCartRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "shoppingcart";
    }

    @Override
    public String getFieldName() {
        return "(product_id,quantity,price,totalAmount,order_date,user_id)";
    }

    @Override
    public String getQuestionMark() {
        return "(?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateFields() {
        return "product_id=?,quantity=?,price=?,totalAmount=?,order_date=?,user_id=?";
    }

    @Override
    public void setFields(PreparedStatement ps, ShoppingCart entity, boolean isCountOnly) throws SQLException {
        ps.setInt(1, entity.getProductId());
        ps.setInt(2, entity.getQuantity());
        ps.setBigDecimal(3, entity.getPrice());
        ps.setBigDecimal(4, entity.getTotalAmount());
        ps.setDate(5, entity.getOrderDate());
        ps.setInt(6, entity.getUserId());
    }

    @Override
    public ShoppingCart mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(1);
        int productId = resultSet.getInt(2);
        int quantity = resultSet.getInt(3);
        BigDecimal price = resultSet.getBigDecimal(4);
        BigDecimal totalAmount = resultSet.getBigDecimal(5);
        Date orderDate = resultSet.getDate(6);
        int userId = resultSet.getInt(7);

        return new ShoppingCart(id, productId, quantity, totalAmount, price, orderDate, userId);
    }

    @Override
    public ArrayList<ShoppingCart> listOfShoppingCart() throws SQLException {
        //todo SELECT  * FROM shoppingCart ;
        String sql = "SELECT * FROM shoppingcart";
        try (PreparedStatement ps = connection.prepareStatement(sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            ResultSet resultSet = ps.executeQuery();

            ArrayList<ShoppingCart> shoppingCartList = new ArrayList<>();
            while (resultSet.next()) {
                shoppingCartList.add(mapResultSetToEntity(resultSet));
            }
            return shoppingCartList;
        }
    }


    @Override
    public void deleteByProductId(int productId) throws SQLException {
        String sql = "delete from shoppingcart where product_id=?;";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, productId);

            ps.executeUpdate();
        }
    }

    @Override
    public ShoppingCart findByProductId(int productId) {
        return null;
    }

    @Override
    public ArrayList<ShoppingCart> listByUserId(int userId) throws SQLException {
        String sql = "SELECT * FROM shoppingcart WHERE user_id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet resultSet = ps.executeQuery();

            ArrayList<ShoppingCart> listByUserId = new ArrayList<>();
            while (resultSet.next()) {
                listByUserId.add(mapResultSetToEntity(resultSet));
            }
            return listByUserId;
        }
    }
}
