package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.OccuperDao;
import com.fanera.hibernateproject.dao.ProfesseurDao;
import com.fanera.hibernateproject.dao.SalleDao;
import com.fanera.hibernateproject.model.Occuper;
import com.fanera.hibernateproject.model.Professeur;
import com.fanera.hibernateproject.model.Salle;

import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/OccuperAdd")
public class OccuperAdd extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OccuperDao occuperDao = new OccuperDao();

    public OccuperAdd() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String codeprof = request.getParameter("codeprof");
            String codesalle = request.getParameter("codesalle");
            String dateStr = request.getParameter("date");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            ProfesseurDao professeurDao = new ProfesseurDao();
            SalleDao salleDao = new SalleDao();

            Professeur professeur = professeurDao.getProfesseurByCodeprof(codeprof);
            Salle salle = salleDao.getSalleByCodesalle(codesalle);

            if (professeur == null || salle == null) {
                response.getWriter().write("Erreur: Prof ou Salle introuvable !");
                return;
            }

            Occuper occupation = new Occuper();
            occupation.setProfesseur(professeur);
            occupation.setSalle(salle);
            occupation.setDate(date);

            occuperDao.saveOccupation(occupation);

            response.sendRedirect("OccuperList");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
