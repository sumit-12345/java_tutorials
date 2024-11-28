package com.ci.test;

import com.ci.entities.LoanApplication;
import com.ci.entities.LoanApplicationID;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CITest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibpu");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        boolean flag = false;

        try {
            entityTransaction.begin();
            LoanApplicationID id = new LoanApplicationID();
            id.setApplicationNo(10);
            id.setBranchCode("HDFC0283");

            /*LoanApplication loanApplication = new LoanApplication();
            loanApplication.setId(id);
            loanApplication.setApplicantName("Roger");
            loanApplication.setAppliedDate(LocalDate.now());
            loanApplication.setLoanType("Personal Loan");
            loanApplication.setAmount(120000);

            entityManager.persist(loanApplication);
            System.out.println("loan application saved!");*/

            LoanApplication loanApplication = entityManager.find(LoanApplication.class, id);
            System.out.println(loanApplication);

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
            if (emf != null) {
                emf.close();
                emf = null;
            }
        }
    }
}
