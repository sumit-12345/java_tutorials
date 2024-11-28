package com.otms.test;

import com.otms.entities.Product;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class NamedQueryTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Product> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Product> products = null;
        try {

            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createNamedQuery("productsGreaterThanPrice", Product.class);
            allProductsQuery.setParameter("price", 10000);
            products = allProductsQuery.getResultList();

            products.forEach(System.out::println);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}
