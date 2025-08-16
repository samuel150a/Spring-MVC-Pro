package com.xworkz.tourism.repository;

import com.xworkz.tourism.dto.TourismDto;
import com.xworkz.tourism.entity.TourismEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class TourismRepoImpl  implements  TourismRepo{
    public TourismRepoImpl()
    {
        System.out.println("Running in the TourismRepoImpl Constructor");
    }
     private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");




    @Override
    public boolean saveDetails(TourismEntity tourismEntity) {
        {
            System.out.println("Running in the saveDetails method in repoImple");

            EntityManager entityManager=null;
            EntityTransaction entityTransaction=null;
            try {
                entityManager = entityManagerFactory.createEntityManager();
                entityTransaction = entityManager.getTransaction();

                entityTransaction.begin();
                entityManager.persist(tourismEntity);
                entityTransaction.commit();
            }
            catch(PersistenceException e)
            {
                System.out.println(e.getMessage());
            }
            finally{

                if (entityManager!=null)
                {
                    entityManager.close();
                }
            }

            return true;
        }    }

    @Override
    public List<TourismEntity> fetchAllEnties() {
        System.out.println("running in the fetchAllEnties ");
        EntityManager entityManager = null;
        List<TourismEntity> fet = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            Query query = entityManager.createNamedQuery("fetchAllEnties");
            fet = query.getResultList();


        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return fet;
    }

    @Override
    public TourismEntity fetchById(Integer id) {
        System.out.println("Running in the fetchById method ");
        EntityManager entityManager =null;
        TourismEntity idDetails=null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
             idDetails = entityManager.find(TourismEntity.class, id);
        }
    catch (PersistenceException e) {
        System.out.println(e.getMessage());
    } finally {
        if (entityManager != null) {
            entityManager.close();
        }
    }
        return idDetails;

    }

    public static void closeFactory() {
        System.out.println("Running in the closeFactory method ");
            if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
                entityManagerFactory.close();
                System.out.println("EntityManagerFactory closed.");

        }
    }
}

