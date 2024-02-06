package service.product;

import Base.Service.BaseServiceImpl;
import model.Product;
import repository.product.ProductRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductServiceImpl extends BaseServiceImpl<Integer, Product, ProductRepository> implements ProductService{
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }

    @Override
    public ArrayList<Product> listOfProduct() throws SQLException {
        return  repository.listOfProduct();
    }

    @Override
    public void UpdateStockQuantity(int productId, int quantity, boolean add) throws SQLException {
        repository.UpdateStockQuantity(productId,quantity,add);
    }

    @Override
    public boolean CheckStockQuantity(int productId, int quantity) throws SQLException {
        return repository.CheckStockQuantity(productId,quantity);
    }
}
