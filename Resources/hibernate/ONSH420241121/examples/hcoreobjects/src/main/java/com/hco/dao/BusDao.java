package com.hco.dao;

import com.hco.entities.Bus;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BusDao {
    public Bus getBus(final int busNo, final SessionFactory sessionFactory) {
        Bus bus = null;
        Session session = null;

        try {
            session = sessionFactory.openSession();
            bus = session.get(Bus.class, busNo);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return bus;
    }
}
