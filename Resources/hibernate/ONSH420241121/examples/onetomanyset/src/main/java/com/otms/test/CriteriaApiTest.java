package com.otms.test;

import com.otms.entities.Manufacturer;
import com.otms.entities.Product;
import com.otms.entities.Product_;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.util.List;

public class CriteriaApiTest {
    public static void main(String[] args) {
        try {
            //showAllProductsGreaterThanPrice(10000);
            //showProductsByCategoryAndPrice("Electronics", 1000, 50000);
            //showProductsNamesByCategory("Electronics");
            //showNoOfProductsByProductName("l");
            //showProductNameAndCategoryByPrice(12000);
            showNoOfProductsByCategory();
            //showProductNameAndManufacturerByEstablishedDate(LocalDate.now().minusYears(10));
            //showManufacturersBasedOnProductCategory("Electronics");
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void showAllProducts() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Product> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Product> typedQuery = null;
        List<Product> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Product.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.select(root);

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            for (Product product : products) {
                System.out.println(product);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showAllProductsGreaterThanPrice(double price) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Product> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Product> typedQuery = null;
        List<Product> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Product.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.select(root);
            cq.where(cb.greaterThan(root.get("price"), price));

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            for (Product product : products) {
                System.out.println(product);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showProductsByCategoryAndPrice(String category, double minPrice, double maxPrice) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Product> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Product> typedQuery = null;
        List<Product> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Product.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.select(root);
            cq.where(cb.and(cb.like(root.get("category"), category), cb.between(root.get("price"), minPrice, maxPrice)));

            // select * from product where category like ? and price between 1000 2000

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            for (Product product : products) {
                System.out.println(product);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showProductsNamesByCategory(String category) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<String> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<String> typedQuery = null;
        List<String> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(String.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.multiselect(root.get("productName"));
            cq.where(cb.like(root.get("category"), category));


            // select * from product where category like ? and price between 1000 2000

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            for (String product : products) {
                System.out.println(product);
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showNoOfProductsByProductName(String productName) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Long> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Long> typedQuery = null;
        List<Long> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Long.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.multiselect(cb.count(root));
            cq.where(cb.like(root.get("productName"), "%" + productName + "%"));

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            System.out.println("count : " + products.get(0));
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showProductNameAndCategoryByPrice(double price) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Tuple> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Tuple> typedQuery = null;
        List<Tuple> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Tuple.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.multiselect(root.get("productName"), root.get("category"));
            cq.where(cb.greaterThan(root.get("price"), price));

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            products.stream().forEach(record -> {
                System.out.println(record.get(0) + " , " + record.get(1));
            });
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    private static void showNoOfProductsByCategory() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Tuple> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Tuple> typedQuery = null;
        List<Tuple> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Tuple.class); // empty

            Root<Product> root = cq.from(Product.class);
            cq.multiselect(cb.count(root.get(Product_.PRODUCT_NO)), root.get(Product_.CATEGORY));
            cq.groupBy(root.get(Product_.CATEGORY));

            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            products.stream().forEach(record -> {
                System.out.println(record.get(0) + " , " + record.get(1));
            });
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }


    // join queries
    private static void showProductNameAndManufacturerByEstablishedDate(LocalDate establishedDate) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Tuple> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Tuple> typedQuery = null;
        List<Tuple> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Tuple.class); // empty

            Root<Product> root = cq.from(Product.class);
            Join<Product, Manufacturer> join = root.join("manufacturer");

            cq.multiselect(root.get("productName"), join.get("businessName"));
            cq.where(cb.lessThan(join.get("establishedDate"), establishedDate));


            typedQuery = entityManager.createQuery(cq);
            products = typedQuery.getResultList();

            products.stream().forEach(record -> {
                System.out.println(record.get(0) + " , " + record.get(1));
            });
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showManufacturersBasedOnProductCategory(String category) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        CriteriaQuery<Manufacturer> cq = null;
        CriteriaBuilder cb = null;
        TypedQuery<Manufacturer> typedQuery = null;
        List<Manufacturer> manufacturers = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            cb = entityManager.getCriteriaBuilder();
            cq = cb.createQuery(Manufacturer.class); // empty

            Root<Manufacturer> root = cq.from(Manufacturer.class);
            Join<Manufacturer, Product> join = root.join("products");
            cq.select(root);
            cq.where(cb.like(join.get("category"), category));


            typedQuery = entityManager.createQuery(cq);
            manufacturers = typedQuery.getResultList();

            manufacturers.stream().forEach(record -> {
                System.out.println(record);
            });
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    // metadata model
    // 2nd level cache
}
