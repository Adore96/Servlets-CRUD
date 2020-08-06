package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StudentInfo student = new StudentInfo();

        student.setUsername(request.getParameter("uname"));
        student.setPassword(request.getParameter("password"));

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.logIn(student);

        RequestDispatcher RD = request.getRequestDispatcher("/DashBoard.jsp");
        RD.include(request,response);
        System.out.println("DashBoard Response Called.");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
