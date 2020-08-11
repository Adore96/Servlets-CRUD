package com.controller;

import com.dao.userDAO;
import com.model.StudentInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class deleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dont write anything here.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDAO userDAO = new userDAO();
        StudentInfo studentInfo = new StudentInfo();

        String username = request.getParameter("username");

        studentInfo.setUsername(username);

        try {
            userDAO.DeleteUser(studentInfo);
            response.sendRedirect(request.getContextPath()+"/users");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Error in delete student Servlet : "+throwables);
        }
    }
}

