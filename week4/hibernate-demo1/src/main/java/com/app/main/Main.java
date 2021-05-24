package com.app.main;

import com.app.model.Player;
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

//        Player p1 = new Player(1, "Kilmeister");
//        Player p2 = new Player(2, "Butkis");
//        Player p3 = new Player(3, "Samson");
//
//        session.save(p1);
//        session.save(p2);
//        session.save(p3);
//
//        Player p = (Player) session.get(Player.class, 1);
//        System.out.println(p);

        Player p1 = new Player( "Kilmeister", 111111111);
        Player p2 = new Player( "Butkis",222222222);
        Player p3 = new Player( "Samson",333333333);

        session.save(p1);
        session.save(p2);
        session.save(p3);

        transaction.commit();
        session.close();
        factory.close();
    }
}
