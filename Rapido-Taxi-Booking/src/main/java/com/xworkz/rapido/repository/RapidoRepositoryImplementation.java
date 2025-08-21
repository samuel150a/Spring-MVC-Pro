package com.xworkz.rapido.repository;

import com.xworkz.rapido.entity.RapidoEntity;
import com.xworkz.rapido.service.RapidoServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.SQLOutput;

@Repository
public class RapidoRepositoryImplementation implements RapidoRepository {

    public RapidoRepositoryImplementation()
    {
        System.out.println("Running in the RapidoRepositoryImplementation constructor");
    }
    private static final Logger log = LoggerFactory.getLogger(RapidoRepositoryImplementation.class);
    private EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
    @Override
    public Boolean save(RapidoEntity rapidoEntity) {



        log.error("Running in the save method%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% ");

        log.info("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        System.err.println("Running in the save method");
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
            entityManager =entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(rapidoEntity);
            log.info(String.valueOf("***********************************************"+rapidoEntity));

            entityTransaction.commit();
            return true;

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(entityManager!=null)
            {
                entityManager.close();
            }
        }
        return true;

    }

    @Override
    public String getByEmail(String email) {
        System.out.println("Running in the getByEmail in repository method");
       EntityManager entityManager=null;
       String check=null;
        try{
            entityManager=entityManagerFactory.createEntityManager();
            check= (String) entityManager.createNamedQuery("getByEmail").setParameter("email",email).getSingleResult();

            return check;
        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(entityManager!=null && entityManager.isOpen())
            {
                entityManager.close();
            }
        }
        return check;
    }

    @Override
    public Long getByPhoneNumber(Long num) {
        System.out.println("Running in the getByPhoneNumber");
        EntityManager entityManager=null;
        Long Chk=null;
        Long no=null;

        try{
            entityManager=entityManagerFactory.createEntityManager();

             no= (Long) entityManager.createNamedQuery("getByPhoneNumber").setParameter("phoneNumber",num).getSingleResult();
            return no;

        }
        catch(PersistenceException e){
            System.out.println(e.getMessage());
        }
        finally{
            if(entityManager!=null && entityManager.isOpen())
            {
                entityManager.close();
            }
        }
        return no;
    }

    public void closeResource(){
        if(entityManagerFactory!=null&&entityManagerFactory.isOpen())
        {
            entityManagerFactory.close();
        }
    }
}
