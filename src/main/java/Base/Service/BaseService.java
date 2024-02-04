package Base.Service;

import Base.Model.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;

public interface BaseService<ID extends Serializable , T extends BaseEntity <ID>> {
    void save(T entity) ;

    T findById(ID id);

    void update(T entity);

    void delete (ID id);
}
