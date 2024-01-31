package Base.Repository;

import Base.Model.BaseEntity;

import java.io.Serializable;

public interface BaseRepository <ID extends Serializable , T extends BaseEntity<ID>>{
    void save(T entity);



}
