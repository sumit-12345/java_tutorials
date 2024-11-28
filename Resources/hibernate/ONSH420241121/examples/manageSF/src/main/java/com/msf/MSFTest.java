package com.msf;

import com.msf.dao.BookDao;
import com.msf.entities.Book;
import com.msf.helper.SessionFactoryRegistry;

public class MSFTest {
    public static void main(String[] args) {
        BookDao bookDao = null;
        Book book = null;

        try {
            bookDao = new BookDao();
            book = bookDao.getBook(1);
            System.out.println(book);
        } finally {
            SessionFactoryRegistry.closeSessionFactory();
        }
    }
}
