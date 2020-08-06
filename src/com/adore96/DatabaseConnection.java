package com.adore96;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;

public class DatabaseConnection {
    static Connection con = null;
    static String url;



    public static Connection getConnection()
    {
        try
        {
             url = "jdbc:mysql://localhost:3306/taskone?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            // assuming "DataSource" is your DataSource name
            System.out.println("DB URL Called");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("mysql Driver called");
            try
            {
                con = DriverManager.getConnection(url,"root","");
                System.out.println("connected to db");
            }
            catch (SQLException ex)
            {
                System.out.println(ex);
                ex.printStackTrace();
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        return con;
    }

    public void registerStudent(StudentInfo studentInfo) {

        final String sql ="insert into student"
                + "(fname, lname, username, password,telephone) values" + "(?,?,?,?,?);";

        System.out.println(studentInfo);
        con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getUsername());
            ps.setString(4,studentInfo.getPassword());
            ps.setString(5,studentInfo.getTelephone());
            ps.executeUpdate();
            String result = "Data was inserted Successfully";
            System.out.println(result);
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }

    public void logIn(StudentInfo studentInfo) {

        final String sql ="select * from student where username = ? and password = ?";

        System.out.println(studentInfo);
        con = getConnection();
        try {
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1,studentInfo.getUsername());
            ps1.setString(2,studentInfo.getPassword());
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                System.out.println("Login Success");
            } else {
                System.out.println("Login Error");
            }
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }

    public void DeleteUser(StudentInfo studentInfo) {

        final String sql ="delete from student where username =?";

        System.out.println(studentInfo);
        con = getConnection();
        try {
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1,studentInfo.getUsername());
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                System.out.println("Delete Success");
            } else {
                System.out.println("Error Occured in Deleting the user.");
            }
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }
}
