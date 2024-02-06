package repository.users;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepositoryImpl extends BaseRepositoryImpl<Integer, Users>
        implements UsersRepository {
    public UsersRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "users";
    }

    @Override
    public String getFieldName() {
        return "(username,password)";
    }

    @Override
    public String getQuestionMark() {
        return "(?,?)";
    }

    @Override
    public String getUpdateFields() {
        return "username=?,password=?";
    }

    @Override
    public void setFields(PreparedStatement ps, Users entity, boolean isCountOnly) throws SQLException {
        ps.setString(1, entity.getUsername());
        ps.setString(2, entity.getUsername());
    }

    @Override
    public Users mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString(1);
        String password = resultSet.getString(2);

        return new Users(username, password);
    }

    public boolean isUsernameExist(String username) throws SQLException {
        String existQuery = "select * from \"users\" where username=?;";
        try (PreparedStatement ps = connection.prepareStatement(existQuery);) {
            ps.setString(1, username);
            ResultSet resultSet = ps.executeQuery();
            return resultSet.next();
        }
    }

    public boolean doSigning(String username, String password) throws SQLException {
        String signIn = "select * from " + getTableName() + " where username=? and password=?; ";
        try (PreparedStatement ps = connection.prepareStatement(signIn)) {
            ps.setString(1, username);
            ps.setString(2, password);

            return ps.executeQuery().next();
        }
    }
}