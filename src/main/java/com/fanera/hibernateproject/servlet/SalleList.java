package com.fanera.hibernateproject.servlet;

import com.fanera.hibernateproject.model.Salle;
import com.fanera.hibernateproject.dao.SalleDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/SalleList")
public class SalleList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SalleDao salleDao = new SalleDao();

    public SalleList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Salle> salles = salleDao.getAllSalles();
        request.setAttribute("salles", salles);
        System.out.println(salles);
        request.getRequestDispatcher("list-salle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
