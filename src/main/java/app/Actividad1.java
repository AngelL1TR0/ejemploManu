package app;

import entity.CollectionEntity;
import service.CollectionService;

import java.util.List;

public class Actividad1 {
    public static void main(String[] args) {
        CollectionService collectionService = new CollectionService();
        List<CollectionEntity> list = collectionService.findAllCollection();

        for (CollectionEntity collectionEntity: list) {
            System.out.println(collectionEntity.getName());
        }
    }
}
