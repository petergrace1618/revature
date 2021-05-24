package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Reader[] readers = new Reader[] {
                new Reader("Levar Burton"),
                new Reader("Miley Cyrus")
        };
        Book[] books = new Book[] {
                new Book("The Scarlet Letter"),
                new Book("Dreams From My Father"),
                new Book("Dr. Seuss: Collected Works")
        };
        for (Reader r: readers)
            session.save(r);
        for (Book b: books)
            session.save(b);

        readers[0].addBook(books[0]);
        readers[0].addBook(books[1]);
        readers[1].addBook(books[2]);

        session.persist(readers[0]);
        session.persist(readers[1]);

        transaction.commit();
        session.close();
        factory.close();
    }
}
