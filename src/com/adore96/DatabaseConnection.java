package com.adore96;

import java.sql.*;

public class DatabaseConnection {
    static Connection con = null;
    static String url;
    private static final String sql ="insert into student"
            + "(fname, lname, username, password,telephone) values" + "(?,?,?,?,?);";
//    private String url = "jdbc:mysql://localhost:3306/taskone";
//    private String dbuname = "root";
//    private String password = "";
//    private String dbdriver = "com.mysql.cj.jdbc.Driver";

//    Connection con = null;

//    public void loadDriver(String dbdriver){
//        try {
//            System.out.println();
//            System.out.println("dbdriver: "+dbdriver);
//            Class.forName(dbdriver);
//            System.out.println("Database Driver loaded Successfully.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println(e);
//            System.out.println("Error in loadDriver");
//        }
//    }
//
//    public Connection getConnection() {
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(url, dbuname, password);
//            System.out.println("Connection Success");
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            System.out.println(throwables);
//        }
//        return con;
//    }

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

    public void InsertValues(StudentInfo studentInfo) {
//        loadDriver(dbdriver);
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

        } catch (Exception e){
            String result = "Data was not inserted Successfully";
            System.out.println(result);
            System.out.println(e);
        }
    }

}
