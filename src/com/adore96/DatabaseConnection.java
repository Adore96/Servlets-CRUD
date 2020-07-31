package com.adore96;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbuname = "root";
    private String password = "";
    private String dbdriver = "com.mysql.jdbc.Driver";

    public void loadDriver(String dbdriver){
        try {
            Class.forName(dbdriver);
            System.out.println("Database Driver loaded Successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error in loadDriver");
        }
    }

    public Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, dbuname, password);
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }
        return con;
    }

    public String InsertValues(StudentInfo studentInfo) {
        loadDriver(dbdriver);
        Connection con = getConnection();
        String result = "Data was inserted Successfully";
        String sql = "insert into student values(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getUname());
            ps.setString(4,studentInfo.getPassword());
            ps.setString(5,studentInfo.getTelephone());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = "Data was not entered";
            System.out.println(throwables);
        }
        return result;
    }
}
