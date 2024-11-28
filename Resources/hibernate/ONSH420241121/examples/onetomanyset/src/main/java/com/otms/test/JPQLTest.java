package com.otms.test;

import com.otms.bean.BasicProduct;
import com.otms.entities.Manufacturer;
import com.otms.entities.Product;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JPQLTest {
    public static void main(String[] args) {

        try {
            allProducts(3, 3);
            //allProductsByPriceBetween(1000, 5000);
            //showProductCount();
            //showMinPrice();
            //showNoOfProductsByCategory();
            //showBasicProductInfoByCategory("Electronics");
            //showAllProductsManufacturedBy("Philips");
            //showManufacturersByCategory("Fashion and Accessories");
            //showProductsByManufacturerEstablishedDate(LocalDate.now().minusYears(10));
            //showManufacturersWhereProductPriceGreater(50000);
            //showCountOfProductsByManufacturer("Uncle Thompsons Store");
            //showManufacturersAtleastProducts(3);
        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void allProducts(int pageNo, int pageSize) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Product> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Product> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createQuery("from Product p order by p.productName", Product.class);
            allProductsQuery.setMaxResults(pageSize); // total objects to be returned from the query
            allProductsQuery.setFirstResult((pageNo - 1) * pageSize); // start index in the resultset


            // 1000 products records

            products = allProductsQuery.getResultList();

            products.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void allProductsByPriceBetween(final double minPrice, final double maxPrice) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Product> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Product> products = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createQuery("from Product p where p.price >= :minPrice and p.price <= :maxPrice", Product.class);
            allProductsQuery.setParameter("minPrice", minPrice);
            allProductsQuery.setParameter("maxPrice", maxPrice);

            products = allProductsQuery.getResultList();

            products.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showProductCount() {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Long> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Long> cProducts = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createQuery("select count(p) from Product p", Long.class);

            cProducts = allProductsQuery.getResultList();

            cProducts.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showMinPrice() {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Double> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Double> minPrice = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createQuery("select min(p.price) from Product p", Double.class);

            minPrice = allProductsQuery.getResultList();

            minPrice.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
    // aggregate functions: min, max, avg, count, sum

    // show me the no of products per category
    private static void showNoOfProductsByCategory() {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Tuple> allProductsQuery = null;
        EntityManager entityManager = null;
        Map<String, Long> productCountsByCategoryMap = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager.createQuery("select p.category, count(p) from Product p group by p.category having count(p) > :quantity", Tuple.class);
            allProductsQuery.setParameter("quantity", 1);
            productCountsByCategoryMap = allProductsQuery.getResultList()
                    .stream()
                    .collect(Collectors.toMap(tuple -> (String) tuple.get(0), tuple -> (Long) tuple.get(1)));

            productCountsByCategoryMap.forEach((category, count) -> {
                System.out.println(category + ":" + count);
            });
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showBasicProductInfoByCategory(String category) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<BasicProduct> allProductsQuery = null;
        EntityManager entityManager = null;
        List<BasicProduct> allProducts = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager
                    .createQuery("select new com.otms.bean.BasicProduct(p.productNo, p.productName, p.price) from Product p where p.category like :category", BasicProduct.class);
            allProductsQuery.setParameter("category", category);

            allProducts = allProductsQuery.getResultList();

            allProducts.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    // show me all the products manufactured by a specified manufacturer
    // implicit join
    private static void showAllProductsManufacturedBy(String manufacturerName) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Product> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Product> allProducts = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager
                    .createQuery("from Product p where p.manufacturer.businessName=:manufacturerName", Product.class);
            allProductsQuery.setParameter("manufacturerName", manufacturerName);

            allProducts = allProductsQuery.getResultList();

            allProducts.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showManufacturersByCategory(String category) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Manufacturer> allManufacturerQuery = null;
        EntityManager entityManager = null;
        List<Manufacturer> allManufacturers = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allManufacturerQuery = entityManager
                    .createQuery("from Manufacturer m inner join m.products p where p.category=:category", Manufacturer.class);
            allManufacturerQuery.setParameter("category", category);

            allManufacturers = allManufacturerQuery.getResultList();

            allManufacturers.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showProductsByManufacturerEstablishedDate(LocalDate date) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Product> allProductsQuery = null;
        EntityManager entityManager = null;
        List<Product> allProducts = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allProductsQuery = entityManager
                    .createQuery("from Product p where p.manufacturer.establishedDate<:date", Product.class);
            allProductsQuery.setParameter("date", date);

            allProducts = allProductsQuery.getResultList();

            allProducts.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showManufacturersWhereProductPriceGreater(double price) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Manufacturer> allManufacturerQuery = null;
        EntityManager entityManager = null;
        List<Manufacturer> allManufacturers = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allManufacturerQuery = entityManager
                    .createQuery("from Manufacturer m inner join m.products p where p.price>:price", Manufacturer.class);
            allManufacturerQuery.setParameter("price", price);

            allManufacturers = allManufacturerQuery.getResultList();

            allManufacturers.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showCountOfProductsByManufacturer(String manufacturerName) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Integer> countOfProductsQuery = null;
        EntityManager entityManager = null;
        List<Integer> countOfProducts = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            countOfProductsQuery = entityManager
                    .createQuery("select size(m.products) from Manufacturer m where m.businessName like :manufacturerName", Integer.class);
            countOfProductsQuery.setParameter("manufacturerName", manufacturerName);

            countOfProducts = countOfProductsQuery.getResultList();

            countOfProducts.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void showManufacturersAtleastProducts(int nProducts) {
        EntityManagerFactory entityManagerFactory = null;
        TypedQuery<Manufacturer> allManufacturerQuery = null;
        EntityManager entityManager = null;
        List<Manufacturer> allManufacturers = null;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            allManufacturerQuery = entityManager
                    .createQuery("from Manufacturer m where size(m.products) >= :nProducts", Manufacturer.class);
            allManufacturerQuery.setParameter("nProducts", nProducts);

            allManufacturers = allManufacturerQuery.getResultList();

            allManufacturers.forEach(System.out::println);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}














