package service.product;

import Base.Service.BaseServiceImpl;
import model.Product;
import repository.product.ProductRepository;

public class ProductServiceImpl extends BaseServiceImpl<Integer, Product, ProductRepository> implements ProductService{
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
