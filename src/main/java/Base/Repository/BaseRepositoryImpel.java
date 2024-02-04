package Base.Repository;

import Base.Model.BaseEntity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class BaseRepositoryImpel<ID extends Serializable, T extends BaseEntity<ID>>
        implements BaseRepository<ID, T> {

    private final Connection connection;

    protected BaseRepositoryImpel(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void save(BaseEntity entity) throws SQLException {
        // todo: INSERT INTO TABLE NAME (FIELD NAME) VALUES (QUESTIONMARKS)
        String sql = " INSERT INTO " + getTableName() + getFieldName() + " VALUES " + getQuestionMark();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            setFields(ps);
            ps.executeQuery();
        }
    }

    @Override
    public BaseEntity findById(Serializable serializable) {
        return null;
    }

    @Override
    public void update(BaseEntity entity) {

    }

    @Override
    public void delete(Serializable serializable) {

    }

    public  abstract String getTableName();

    public abstract String getQuestionMark();

    public abstract String getFieldName();
    public abstract String setFields(PreparedStatement ps);
}
