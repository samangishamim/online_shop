package repository.shoppingcart;

import Base.Repository.BaseRepository;
import model.Product;
import model.ShoppingCart;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ShoppingCartRepository extends BaseRepository<Integer, ShoppingCart> {
    public ArrayList<ShoppingCart> getCartItems(int userId);
}
