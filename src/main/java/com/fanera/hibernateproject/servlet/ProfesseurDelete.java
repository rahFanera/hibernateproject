package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fanera.hibernateproject.dao.ProfesseurDao;

@WebServlet("/ProfesseurDelete")
public class ProfesseurDelete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProfesseurDao professeurDao = new ProfesseurDao();

    public ProfesseurDelete() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String codeprof = req.getParameter("codeprof");
        professeurDao.deleteProfesseur(codeprof);
        resp.sendRedirect("ProfesseurList");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
