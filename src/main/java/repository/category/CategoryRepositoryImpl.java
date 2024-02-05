package repository.category;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryRepositoryImpl extends BaseRepositoryImpl <Integer, Category>
        implements CategoryRepository {
    public CategoryRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getFieldName() {
        return null;
    }

    @Override
    public String getQuestionMark() {
        return null;
    }

    @Override
    public String getUpdateFields() {
        return null;
    }

    @Override
    public void setFields(PreparedStatement ps, Category entity, boolean isCountOnly) throws SQLException {

    }

    @Override
    public Category mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Category> listOfCategory() {
        return null;
    }
}
