package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.SalleDao;
import com.fanera.hibernateproject.model.Salle;

@WebServlet("/SalleUpdate")
public class SalleUpdate  extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SalleDao salleDao = new SalleDao();

    public SalleUpdate() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codesalle = request.getParameter("codesalle");
        Salle salle = salleDao.getSalleByCodesalle(codesalle);
        request.setAttribute("salle", salle);
        request.getRequestDispatcher("update-salle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codesalle = request.getParameter("codesalle");
        String designation = request.getParameter("designation");

        Salle salle = new Salle(designation);
        salle.setCodesalle(codesalle);
        salleDao.updateSalle(salle);
        response.sendRedirect("SalleList");
    }
}
