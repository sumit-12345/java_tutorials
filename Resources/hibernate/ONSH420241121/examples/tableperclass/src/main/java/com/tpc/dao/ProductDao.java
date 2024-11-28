package com.tpc.dao;

import com.tpc.entities.Product;
import com.tpc.entities.Shoe;
import com.tpc.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class ProductDao {
    public int saveProduct(final Product product) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(product);


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
        return product.getId();
    }

    public Shoe findShoe(int id) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        Shoe shoe = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            shoe = entityManager.find(Shoe.class, id);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return shoe;
    }

    public Product findProduct(int id) {
        EntityManagerFactory entityManagerFactory = EMFRegistry.getEntityManagerFactory();
        EntityManager entityManager = null;
        Product product = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            product = entityManager.find(Product.class, id);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return product;
    }
}
