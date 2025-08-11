package com.xworkz.doctor.repository;

import com.xworkz.doctor.dto.DoctorDto;
import com.xworkz.doctor.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
@Repository
public class DoctorRepoImple implements DoctorRepository{
    @Override
    public boolean save(DoctorEntity doctorEntity ) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try{
            entityManagerFactory= Persistence.createEntityManagerFactory("x-workz");
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


