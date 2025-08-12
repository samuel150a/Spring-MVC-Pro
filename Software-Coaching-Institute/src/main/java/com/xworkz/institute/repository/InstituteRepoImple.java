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

    EntityManager entityManager=null;
    EntityTransaction entityTransaction=null;
    @Override
    public boolean saveDetails(InstituteEntity instituteEntity ) {
        EntityManagerFactory entityManagerFactory=null;



        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");

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
        if(entityManagerFactory!=null||entityManagerFactory.isOpen())
        {
            entityManagerFactory.close();
        }
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

        try{

        fetch = entityManagerFactory.createEntityManager().createNamedQuery("fetchAllEntities").getResultList();
    }
 catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(entityManagerFactory!=null||entityManagerFactory.isOpen())
            {
                entityManagerFactory.close();
            }
            if (entityManager!=null)
            {
                entityManager.close();
            }
        }
        return fetch;
    }
}

