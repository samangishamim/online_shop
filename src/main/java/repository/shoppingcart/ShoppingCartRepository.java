package repository.shoppingcart;

import Base.Repository.BaseRepository;
import model.Product;
import model.ShoppingCart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ShoppingCartRepository extends BaseRepository<Integer, ShoppingCart> {
    public ArrayList<ShoppingCart> listOfShoppingCart() throws SQLException;

    public void deleteByProductIdUserId(int productId, int userId) throws SQLException;

    public ShoppingCart findByProductIdUserId(int productId, int userId) throws SQLException;

    public ArrayList<ShoppingCart> listByUserId(int userId) throws SQLException;

    public ArrayList<String> sumOfTotalAmountOfItems() throws SQLException;
    public ArrayList<String> sumOfTotalAmountOfItems(int userId) throws SQLException;

}
