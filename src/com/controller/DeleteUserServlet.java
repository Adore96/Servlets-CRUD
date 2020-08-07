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

public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentInfo student = new StudentInfo();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        userDAO userDAO = new userDAO();

        String username = request.getParameter("uname");
        student.setUsername(username);

//        List<StudentInfo> listUser = userDAO.ShowTable();
//        System.out.println(listUser.get(1));

        RequestDispatcher RD = request.getRequestDispatcher("/Login.jsp");
        RD.include(request,response);
        System.out.println("Index Response Called.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
