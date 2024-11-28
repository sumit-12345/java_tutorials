package com.inverse.test;

import com.inverse.entities.Manufacturer;
import com.inverse.entities.Product;
import com.inverse.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InverseTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        Manufacturer manufacturer = null;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            /*Product product = Product
                    .of()
                    .productName("Mens Polo T-Shirt")
                    .description("Mens T-shirt")
                    .category("Fashion and Accessories")
                    .price(2300).build();

            Manufacturer manufacturer = Manufacturer
                    .of()
                    .businessName("Uncle Thompsons Store")
                    .establishedDate(LocalDate.now().minusDays(786))
                    .contactNo("91-2938437498")
                    .emailAddress("noreply@thompsonstores.com")
                    .products(new HashSet<>(Arrays.asList(product))).build();
            product.setManufacturer(manufacturer);

            entityManager.persist(manufacturer);
            entityManager.persist(product);*/

            manufacturer = entityManager.find(Manufacturer.class,1);
            System.out.println(manufacturer.getBusinessName());



            flag = true;
        }finally {
            if(entityTransaction != null) {
                if(flag) {
                    entityTransaction.commit();
                }else {
                    entityTransaction.rollback();
                }
                entityManager.close();
            }
            EMFRegistry.closeEntityManagerFactory();
        }
        Set<Product> products = manufacturer.getProducts();
        products.forEach(System.out::println);
    }
}
