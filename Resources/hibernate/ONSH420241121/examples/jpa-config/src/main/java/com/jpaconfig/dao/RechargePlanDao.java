package com.jpaconfig.dao;

import com.jpaconfig.entities.RechargePlan;
import com.jpaconfig.helper.EntityManagerFactoryRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class RechargePlanDao {

    public void saveRechargePlan(RechargePlan rechargePlan) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;

        try {
            entityManagerFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(rechargePlan);

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
