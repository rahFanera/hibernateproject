package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import com.fanera.hibernateproject.model.Professeur;
import com.fanera.hibernateproject.dao.ProfesseurDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ProfesseurList")
public class ProfesseurList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfesseurDao professeurDao = new ProfesseurDao();

    public ProfesseurList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Professeur> professeurs = professeurDao.findAllProfesseurs();
        request.setAttribute("professeurs", professeurs);
        System.out.println(professeurs);
        request.getRequestDispatcher("/list-professeur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
