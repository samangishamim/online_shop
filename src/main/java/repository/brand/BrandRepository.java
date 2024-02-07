package repository.brand;

import Base.Repository.BaseRepository;
import model.Brand;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BrandRepository extends BaseRepository<Integer, Brand> {
    public ArrayList<Brand> listOfBrand() throws SQLException;
}
