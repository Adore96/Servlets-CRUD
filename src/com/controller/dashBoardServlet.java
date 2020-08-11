package com.controller;

import com.dao.userDAO;
import com.model.StudentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class dashBoardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        databaseConnection databaseConnection = new databaseConnection();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDAO userDAO = new userDAO();

        List<StudentInfo> listUser = userDAO.ShowTable();

        request.setAttribute("listUser", listUser);

        RequestDispatcher dispatcher = request.getRequestDispatcher("DashBoard.jsp");
        dispatcher.forward(request, response);
    }
}
