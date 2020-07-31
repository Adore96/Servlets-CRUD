package com.adore96;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private String url = "jdbc:mysql://localhost:3306/";
    private String dbuname = "root";
    private String password = "";
    private String dbdriver = "com.mysql.jdbc.Driver";

    public Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,dbuname,password);
            System.out.println("Connection Success");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables);
        }

        return con;
    }
}
