package Base.Repository;

import Base.Model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel<ID extends Serializable, T extends BaseEntity<ID>>
        implements BaseRepository<ID, T> {

    private final Connection connection;

    protected BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(T entity) throws SQLException {
        // todo: INSERT INTO TABLE NAME (FIELD NAME) VALUES (QUESTIONMARKS)
        String sql = " INSERT INTO " + getTableName() + getFieldName() + " VALUES " + getQuestionMark();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            setFields(ps);
            ps.executeQuery();
        }
    }

    @Override
    public T findById(ID id) throws SQLException {
// todo : SELECT * FROM TABLE NAME WHERE ID=?
        String sql = " SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql){
            ps.setInt(1,(Integer) id);

            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                return  mapResultSetToEntity(resultSet);
            }
        }
    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void delete(ID id) {

    }

    public abstract String getTableName();

    public abstract String getQuestionMark();

    public abstract String getFieldName();

    public abstract String setFields(PreparedStatement ps);

    public  abstract String mapResultSetToEntity(ResultSet resultSet);
}
