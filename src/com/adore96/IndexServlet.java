package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String telephone = request.getParameter("telephone");
        String uname = request.getParameter("uname");
        String password = request.getParameter("password");

        System.out.println(fname+""+lname);

        StudentInfo studentInfo = new StudentInfo(fname,lname,uname,password,telephone);
        DatabaseConnection databaseConnection = new DatabaseConnection();
        String result = databaseConnection.InsertValues(studentInfo);
        System.out.println(result);



        RequestDispatcher RD = request.getRequestDispatcher("/index.jsp");
        RD.include(request,response);
        System.out.println("Index Response Called.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
