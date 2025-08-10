package com.xworkz.institute.repository;

import com.xworkz.institute.dto.InstituteDto;
import com.xworkz.institute.entity.InstituteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
@Repository
public class InstituteRepoImple  implements InstituteRepository{

    @Override
    public boolean saveDetails(InstituteEntity instituteEntity ) {
        EntityManagerFactory entityManagerFactory=null;
    EntityManager entityManager=null;
    EntityTransaction entityTransaction=null;
        try{
        entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
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
        if(entityManagerFactory!=null)
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
}

