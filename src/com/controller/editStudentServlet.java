package com.controller;

import com.dao.userDAO;
import com.model.StudentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class editStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dont write anything here.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet in edit servlet");
        userDAO userDAO = new userDAO();
        StudentInfo studentInfo = new StudentInfo();

        String username = request.getParameter("username");
        System.out.println("EditStudent Servlet id : " + username);
        studentInfo.setUsername(username);
        //value comes here
        StudentInfo studentInfo1 = userDAO.ShowEditTable(studentInfo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("EditDetails.jsp");
        request.setAttribute("user", studentInfo1);
        dispatcher.forward(request, response);

    }
}
