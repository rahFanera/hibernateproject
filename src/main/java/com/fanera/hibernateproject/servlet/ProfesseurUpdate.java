package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.model.Professeur;

@WebServlet("/ProfesseurUpdate")
public class ProfesseurUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfesseurDao professeurDao = new ProfesseurDao();

    public ProfesseurUpdate() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeprof = req.getParameter("codeprof");
        Professeur professeur = professeurDao.getProfesseurByCodeprof(codeprof);
        req.setAttribute("professeur", professeur);
        req.getRequestDispatcher("update-professeur.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeprof = req.getParameter("codeprof");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String grade = req.getParameter("grade");

        Professeur professeur = new Professeur(nom, prenom, grade);
        professeur.setCodeprof(codeprof);
        professeurDao.updateProfesseur(professeur);
        resp.sendRedirect("ProfesseurList");
    }

}
