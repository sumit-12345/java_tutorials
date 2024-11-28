package com.dmlops.dao;

import com.dmlops.entities.TrafficChallan;
import com.dmlops.helper.SessionFactoryRegistry;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TrafficChallanDao {

    public int saveTrafficChallan(TrafficChallan trafficChallan) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        int challanNo = 0;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            challanNo = (Integer) session.save(trafficChallan);
            System.out.println("from entity challan no : " + trafficChallan.getChallanNo());

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
        }

        return challanNo;
    }

    public int persistTrafficChallan(TrafficChallan trafficChallan) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        int challanNo = 0;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(trafficChallan);
            challanNo = trafficChallan.getChallanNo();

            System.out.println("from entity challan no : " + trafficChallan.getChallanNo());

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
        }

        return challanNo;
    }

    public int saveOrUpdateTrafficChallan(TrafficChallan trafficChallan) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        int challanNo = 0;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(trafficChallan);

            challanNo = trafficChallan.getChallanNo();

            System.out.println("from entity challan no : " + trafficChallan.getChallanNo());

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
        }
        return challanNo;
    }


    public void updateTrafficChallan(TrafficChallan trafficChallan) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(trafficChallan);

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
        }
    }

    public void updateTrafficChallan(int challanNo, String reasonForChallan, double amount) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        TrafficChallan trafficChallan = null;
        boolean flag = false;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            trafficChallan = session.get(TrafficChallan.class, challanNo);
            trafficChallan.setReasonForChallan(reasonForChallan);
            trafficChallan.setAmount(amount);

            session.update(trafficChallan);
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
        }

    }

    public void mergeTrafficChallan(TrafficChallan trafficChallan) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            // fetched the existing object from database and associated with session
            session.get(TrafficChallan.class, trafficChallan.getChallanNo());


            session.merge(trafficChallan);

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
        }
    }

    public void deleteTrafficChallan(String vehicleRegistrationNo) {
        SessionFactory sessionFactory = null;
        Transaction transaction = null;
        List<TrafficChallan> trafficChallans = null;
        boolean flag = false;
        TypedQuery<TrafficChallan> trafficChallanTypedQuery = null;

        sessionFactory = SessionFactoryRegistry.getSessionFactory();
        final Session session = sessionFactory.openSession();
        transaction = session.beginTransaction();
        try {
            trafficChallanTypedQuery = session.createQuery("from TrafficChallan tc where tc.vehicleRegistrationNo=:vrn");
            trafficChallanTypedQuery.setParameter("vrn", vehicleRegistrationNo);
            trafficChallans = trafficChallanTypedQuery.getResultList();

            trafficChallans.forEach(trafficChallan -> {
                session.remove(trafficChallan);
            });


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
        }
    }

    public void deleteTrafficChallan(int challanNo) {
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;
        TrafficChallan trafficChallan = null;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            trafficChallan = new TrafficChallan();
            trafficChallan.setChallanNo(challanNo);
            session.remove(trafficChallan);

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
        }
    }
}


















