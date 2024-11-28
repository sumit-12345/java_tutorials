package com.hba.dao;

import com.hba.entities.Account;
import com.hba.helper.SessionFactoryRegistry;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AccountDao {
    public Account findAccount(int accountNo) {
        SessionFactory sessionFactory = null;
        Account account = null;
        Session session = null;

        try {
            sessionFactory = SessionFactoryRegistry.getSessionFactory();
            session = sessionFactory.openSession();

            account = session.get(Account.class, accountNo);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return account;
    }
}
