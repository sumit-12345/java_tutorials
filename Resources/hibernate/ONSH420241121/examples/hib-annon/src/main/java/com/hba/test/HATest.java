package com.hba.test;

import com.hba.dao.AccountDao;
import com.hba.entities.Account;
import com.hba.helper.SessionFactoryRegistry;

public class HATest {
    public static void main(String[] args) {
        AccountDao accountDao = null;
        Account account = null;

        try {
            accountDao = new AccountDao();
            account = accountDao.findAccount(12);
            System.out.println(account);
        } finally {
            SessionFactoryRegistry.closeSessionFactory();
        }
    }
}
