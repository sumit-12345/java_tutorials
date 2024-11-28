package com.otms.test;

import com.otms.entities.Manufacturer;
import com.otms.entities.Product;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class OTMSTest {
    public static void main(String[] args) {
        try {
            /*int productNo = saveProduct(Product.of().productName("Dell Laser Wireless Mouse")
                    .category("computers & electronics")
                    .description("Dell Mouse")
                    .price(1200).build());
            System.out.println("productNo : " + productNo);*/

            /*Product product1 = Product.of().productName("Toy Train")
                    .category("kids")
                    .description("Battery operated train")
                    .price(1200).build();
            saveProduct(product1);

            Product product2 = Product.of().productName("Figures")
                    .category("kids")
                    .description("Spiderman Figure")
                    .price(200).build();
            saveProduct(product2);

            Set<Product> products = Arrays.asList(product1, product2).stream().collect(Collectors.toSet());

            Manufacturer manufacturer = Manufacturer.of()
                    .businessName("CK Toys Enterprise")
                    .headQuarters("California")
                    .establishedDate(LocalDate.now().minusYears(7))
                    .contactNo("9383783834")
                    .emailAddress("info@cktoys.com")
                    .products(products).build();
            int manufacturerNo = saveManufacturer(manufacturer);

            System.out.println("manufacturer no : " + manufacturerNo);*/
            /*Product product = getProduct(2);
            System.out.println(product);*/

            printManufacturer(2);


        } finally {
            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static Product getProduct(int productNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Product product = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            product = entityManager.find(Product.class, productNo);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }
        return product;
    }

    private static void printManufacturer(int manufacturerNo) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        Manufacturer manufacturer = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();

            manufacturer = entityManager.find(Manufacturer.class, manufacturerNo);
            System.out.println(manufacturer.getBusinessName());
            manufacturer.getProducts().forEach(System.out::println);
        } finally {
            if (entityManager != null) {

                entityManager.close();
            }
        }

    }

    private static int saveProduct(Product product) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int productNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(product);
            productNo = product.getProductNo();

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
        return productNo;
    }

    private static int saveManufacturer(Manufacturer manufacturer) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int manufacturerNo = 0;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(manufacturer);
            manufacturerNo = manufacturer.getManufacturerNo();

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
        return manufacturerNo;
    }
}
