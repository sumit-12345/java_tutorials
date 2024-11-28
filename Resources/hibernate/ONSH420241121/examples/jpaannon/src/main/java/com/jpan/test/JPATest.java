package com.jpan.test;

import com.jpan.entities.Match;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPATest {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibpu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Match match = null;

        try {
            match = entityManager.find(Match.class, 1);
            System.out.println(match);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
