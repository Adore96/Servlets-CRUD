package com.controller;

import com.dao.userDAO;
import com.db.DatabaseConnection;
import com.model.StudentInfo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        StudentInfo student = new StudentInfo();
//        DatabaseConnection databaseConnection = new DatabaseConnection();
        userDAO userDAO = new userDAO();

        student.setUsername(request.getParameter("uname"));
        student.setPassword(request.getParameter("password"));

        String username = request.getParameter("uname");


        userDAO.logIn(student);

        boolean status = userDAO.logIn(student);
        if (status==true){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            RequestDispatcher RD = request.getRequestDispatcher("/DashBoard.jsp");
            RD.include(request,response);
            System.out.println("DashBoard Response Called.");


        }else
        {
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Username or password incorrect');");
            out.println("location='Login.jsp';");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
