package com.hb3.test;

import com.hb3.entities.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlHb3BootStrappingTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("com/hb3/config/hb3-hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            Passport passport = session.get(Passport.class, 1);
            System.out.println(passport);
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }
}
