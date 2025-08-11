package com.xworkz.wild.repository;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;
import com.xworkz.wild.service.WildServiceImple;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class WildRepositoryImple  implements  WildRepository {

    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean saveDetails(WildEntity wildEntity) {


        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(wildEntity);
            entityTransaction.commit();

        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return true;
    }

    @Override
    public List<WildEntity> fetchListOfEntities() {
        List<WildEntity> fetch = null;
        try {
            fetch = emf.createEntityManager().createNamedQuery("fetchAllWildEntity").getResultList();
            //System.out.println(fetch);
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (emf != null) {
                emf.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return fetch;
    }
}