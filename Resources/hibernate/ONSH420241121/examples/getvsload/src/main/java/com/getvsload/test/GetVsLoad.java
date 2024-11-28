package com.getvsload.test;

import com.getvsload.entities.Customer;
import com.getvsload.entities.ICustomer;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetVsLoad {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            useofFinalTurnsOfLazyLoading(session);
        } finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }
    }

    private static void eagerVsLazy(Session session) {
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer.getClass().getCanonicalName());

       /* Customer customer = session.load(Customer.class, 1);
        System.out.println("load returned proxy, now about to access the data using proxy below");
        System.out.println(customer.getFullname());
        System.out.println("customer classType : " + customer.getClass().getCanonicalName());*/
    }

    private static void noRecordExists(Session session) {
        Customer customer = session.get(Customer.class, 2); // there is no record exists for customer_no = 2
        System.out.println(customer); // prints null

        Customer customer1 = session.load(Customer.class, 2);
        if (customer1 != null) {
            System.out.println("object found");
        } else {
            System.out.println("no object found");
        }
        System.out.println(customer1.getFullname());
    }

    private static void safeOperation(Session session) {
        Customer customer = session.get(Customer.class, 2); // there is no record exists for customer_no = 2

        // safe to check against null before using the data
        if (customer != null) {
            System.out.println(customer.getFullname());
        } else {
            System.out.println("no customer found for customerno : 2");
        }

        // non-safe and should surround in try/catch block while using load
        try {
            Customer customer1 = session.load(Customer.class, 2);
            System.out.println(customer1.getFullname());
        } catch (ObjectNotFoundException e) {
            System.out.println("no customer found for customerno : 2");
        }
    }

    private static void activeSessionReq(Session session) {
        Customer customer1 = session.get(Customer.class, 1);
        //Customer customer2 = session.load(Customer.class, 1);

        session.close();
        System.out.println("session is closed");
        //System.out.println("access data from load(..) returned customer2 object : " + customer2.getFullname());
        System.out.println("access data from get(..) returned customer1 object : " + customer1.getFullname());
    }

    private static void defaultToLazyButCanTurnOff(Session session) {
        Customer customer2 = session.load(Customer.class, 1); // doesnt hit the data and loads the data
    }

    private static void useofFinalTurnsOfLazyLoading(Session session) {
        ICustomer customer2 = session.load(Customer.class, 1); // if final, it works as get(..)
        System.out.println("supports lazy loading, and will not query upon calling load");

        System.out.println("now trying to access the data:  " + customer2.getFullname());
    }
}
