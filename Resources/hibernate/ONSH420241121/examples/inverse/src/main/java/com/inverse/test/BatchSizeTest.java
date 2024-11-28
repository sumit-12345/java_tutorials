package com.inverse.test;

import com.inverse.entities.Manufacturer;
import com.inverse.entities.Product;
import com.inverse.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Set;

public class BatchSizeTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<Manufacturer> manufacturerTypedQuery = entityManager.createQuery("from Manufacturer", Manufacturer.class);
            List<Manufacturer> manufacturers = manufacturerTypedQuery.getResultList();

            manufacturers.forEach(manufacturer -> {
                Set<Product> products = manufacturer.getProducts();
                System.out.println("manufacturer : " + manufacturer.getBusinessName() + " their products are [");
                products.forEach(product -> {
                    System.out.println(product.getProductName());
                });
                System.out.println("]");
            });

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

}
