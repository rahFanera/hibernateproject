package com.fanera.hibernateproject.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fanera.hibernateproject.dao.OccuperDao;
import com.fanera.hibernateproject.model.Occuper;

@WebServlet("/OccuperList")
public class OccuperList extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OccuperDao occuperDao = new OccuperDao();

    public OccuperList() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Occuper> occupations = occuperDao.getAllOccupations();

        request.setAttribute("occupations", occupations);
        request.getRequestDispatcher("list-occupation.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
