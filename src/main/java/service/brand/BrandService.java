package service.brand;

import Base.Service.BaseService;
import model.Brand;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandService extends BaseService<Integer, Brand> {
    public ArrayList<Brand> listOfBrand() throws SQLException;
}
