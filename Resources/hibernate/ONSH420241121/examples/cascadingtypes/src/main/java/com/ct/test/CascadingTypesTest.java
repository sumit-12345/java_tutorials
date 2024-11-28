package com.ct.test;

import com.ct.entities.Author;
import com.ct.entities.Book;
import com.ct.helper.EMFRegistry;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;

public class CascadingTypesTest {
    public static void main(String[] args) {
        try {
            //cascadeTypePersist();
            //cascadeTypeMerge();
            //cascadeTypeRemove();
            //cascadeTypeRefresh();
            cascadeTypeDetach();
        } finally {

            EMFRegistry.closeEntityManagerFactory();
        }
    }

    private static void cascadeTypePersist() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author author = Author.of()
                    .dob(LocalDate.now().minusDays(7473))
                    .contactNo("8383892728")
                    .fullName("Steve Johnson")
                    .emailAddress("steve.j@gmail.com")
                    .gender("Male")
                    .build();


            Book book = Book.of()
                    .title("All times New york City")
                    .language("english")
                    .publishedDate(LocalDate.now().minusDays(5000))
                    .genre("fiction")
                    .price(500)
                    .author(author)
                    .build();

            /**
             * In book entity, we associated a transient author entity object. Now if we try persisting the book
             *  without: @ManyToOne(cascade=CascadeType.PERSIST), it results in exception
             */

            entityManager.persist(book);
            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
                entityManager.close();
            }
        }
    }

    private static void cascadeTypeMerge() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        String isbn = null;

        // let us store book & author entity objects, so that we can update the existing entities to verify
        // CascadeType.MERGE
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author author = Author.of()
                    .dob(LocalDate.now().minusDays(8937))
                    .contactNo("9898767679")
                    .fullName("Robert Wunderlitch")
                    .emailAddress("robert.w@gmail.com")
                    .gender("Male")
                    .build();
            entityManager.persist(author);


            Book book = Book.of()
                    .title("Dress like a girl")
                    .language("english")
                    .publishedDate(LocalDate.now().minusDays(4500))
                    .genre("fiction")
                    .price(240)
                    .author(author)
                    .build();

            entityManager.persist(book);
            isbn = book.getIsbn();

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }

        // Fetch the above persisted book entity based on isbn
        // then update book and its associated author as well
        // try only merging the book, the associated author object will not be updated if we dont use CascadeType.MERGE
        flag = false;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Book existingBook = entityManager.find(Book.class, isbn);
            Author existingAuthor = existingBook.getAuthor();

            entityManager.clear(); // detach both the entities

            existingBook.setPrice(250);
            existingAuthor.setContactNo("989898989898");
            entityManager.merge(existingBook);

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }
    }

    private static void cascadeTypeRemove() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        int authorId = 12;

        // let us store book & author entity objects, so that we can update the existing entities to verify
        // CascadeType.MERGE
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author author = Author.of()
                    .dob(LocalDate.now().minusDays(9898))
                    .contactNo("8376367889")
                    .fullName("John Wick")
                    .emailAddress("john.w@gmail.com")
                    .gender("Male")
                    .build();
            entityManager.persist(author);


            Book book = Book.of()
                    .title("Holidays")
                    .language("english")
                    .publishedDate(LocalDate.now().minusDays(4500))
                    .genre("fiction")
                    .price(340)
                    .author(author)
                    .build();

            entityManager.persist(book);
            authorId = author.getAuthorId();
            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }

        // let us try to delete or remove the existing author we persisted above
        flag = false;
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author existingAuthor = entityManager.find(Author.class, authorId);

            // inorder to delete the author, we need to delete all the associated books of the author as below
            /*Set<Book> books  = existingAuthor.getBooks();

            Iterator it = books.iterator();
            while(it.hasNext()) {
                Book book = (Book) it.next();
                it.remove();
                entityManager.remove(book);
            }*/


            entityManager.remove(existingAuthor);

            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }

    }

    private static void cascadeTypeRefresh() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        String isbn = null;

        // let us store book & author entity objects, so that we can check refresh on target and associated object
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author author = Author.of()
                    .dob(LocalDate.now().minusDays(8797))
                    .contactNo("8374384944")
                    .fullName("Anderson J")
                    .emailAddress("anderson.j@gmail.com")
                    .gender("Male")
                    .build();
            entityManager.persist(author);


            Book book = Book.of()
                    .title("Indian Festivals")
                    .language("english")
                    .publishedDate(LocalDate.now().minusDays(6000))
                    .genre("non-fiction")
                    .price(1340)
                    .author(author)
                    .build();

            entityManager.persist(book);
            isbn = book.getIsbn();
            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }

        // let us try fetching the author, and modify the attributes of data along with associated object
        flag = false;
        try {
            Book existingBook = entityManager.find(Book.class, isbn);
            Author existingAuthor = existingBook.getAuthor();

            existingAuthor.setGender("Female");
            existingBook.setPrice(500);

            entityManager.refresh(existingBook);

            // when we refresh the book, the associated author of the book will not be refreshed unless we use CascadeType.REFRESH
            System.out.println("gender : " + existingAuthor.getGender());
            System.out.println("price : " + existingBook.getPrice());

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    private static void cascadeTypeDetach() {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        boolean flag = false;
        String isbn = null;

        // let us store book & author entity objects, so that we can check detach on target and associated object
        try {
            entityManagerFactory = EMFRegistry.getEntityManagerFactory();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Author author = Author.of()
                    .dob(LocalDate.now().minusDays(8797))
                    .contactNo("8374384944")
                    .fullName("Anderson J")
                    .emailAddress("anderson.j@gmail.com")
                    .gender("Male")
                    .build();
            entityManager.persist(author);


            Book book = Book.of()
                    .title("Indian Festivals")
                    .language("english")
                    .publishedDate(LocalDate.now().minusDays(6000))
                    .genre("non-fiction")
                    .price(1340)
                    .author(author)
                    .build();

            entityManager.persist(book);
            isbn = book.getIsbn();
            flag = true;
        } finally {
            if (entityTransaction != null) {
                if (flag) {
                    entityTransaction.commit();
                } else {
                    entityTransaction.rollback();
                }
            }
        }

        // let us try fetching the author, and modify the attributes of data along with associated object
        flag = false;
        try {
            Book existingBook = entityManager.find(Book.class, isbn);
            Author existingAuthor = existingBook.getAuthor();

            entityManager.detach(existingBook);

            System.out.println("book is in session? : " + entityManager.contains(existingBook));
            System.out.println("author is in session? : " + entityManager.contains(existingAuthor));
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}










