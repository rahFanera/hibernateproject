package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.model.Professeur;

@WebServlet("/ProfesseurAdd")
public class ProfesseurAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfesseurDao professeurDao = new ProfesseurDao();

    public ProfesseurAdd() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add-professeur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String grade = req.getParameter("grade");
        String codeprof = req.getParameter("codeprof");

        Professeur professeur = new Professeur(codeprof, nom, prenom, grade);
        professeurDao.saveProfesseur(professeur);
        resp.sendRedirect("ProfesseurList");
    }
}
