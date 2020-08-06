package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentInfo student = new StudentInfo();
        String username = request.getParameter("uname");

        student.setUsername(username);

        DatabaseConnection databaseConnection = new DatabaseConnection();
        List<StudentInfo> listUser = databaseConnection.ShowTable();
        System.out.println(listUser.get(1));

        RequestDispatcher RD = request.getRequestDispatcher("/Login.jsp");
        RD.include(request,response);
        System.out.println("Index Response Called.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
