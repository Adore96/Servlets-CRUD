package com.db;

import java.sql.*;

public class databaseConnection {
    static Connection con = null;
    static String url;


    public static Connection getConnection()
    {
        try
        {
            url = "jdbc:mysql://localhost:3306/taskone?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            System.out.println("Connection Success.");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }  catch (SQLException ex)
        {
            System.out.println(ex);
            ex.printStackTrace();
        }
        return con;
    }



}
