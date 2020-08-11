package com.controller;

import com.dao.userDAO;
import com.model.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FinalUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo studentInfo = new StudentInfo();
        userDAO userDAO = new userDAO();

        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String telephone = request.getParameter("telephone");

        studentInfo.setFname(fname);
        studentInfo.setLname(lname);
        studentInfo.setUsername(username);
        studentInfo.setPassword(password);
        studentInfo.setTelephone(telephone);

        userDAO.finalUpdate(studentInfo);

        response.sendRedirect(request.getContextPath()+"/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
