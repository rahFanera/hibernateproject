package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fanera.hibernateproject.dao.OccuperDao;
import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.dao.SalleDao;
import com.fanera.hibernateproject.model.Occuper;
import com.fanera.hibernateproject.model.Professeur;
import com.fanera.hibernateproject.model.Salle;

@WebServlet("/OccuperEdit")
public class OccuperEdit extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OccuperDao occuperDao = new OccuperDao();
    private ProfesseurDao profDao = new ProfesseurDao();
    private SalleDao salleDao = new SalleDao();

    public OccuperEdit() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codeoccuper"));
        Occuper occuper = occuperDao.getOccupationByCodeoccuper(id);

        List<Professeur> professeurs = profDao.findAllProfesseurs();
        List<Salle> salles = salleDao.getAllSalles();

        request.setAttribute("occuper", occuper);
        request.setAttribute("professeurs", professeurs);
        request.setAttribute("salles", salles);

        request.getRequestDispatcher("OccuperUpdate").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
