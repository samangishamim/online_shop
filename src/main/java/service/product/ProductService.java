package service.product;

import Base.Service.BaseService;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductService extends BaseService<Integer, Product> {
    public ArrayList<Product> listOfProduct() throws SQLException;
    public  void UpdateStockQuantity(int productId,int quantity,boolean add) throws SQLException;

}
