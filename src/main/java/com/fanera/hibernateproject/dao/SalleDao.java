package com.fanera.hibernateproject.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.fanera.hibernateproject.model.Salle;
import com.fanera.hibernateproject.util.HibernateUtil;

public class SalleDao {

    public void saveSalle(Salle salle) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(salle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Salle> getAllSalles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Salle", Salle.class).list();
        }
    }

    public void updateSalle(Salle salle) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(salle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteSalle(String codesalle) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Salle salle = session.get(Salle.class, codesalle);
            if (salle != null) {
                session.delete(salle);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Salle getSalleByCodesalle(String codesalle) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Salle.class, codesalle);
        }
    }
}
