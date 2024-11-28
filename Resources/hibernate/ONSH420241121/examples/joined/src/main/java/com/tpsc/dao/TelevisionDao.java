package com.tpsc.dao;

import com.tpsc.entities.LEDTelevision;
import com.tpsc.entities.Television;
import com.tpsc.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TelevisionDao {

    public int saveTelevision(Television television) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(television);


            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
                entityManager.close();
            }
        }
        return television.getTelevisionProductCode();
    }

    public LEDTelevision findLEDTelevision(int televisionProductCode) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        LEDTelevision television = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            television = entityManager.find(LEDTelevision.class, televisionProductCode);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return television;
    }

    public Television findTelevision(int televisionProductCode) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        Television television = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            television = entityManager.find(Television.class, televisionProductCode);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return television;
    }
}
