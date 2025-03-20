package com.fanera.hibernateproject.dao;

import com.fanera.hibernateproject.model.Occuper;
import com.fanera.hibernateproject.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OccuperDao {

    public void saveOccupation(Occuper occuper) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            if (occuper.getProfesseur() == null || occuper.getSalle() == null) {
                throw new IllegalArgumentException("Prof et Salle ne peuvent pas etre null !");
            }
            session.persist(occuper);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Occuper getOccupationByCodeoccuper(int codeoccuper) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Occuper.class, codeoccuper);
        }
    }

    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Occuper> getAllOccupations() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Occuper", Occuper.class).list();
        }
    }

    public void updateOccupation(Occuper occuper) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Occuper existingOccuper = session.get(Occuper.class, occuper.getCodeoccuper());
            if (existingOccuper != null) {
                if (occuper.getProfesseur() != null && occuper.getSalle() != null) {
                    existingOccuper.setProfesseur(occuper.getProfesseur());
                    existingOccuper.setSalle(occuper.getSalle());
                }
                existingOccuper.setDate(occuper.getDate());
                session.merge(existingOccuper);
                transaction.commit();
            } else {
                System.out.println("Occupation non trouvée pour le codeoccuper: " + occuper.getCodeoccuper());
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void deleteOccupation(int codeoccuper) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Occuper occuper = session.get(Occuper.class, codeoccuper);
            if (occuper != null) {
                session.remove(occuper);
                System.out.println("Occupation supprimée avec succès !");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Occuper> searchOccupations(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Occuper o " +
                    "JOIN o.professeur p " +
                    "JOIN o.salle s " +
                    "WHERE LOWER(p.nom) LIKE :keyword OR LOWER(p.prenom) LIKE :keyword " +
                    "OR LOWER(s.designation) LIKE :keyword";

            Query<Occuper> query = session.createQuery(hql, Occuper.class);
            query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");

            return query.getResultList();
        }
    }
}
