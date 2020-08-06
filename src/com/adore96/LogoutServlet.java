package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        System.out.println("Session username : "+session.getAttribute("username"));
        session.invalidate();
//        RequestDispatcher RD = request.getRequestDispatcher("/Login.jsp");
//        RD.include(request,response);
//        System.out.println("Index Response Called.");
        response.sendRedirect(request.getContextPath() + "/Login.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
