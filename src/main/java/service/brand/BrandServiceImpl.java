package service.brand;

import Base.Service.BaseService;
import Base.Service.BaseServiceImpl;
import model.Brand;
import repository.brand.BrandRepository;

public class BrandServiceImpl extends BaseServiceImpl<Integer, Brand, BrandRepository>
        implements BrandService {
    public BrandServiceImpl(BrandRepository repository) {
        super(repository);
    }
}
