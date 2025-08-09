package com.xworkz.wild.repository;

import com.xworkz.wild.dto.WildDto;
import com.xworkz.wild.entity.WildEntity;
import com.xworkz.wild.service.WildServiceImple;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
@Repository
public class WildRepositoryImple  implements  WildRepository {
    @Override
    public boolean saveDetails( WildEntity wildEntity) {

        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(wildEntity);
            entityTransaction.commit();

        }
        catch(PersistenceException e){
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
