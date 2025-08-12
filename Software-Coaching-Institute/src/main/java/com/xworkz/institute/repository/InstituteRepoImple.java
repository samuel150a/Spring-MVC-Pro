package com.xworkz.institute.repository;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class InstituteRepoImple  implements InstituteRepository{
            private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean saveDetails(InstituteEntity instituteEntity ) {


        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{

            entityManager=entityManagerFactory.createEntityManager();
        entityTransaction=entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(instituteEntity);
        entityTransaction.commit();

    }
        catch(
    PersistenceException e){
        System.out.println(e.getMessage());
    }
        finally{

        if (entityManager!=null)
        {
            entityManager.close();
        }
    }
        return true;
}

    @Override
    public List<InstituteEntity> fethAllData() {
        List<InstituteEntity> fetch = null;
        EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        EntityManager entityManager=null;
        try{

        entityManager = entityManagerFactory.createEntityManager();
           fetch= entityManager .createNamedQuery("fetchAllEntities").getResultList();
    }
 catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{

            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
        return fetch;
    }

    @Override
    public InstituteEntity fetchById(Integer id) {
        System.out.println("Running in the fetchById method");
          EntityManager entityManager=null;
        InstituteEntity  finded=null;
        try{
            entityManager=entityManagerFactory.createEntityManager();
              finded =entityManager.find(InstituteEntity.class,id);
            System.out.println("finded"+finded);
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }finally{

            if (entityManager!=null)
            {
                entityManager.close();
            }
        }

        return finded;

    }
    public static void closeFactory()
    {
        if(entityManagerFactory!=null&& entityManagerFactory.isOpen())
        {
            entityManagerFactory.close();
        }
    }
}

