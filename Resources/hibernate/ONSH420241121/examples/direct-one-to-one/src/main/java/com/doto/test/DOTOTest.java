package com.doto.test;

import com.doto.entities.AutoLoan;
import com.doto.entities.LoanDisbursement;
import com.doto.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class DOTOTest {
    public static void main(String[] args) {
        try {
            /*AutoLoan autoLoan = AutoLoan.of().applicantName("Mathew").interestRate(11.23).tenure(36).principleAmount(350000).build();
            int loanNo = saveAutoLoan(autoLoan);
            System.out.println("auto loan no : " + loanNo);*/

            /*LoanDisbursement loanDisbursement = LoanDisbursement.of()
                    .disbursementDate(LocalDate.now())
                    .disbursementAmount(350000)
                    .paidTo("Tunner Auto Services Pvt Ltd")
                    .chequeNo("SB0028333")
                    .chequeDate(LocalDate.now().plusDays(10)).build();
            int loanNo = saveLoanDisbursement(1, loanDisbursement);
            System.out.println("loan disbursement loan no : " + loanNo);*/
            printLoanDisbursement(1);
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static AutoLoan getAutoLoan(int loanNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        AutoLoan autoLoan = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            autoLoan = entityManager.find(AutoLoan.class, loanNo);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }
        return autoLoan;
    }

    private static void printLoanDisbursement(int loanNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        LoanDisbursement loanDisbursement = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            loanDisbursement = entityManager.find(LoanDisbursement.class, loanNo);
            System.out.println(loanDisbursement);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }

    }

    private static int saveAutoLoan(AutoLoan autoLoan) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int loanNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(autoLoan);
            loanNo = autoLoan.getLoanNo();

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
        return loanNo;
    }

    private static int saveLoanDisbursement(int loanNo , LoanDisbursement loanDisbursement) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            AutoLoan autoLoan = entityManager.find(AutoLoan.class, loanNo);
            loanDisbursement.setAutoLoan(autoLoan);

            entityManager.persist(loanDisbursement);
            loanNo = loanDisbursement.getLoanNo();

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
        return loanNo;
    }
}
