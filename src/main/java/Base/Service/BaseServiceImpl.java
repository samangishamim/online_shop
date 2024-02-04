package Base.Service;

import Base.Model.BaseEntity;
import Base.Repository.BaseRepository;

import java.io.Serializable;

public class BaseServiceImpl <ID extends Serializable , T extends BaseEntity <ID>, R extends BaseRepository<ID , T>>
        implements  BaseService<ID , T>{
    @Override
    public void save(T entity) {

    }

    @Override
    public T findById(ID id) {
        return null;
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(ID id) {

    }
}
