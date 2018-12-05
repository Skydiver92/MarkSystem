package com.kuzmenko.marksystem.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateAnnotationUtil {
    private static SessionFactory sessionFactory;
    protected static Session session;

    private SessionFactory buildSessionFactory() {

//        Configuration configuration = new Configuration().configure();
//        configuration.addAnnotatedClass(Student.class);
//        configuration.addAnnotatedClass(Subject.class);
//        configuration.addAnnotatedClass(Mark.class);
//        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
//        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());

        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        System.out.println("Hibernate Configuration loaded");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                //applySettings(configuration.getProperties())
                .build();
        System.out.println("Hibernate serviceRegistry created");

        Metadata meta = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();
        //2SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
        //1 SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) sessionFactory = buildSessionFactory();
        return sessionFactory;
    }

    public Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession();
        }
        return session;
    }

    public void closeSession() {
        if (session.isOpen()) session.close();
    }
}
