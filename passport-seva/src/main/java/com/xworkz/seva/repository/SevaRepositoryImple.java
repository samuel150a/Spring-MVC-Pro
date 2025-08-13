package com.xworkz.seva.repository;

import com.xworkz.seva.entity.SevaEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Repository
public class SevaRepositoryImple implements  SevaRepository {

    @Override
    public boolean saveDetails(SevaEntity sevaEntity) {
        System.out.println("Running in the saveDetails method");
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();

        entityTransaction.begin();
        entityManager.persist(sevaEntity);
        entityTransaction.commit();


        return true;
    }

    @Override
    public boolean isEmailAlreadyUsed(String email) {
        System.out.println("Running in the isEmailAlreadyUsed ");
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");

       try{
           EntityManager entityManager= entityManagerFactory.createEntityManager();
           Query query=entityManager.createNamedQuery("checkEmail");
           Object emailId = query.setParameter("emailId", email).getSingleResult();
           System.out.println(" em ==== "+emailId);


           return true;
       }catch (PersistenceException e){
           System.out.println("cat block ");
           e.printStackTrace();
           return false;
       }

      //  Object ref= query.getSingleResult();
      /*  if(emailId!=null)
        {
            return true;
        }
        else {
            return false;
        }*/
    }

//    @Override
//    public List<SevaEntity> fetchAllData( ) {
//        System.out.println("Running in the fetchAllData method");
//        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
//        EntityManager entityManager= entityManagerFactory.createEntityManager();
//        List<SevaEntity> save=entityManager.createNamedQuery("fetchAllData").getResultList();
//        return save;
//    }
}
