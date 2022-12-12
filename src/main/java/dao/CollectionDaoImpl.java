package dao;

import entity.CollectionEntity;
import pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectionDaoImpl implements CollectionDao {
    @Override
    public List<CollectionEntity> findAllCollection() throws SQLException {
        List<CollectionEntity> list = new ArrayList<>();
        String sql = "select id, nombre from coleccion";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                resultSet.getInt("id");
                resultSet.getString("nombre");
                CollectionEntity collectionEntity = new CollectionEntity();
                collectionEntity.setId(resultSet.getInt("id"));
                collectionEntity.setName(resultSet.getString("nombre"));
            }
        }
        ConnectionPool.getDataSource().getConnection();
        return list;
    }
}
