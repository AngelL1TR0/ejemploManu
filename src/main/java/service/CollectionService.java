package service;

import dao.CollectionDao;
import dao.CollectionDaoImpl;
import entity.CollectionEntity;

import java.sql.SQLException;
import java.util.List;

public class CollectionService {

    CollectionDao collectionDao = new CollectionDaoImpl();
    public List<CollectionEntity> findAllCollection(){

        try {
            return collectionDao.findAllCollection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
