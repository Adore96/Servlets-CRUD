package com.controller;

import com.dao.userDAO;
import com.db.DatabaseConnection;
import com.model.StudentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DashboardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DatabaseConnection databaseConnection = new DatabaseConnection();
        userDAO userDAO = new userDAO();


        List<StudentInfo> listUser = userDAO.ShowTable();
        request.setAttribute("listUser", listUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);



//        RequestDispatcher RD = request.getRequestDispatcher("/DashBoard.jsp");
//        RD.include(request,response);
//        System.out.println("DashBoard Response Called.");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
