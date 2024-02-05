package repository.category;

import Base.Repository.BaseRepository;
import Base.Repository.BaseRepositoryImpl;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryRepositoryImpl extends BaseRepositoryImpl<Integer, Category>
        implements CategoryRepository {
    public CategoryRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return "categories";
    }

    @Override
    public String getFieldName() {
        return "(name)";
    }

    @Override
    public String getQuestionMark() {
        return "(?)";
    }

    @Override
    public String getUpdateFields() {
        return "name=?";
    }

    @Override
    public void setFields(PreparedStatement ps, Category entity, boolean isCountOnly) throws SQLException {
        ps.setString(1, entity.getCategoryName());
    }

    @Override
    public Category mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        String categoryName = resultSet.getString(1);
        return new Category(categoryName);
    }
}
