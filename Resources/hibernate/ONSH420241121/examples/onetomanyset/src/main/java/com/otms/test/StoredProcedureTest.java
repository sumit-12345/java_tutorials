package com.otms.test;

import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.StoredProcedureQuery;

public class StoredProcedureTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        StoredProcedureQuery findProductPriceSPQuery = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            findProductPriceSPQuery = entityManager.createNamedStoredProcedureQuery("findProductPrice");
            findProductPriceSPQuery.setParameter("product_no", 2);

            findProductPriceSPQuery.execute();
            double price = (double) findProductPriceSPQuery.getOutputParameterValue("price");
            System.out.println("price : " + price);
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}
