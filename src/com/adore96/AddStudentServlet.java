package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo student = new StudentInfo();
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String telephone = request.getParameter("telephone");
        String username = request.getParameter("uname");
        String password = request.getParameter("password");

        student.setFname(fname);
        student.setLname(lname);
        student.setTelephone(telephone);
        student.setUsername(username);
        student.setPassword(password);

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.registerStudent(student);

        RequestDispatcher RD = request.getRequestDispatcher("/DashBoard.jsp");
        RD.include(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
