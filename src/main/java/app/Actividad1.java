package app;

import entity.CollectionEntity;
import service.CollectionService;

import java.util.List;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        CollectionService collectionService = new CollectionService();
        List<CollectionEntity> list = collectionService.findAllCollection();

        for (CollectionEntity collectionEntity: list) {
            System.out.println( collectionEntity.getId() + " " + collectionEntity.getName());
        }

        System.out.println("Introduce un id de la coleccion");
        try (Scanner sc = new Scanner(System.in)){
            int id = sc.nextInt();
            sc.nextLine();
            CollectionEntity collectionEntity = collectionService.findCollectionById(id);
            System.out.println("Nombre: " + collectionEntity.getName());
            System.out.println("Usuario de creacion: " + collectionEntity.getUsu_cre());
        }
    }
}
