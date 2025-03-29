package com.fanera.hibernateproject.util;

import com.fanera.hibernateproject.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new Configuration()
                    .addAnnotatedClass(Professeur.class)
                    .addAnnotatedClass(Salle.class)
                    .addAnnotatedClass(Occuper.class)
                    .buildSessionFactory();
        }catch (Throwable e){
            System.err.println("Initialization failed :" + e);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
