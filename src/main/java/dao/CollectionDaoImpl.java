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
            //No hay interrogante, no se hace el setteo
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

    @Override
    public CollectionEntity findCollectionById(int id) throws SQLException {
        CollectionEntity collectionEntity = new CollectionEntity();
        String sql = "select id, nombre, usu_cre, fec_cre from coleccion where id=?";
        try (Connection connection = ConnectionPool.getDataSource().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            //Si hay interrogantes hay que hacer el setteo
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                collectionEntity.setId(resultSet.getInt("id"));
                collectionEntity.setName(resultSet.getString("nombre"));
                collectionEntity.setUsu_cre(resultSet.getString("Usu_cre"));
                collectionEntity.setFec_cre(resultSet.getDate("Fec_cre"));
            }
        }

        return collectionEntity;
    }
}
