package com.adore96;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        StudentInfo student = new StudentInfo();

        student.setUsername(request.getParameter("uname"));
        student.setPassword(request.getParameter("password"));

        String username = request.getParameter("uname");

        DatabaseConnection databaseConnection = new DatabaseConnection();
//        List<StudentInfo> listUser = databaseConnection.ShowTable();
//        System.out.println("check :"+listUser.get(1));
        databaseConnection.logIn(student);

        boolean status = databaseConnection.logIn(student);
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
