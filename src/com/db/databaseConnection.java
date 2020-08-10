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
            // assuming "DataSource" is your DataSource name
            System.out.println("---------------------Database Connection Class-------------------");
            System.out.println("|  DB URL Called");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("|  mysql Driver called");
            try
            {
                con = DriverManager.getConnection(url,"root","");
                System.out.println("|  connected to db");
                System.out.println("----------------------------------------------------");
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



}
