package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.SalleDao;

@WebServlet("/SalleDelete")
public class SalleDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SalleDao salleDao = new SalleDao();

    public SalleDelete() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codesalle = request.getParameter("codesalle");
        salleDao.deleteSalle(codesalle);
        response.sendRedirect("SalleList");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
