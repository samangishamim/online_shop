package repository.users;

import Base.Repository.BaseRepository;
import model.Users;

import java.sql.SQLException;

public interface UsersRepository extends BaseRepository<Integer, Users> {
    public boolean doSigning(String username, String password) throws SQLException;
    public boolean isUsernameExist(String username) throws SQLException;
}
