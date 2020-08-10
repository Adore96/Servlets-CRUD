package com.controller;

import com.dao.userDAO;
import com.db.databaseConnection;
import com.model.studentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        studentInfo finalUpdateStudent = new studentInfo();
        userDAO userDAO = new userDAO();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("uname");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");

        finalUpdateStudent.setFname(fname);
        finalUpdateStudent.setLname(lname);
        finalUpdateStudent.setUsername(username);
        finalUpdateStudent.setPassword(password);
        finalUpdateStudent.setTelephone(telephone);

        userDAO.finalUpdate(finalUpdateStudent);

        response.sendRedirect(request.getContextPath()+"/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
