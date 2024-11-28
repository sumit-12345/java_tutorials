package com.otms.test;

import com.otms.entities.Manufacturer;
import com.otms.entities.Product;
import com.otms.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.Iterator;
import java.util.Set;

public class OrphanRemovalTest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;

        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Manufacturer manufacturer = entityManager.find(Manufacturer.class, 3);
            Set<Product> products = manufacturer.getProducts();

            Iterator<Product> iterator  = products.iterator();
            while(iterator.hasNext()) {
                Product product = iterator.next();
                if(product.getPrice() < 1000) {
                    iterator.remove();
                }
            }
            entityManager.merge(manufacturer);

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

    }
}
