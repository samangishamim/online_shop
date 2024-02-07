package repository.shoppingcart;

import Base.Repository.BaseRepository;
import model.Product;
import model.ShoppingCart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ShoppingCartRepository extends BaseRepository<Integer, ShoppingCart> {
    public ArrayList<ShoppingCart> listOfShoppingCart() throws SQLException;
    public void deleteByProductId(int productId) throws SQLException;
    public ShoppingCart findByProductId(int productId);
    public  ArrayList<ShoppingCart> listByUserId(int userId) throws SQLException;
}
