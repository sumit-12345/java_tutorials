package com.hco;

import com.hco.dao.BusDao;
import com.hco.entities.Bus;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HCOTest {
    public static void main(String[] args) {
        Bus bus = null;
        BusDao busDao = null;
        Configuration configuration = null;
        SessionFactory sessionFactory = null;

        try {
            configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();

            busDao = new BusDao();
            bus = busDao.getBus(1, sessionFactory);
            System.out.println(bus);

        } finally {
            if (sessionFactory != null && sessionFactory.isOpen()) {
                sessionFactory.close();
            }
        }
    }
}
