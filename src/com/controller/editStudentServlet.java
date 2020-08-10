package com.controller;

import com.dao.userDAO;
import com.model.studentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class editStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //dont write anything here.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet in edit servlet");
        userDAO userDAO = new userDAO();
        studentInfo studentInfo = new studentInfo();


        String username = request.getParameter("username");
        System.out.println("EditStudent Servlet id : " + username);
        studentInfo.setUsername(username);
        //value comes here
        studentInfo studentInfo1 = userDAO.ShowEditTable(studentInfo);


//        String fname = request.getParameter("fname");
//        String lname = request.getParameter("lname");
//        String newusername = request.getParameter("username");
//        String telephone = request.getParameter("telephone");
//        String password = request.getParameter("password");

//        studentInfo.setFname(fname);
//        studentInfo.setLname(lname);
//        studentInfo.setTelephone(telephone);
//        studentInfo.setUsername(newusername);
//        studentInfo.setPassword(password);

//        userDAO.registerStudent(studentInfo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("EditDetails.jsp");
        request.setAttribute("user", studentInfo1);
        dispatcher.forward(request, response);


    }
}
