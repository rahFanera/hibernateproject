package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import com.fanera.hibernateproject.dao.OccuperDao;
import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.dao.SalleDao;
import com.fanera.hibernateproject.model.Occuper;
import com.fanera.hibernateproject.model.Professeur;
import com.fanera.hibernateproject.model.Salle;

@WebServlet("/OccuperUpdate")
public class OccuperUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OccuperDao occuperDao = new OccuperDao();
    private SalleDao salleDao = new SalleDao();
    private ProfesseurDao profDao = new ProfesseurDao();

    public OccuperUpdate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codeoccuper"));
        Occuper occuper = occuperDao.getOccupationByCodeoccuper(id);

        if (occuper != null) {
            request.setAttribute("occuper", occuper);
            request.getRequestDispatcher("/update-occupation.jsp").forward(request, response);
        } else {
            response.sendRedirect("list-occupation.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("codeoccuper"));

        String codeprof = request.getParameter("codeprof");
        String codesalle = request.getParameter("codesalle");
        Date date = Date.valueOf(request.getParameter("date"));

        Occuper occuper = occuperDao.getOccupationByCodeoccuper(id);
        if (occuper != null) {
            Professeur professeur = profDao.getProfesseurByCodeprof(codeprof);
            Salle salle = salleDao.getSalleByCodesalle(codesalle);
            occuper.setProfesseur(professeur);
            occuper.setSalle(salle);
            occuper.setDate(date);

            occuperDao.updateOccupation(occuper);
        }

        response.sendRedirect("OccuperList");
    }
}
