package com.xworkz.wild.repository;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;
import com.xworkz.wild.service.WildServiceImple;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class WildRepositoryImple implements WildRepository {


    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean saveDetails(WildEntity wildEntity) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {

            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(wildEntity);
            entityTransaction.commit();

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {

            if (entityManager != null) {
                entityManager.close();
            }
        }
        return true;
    }

    @Override
    public List<WildEntity> fetchListOfEntities() {
        System.out.println("Running in the fetchListOfEntities ");
        List<WildEntity> fetch = null;
        try {
            fetch = emf.createEntityManager().createNamedQuery("fetchAllWildEntity").getResultList();
            System.out.println(fetch);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }


        return fetch;

    }

    @Override
    public WildEntity fetchById(Integer id) {
        System.out.println("Running in the fetchById ");
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        WildEntity fetch = null;
        try {
            entityManager = emf.createEntityManager();

            fetch=entityManager.find(WildEntity.class,id);
            System.out.println(fetch);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }


        return fetch;

    }

    public static void closeFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("EntityManagerFactory closed.");
        }
    }

}
