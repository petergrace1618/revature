package com.app.main;

import com.app.model.Album;
import com.app.model.Artist;
import com.app.model.Manager;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory factory = configuration.buildSessionFactory(builder.build());
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Artist[] aa = {
                new Artist("Def Leppard", "England", 1976),
                new Artist("Sadus", "Los Angeles", 1990),
                new Artist("Deicide", "Tampa, Florida", 1988),
                new Artist("Oingo Boingo", "Los Angeles", 1979),
                new Artist("Black Sabbath", "England", 1968),
                new Artist("The Residents", "Louisiana", 1969),
                new Artist("GWAR", "Antarctica", 1984),
                new Artist("Miley Cyrus", "My butt", 2021)
        };
        Manager m = new Manager("Bob Rock", "The Ragency");
        session.save(m);
        for (Artist a: aa) {
            a.setManager(m);
            session.save(a);
        }

        Query query = session.createQuery("from com.app.model.Artist where name=:name");
        String s = "Oingo Boingo";
        query.setString("name", s);
        List<Artist> artists = query.list();

        System.out.println("-----------------");
        System.out.println("QUERY RESULTS");
        System.out.printf("%d artist(s) found matching '%s'%n", artists.size(), s);
        for(Artist artist: artists) {
            System.out.println(artist);
        }
        System.out.println("-----------------");

        Criteria criteria = session.createCriteria(Artist.class);
        SimpleExpression se = Restrictions.gt("yearFormed",1980);
        criteria.add(se);
        artists = criteria.list();

        System.out.println("-----------------");
        System.out.println("QUERY WITH CRITERIA RESULTS");
        System.out.printf("%d artist(s) found matching criteria '%s'%n", artists.size(), se);
        for(Artist artist: artists) {
            System.out.println(artist);
        }
        System.out.println("-----------------");

        System.out.println("-----------------");
        System.out.println("UPDATE RESULTS");
        query = session.createQuery("from com.app.model.Artist where name=:name");
        s = "Def Leppard";
        query.setString("name", s);
        artists = query.list();
        try {
            Artist artist = artists.get(0);

            Album a = new Album("On Through the Night", 1980);
            session.save(a);
            artist.addAlbum(a);

            a = new Album("High and Dry", 1980);
            session.save(a);
            artist.addAlbum(a);

            a = new Album("Pyromania", 1980);
            session.save(a);
            artist.addAlbum(a);

            System.out.println(artist);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("-----------------");

        query = session.createQuery("from com.app.model.Artist where location=:location");
        query.setString("location", "My butt");
        artists = query.list();
        try {
            session.delete(artists.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        transaction.commit();
        session.close();
        factory.close();
    }
}
