package com.hibernatetools.test;

import com.hibernatetools.entities.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HBM2DDLTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        boolean flag = false;

        try {
            Address address = new Address();
            address.setAddressNo(1011);
            address.setAddressLine1("19383 Max street");
            address.setAddressLine2("downtown");
            address.setCity("Kenneson");
            address.setState("Tx");
            address.setZip(29338);
            address.setCounty("USA");

            session.persist(address);
            flag = true;
        } finally {
            if (transaction != null) {
                if (flag) {
                    transaction.commit();
                } else {
                    transaction.rollback();
                }
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }
}
