package com.controller;

import com.dao.userDAO;
import com.model.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo student = new StudentInfo();
        userDAO userDAO = new userDAO();

        String fname = request.getParameter("fname").trim();
        String lname = request.getParameter("lname").trim();
        String telephone = request.getParameter("telephone").trim();
        String username = request.getParameter("uname").trim();
        String password = request.getParameter("password").trim();

        student.setFname(fname);
        student.setLname(lname);
        student.setTelephone(telephone);
        student.setUsername(username);
        student.setPassword(password);

        userDAO.registerStudent(student);

        response.sendRedirect(request.getContextPath()+"/users");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
