package service.category;

import Base.Service.BaseServiceImpl;
import model.Category;
import repository.category.CategoryRepository;

public class CategoryServiceImpl extends BaseServiceImpl<Integer, Category, CategoryRepository> implements categoryService{
    public CategoryServiceImpl(CategoryRepository repository) {
        super(repository);
    }
}
