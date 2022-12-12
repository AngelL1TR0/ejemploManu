package dao;

import entity.CollectionEntity;

import java.sql.SQLException;
import java.util.List;

public interface CollectionDao {
    List<CollectionEntity> findAllCollection() throws SQLException;

}
