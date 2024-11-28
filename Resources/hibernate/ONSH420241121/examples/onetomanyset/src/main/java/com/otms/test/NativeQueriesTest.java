package com.otms.test;

import com.otms.bean.BasicProduct;
import com.otms.entities.Product;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class NativeQueriesTest {
    public static void main(String[] args) {

        try {
            //showAllProductsAdhoc();
            //showProductsByCategoryNamedNativeQuery("Electronics");
            //showProductsBetweenPriceBasedOnEntity(1000, 5000);
            showBasicProductsGreaterThanPrice(4000);
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showAllProductsAdhoc() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Query allProductsQuery = null;
        List<Object[]> rows = null;
        try {

            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createNativeQuery("select p.product_no, p.product_nm, p.category, p.price from product p");
            rows = allProductsQuery.getResultList();
            rows.stream().forEach(row -> {
                System.out.println(row[0] + " , " + row[1] + " , " + row[2] + " , " + row[3]);
            });

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showProductsByCategoryNamedNativeQuery(String category) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Query allProductsQuery = null;
        List<Object[]> rows = null;
        try {

            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createNamedQuery("productsByCategory");
            allProductsQuery.setParameter("category", category);

            rows = allProductsQuery.getResultList();
            rows.stream().forEach(row -> {
                System.out.println(row[0] + " , " + row[1] + " , " + row[2] + " , " + row[3]);
            });

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showProductsBetweenPriceBasedOnEntity(double minPrice, double maxPrice) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Query allProductsQuery = null;
        List<Product> products = null;
        try {

            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createNativeQuery("select p.product_no, p.product_nm, p.description, " +
                    "p.category, p.price, p.manufacturer_no from product p where p.price between :minPrice and :maxPrice", Product.class);
            allProductsQuery.setParameter("minPrice", minPrice);
            allProductsQuery.setParameter("maxPrice", maxPrice);

            products = allProductsQuery.getResultList();
            products.stream().forEach(product -> {
                System.out.println(product);
            });

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showBasicProductsGreaterThanPrice(double price) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Query allProductsQuery = null;
        List<BasicProduct> products = null;
        try {

            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createNativeQuery("select p.product_no, p.product_nm, p.description, " +
                    "p.category, p.price, p.manufacturer_no from product p where p.price > :price", "BasicProductMapping");
            allProductsQuery.setParameter("price", price);

            products = allProductsQuery.getResultList();
            products.stream().forEach(product -> {
                System.out.println(product);
            });

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
    }
}







