package com.hb3.test;

import com.hb3.entities.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class ProgHb3BootStrapping {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(ProgHb3BootStrapping.class.getClassLoader().getResourceAsStream("db.properties"));

        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("db.driverClassname"));
        configuration.setProperty("hibernate.connection.url", properties.getProperty("db.url"));
        configuration.setProperty("hibernate.connection.username", properties.getProperty("db.username"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("db.password"));

        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addResource("com/hb3/entities/Passport.hbm.xml");

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
