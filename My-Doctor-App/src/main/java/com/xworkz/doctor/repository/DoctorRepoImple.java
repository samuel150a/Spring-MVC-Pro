package com.xworkz.doctor.repository;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class DoctorRepoImple implements DoctorRepository{
   private  EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");

    @Override
    public boolean save(DoctorEntity doctorEntity ) {

        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;

        try{
            entityManager=entityManagerFactory.createEntityManager();
            entityTransaction=entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(doctorEntity);
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
    public List<DoctorEntity> fetchAllEntites() {
        EntityManager entityManager=null;

        System.out.println("Running in the fetchAllEntites method");
        List<DoctorEntity> doctorEntity=null;

        try{
            entityManager=entityManagerFactory.createEntityManager();
            Query query= entityManager.createNamedQuery("fethAllEntites");
            doctorEntity= query.getResultList();


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

        return doctorEntity;
    }

    @Override
    public DoctorEntity fetchByID(Integer id) {
        System.out.println("Running in the fetchByID");
        DoctorEntity fetchByID=null;
       EntityManager entityManager=null;
        try{
            entityManager=entityManagerFactory.createEntityManager();
            fetchByID=entityManager.find(DoctorEntity.class,id);



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

        return fetchByID;
    }

    public   void closeEntityFactory()
    {
        if(entityManagerFactory!=null&& entityManagerFactory.isOpen())
        {
            entityManagerFactory.close();
        }
    }
}


