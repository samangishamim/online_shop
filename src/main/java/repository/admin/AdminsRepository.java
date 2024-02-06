package repository.admin;

import Base.Repository.BaseRepository;
import model.Admins;
import model.Category;

import java.sql.SQLException;


public interface AdminsRepository extends BaseRepository<Integer, Admins> {
    public boolean doSigning(String username, String password) throws SQLException;
}
