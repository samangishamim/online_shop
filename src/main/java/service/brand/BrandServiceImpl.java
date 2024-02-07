package service.brand;

import Base.Service.BaseServiceImpl;
import model.Brand;
import repository.brand.BrandRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class BrandServiceImpl extends BaseServiceImpl<Integer, Brand, BrandRepository>
        implements BrandService {
    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
    }

    @Override
    public ArrayList<Brand> listOfBrand() throws SQLException {
        return repository.listOfBrand();
    }
}
