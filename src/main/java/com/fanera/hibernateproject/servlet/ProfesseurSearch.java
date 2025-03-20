package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.model.Professeur;

@WebServlet("/ProfesseurSearch")
public class ProfesseurSearch extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfesseurDao professeurDao = new ProfesseurDao();

    public ProfesseurSearch() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");

        List<Professeur> professeurs = professeurDao.searchProfs(keyword);
        request.setAttribute("professeurs", professeurs);
        request.getRequestDispatcher("list-professeur.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
