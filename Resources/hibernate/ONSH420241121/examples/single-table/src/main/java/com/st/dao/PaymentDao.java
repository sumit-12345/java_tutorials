package com.st.dao;

import com.st.entities.ChequePayment;
import com.st.entities.Payment;
import com.st.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class PaymentDao {
    public int savePayment(Payment payment) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(payment);


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
        return payment.getId();
    }

    public ChequePayment findChequePayment(int paymentNo) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        ChequePayment chequePayment = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            chequePayment = entityManager.find(ChequePayment.class, paymentNo);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return chequePayment;
    }

    public Payment findPayment(int paymentNo) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        Payment payment = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            payment = entityManager.find(Payment.class, paymentNo);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return payment;
    }

}
