package repository.product;

import Base.Repository.BaseRepository;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductRepository extends BaseRepository<Integer, Product> {
    public ArrayList<Product> listOfProduct() throws SQLException;

    public  void UpdateStockQuantity(int productId,int quantity,boolean add) throws SQLException;
}
