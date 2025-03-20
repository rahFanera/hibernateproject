package com.fanera.hibernateproject.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import com.fanera.hibernateproject.model.Professeur;
import com.fanera.hibernateproject.util.HibernateUtil;
import org.hibernate.query.Query;

public class ProfesseurDao {

    public void saveProfesseur(Professeur professeur) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("codeprof: " + professeur.getCodeprof());
            System.out.println("nom: " + professeur.getNom());
            System.out.println("prenom: " + professeur.getPrenom());
            System.out.println("grade: " + professeur.getGrade());
            session.persist(professeur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Professeur> findAllProfesseurs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Professeur", Professeur.class).list();
        }
    }

    public void updateProfesseur(Professeur professeur) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(professeur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteProfesseur(String codeprof) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Professeur professeur = session.get(Professeur.class, codeprof);
            if (professeur != null) {
                session.remove(professeur);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Professeur getProfesseurByCodeprof(String codeprof) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Professeur.class, codeprof);
        }
    }

    public List<Professeur> searchProfs(String keyword) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Professeur p WHERE LOWER(p.codeprof) LIKE :keyword OR LOWER(p.nom) LIKE :keyword OR LOWER(p.prenom) LIKE :keyword OR LOWER(p.grade) LIKE :keyword";

            Query<Professeur> query = session.createQuery(hql, Professeur.class);
            query.setParameter("keyword", "%" + keyword.toLowerCase() + "%");

            return query.getResultList();
        }
    }
}
