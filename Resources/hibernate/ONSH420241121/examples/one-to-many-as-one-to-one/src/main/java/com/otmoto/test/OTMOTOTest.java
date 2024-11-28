package com.otmoto.test;

import com.otmoto.entities.Account;
import com.otmoto.entities.Locker;
import com.otmoto.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OTMOTOTest {
    public static void main(String[] args) {
        try {
            /*Locker locker = Locker.of().keyNo("k1").dimensions("10x12").charges(1000).build();
            int lockerNo = saveLocker(locker);
            System.out.println("locker no : " + lockerNo);*/
            /*Locker locker = getLocker(1);
            Set<Locker> lockerSet = new HashSet<>();
            lockerSet.add(locker);

            Account account = Account.of().accountHolderName("Mathew").accountType("savings")
                    .ifscCode("ICICI0001").balance(1000).assignedLockers(lockerSet).build();

            int accountNo = saveAccount(account);
            System.out.println("account no : " + accountNo);*/

            printAccount(1);


        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static Locker getLocker(int lockerNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Locker locker = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            locker = entityManager.find(Locker.class, lockerNo);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }
        return locker;
    }

    private static void printAccount(int accountNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Account account = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            account = entityManager.find(Account.class, accountNo);
            System.out.println(account);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }

    }

    private static int saveLocker(Locker locker) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int lockerNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(locker);
            lockerNo = locker.getLockerNo();

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
        return lockerNo;
    }

    private static int saveAccount(Account account) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int accountNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(account);
            accountNo = account.getAccountNo();

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
        return accountNo;
    }
}
