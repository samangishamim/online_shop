package repository.category;

import Base.Repository.BaseRepository;
import model.Category;

import java.util.ArrayList;

public interface CategoryRepository extends BaseRepository<Integer, Category> {

    public ArrayList<Category>listOfCategory();
}
