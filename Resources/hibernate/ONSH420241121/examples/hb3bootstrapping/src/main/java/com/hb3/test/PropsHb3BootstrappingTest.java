package com.hb3.test;

import com.hb3.entities.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PropsHb3BootstrappingTest {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        // default constructor: it looks for the hibernate1.properties file under the classpath and loads into
        // the Configuration object

        configuration.addResource("com/hb3/entities/Passport.hbm.xml");
        // add the mapping files into the Configuration object

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
