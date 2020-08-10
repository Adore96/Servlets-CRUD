package com.dao;

import com.db.databaseConnection;
import com.model.studentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
    static Connection con = null;
    com.db.databaseConnection databaseConnection = new databaseConnection();
    static boolean status;

    public void registerStudent(studentInfo studentInfo) {
        final String sql ="insert into student"
                + "(fname, lname, username, password,telephone) values" + "(?,?,?,?,?);";

        System.out.println(studentInfo);
        con = databaseConnection.getConnection();
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
            con.close();
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }

    public boolean logIn(studentInfo studentInfo) {
        final String sql ="select * from student where username = ? and password = ?";
        System.out.println(studentInfo);
        con = databaseConnection.getConnection();

        try {
            PreparedStatement ps1 = con.prepareStatement(sql);
            ps1.setString(1,studentInfo.getUsername());
            ps1.setString(2,studentInfo.getPassword());
            ResultSet rs = ps1.executeQuery();

            if (rs.next()) {
                System.out.println("Login Success");
                status = true;
            } else {
                System.out.println("Login Error");
                status = false;
            }
            con.close();
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
        return status;
    }


    public void DeleteUser(studentInfo studentInfo) throws SQLException {
        final String sql ="delete from student where username =?";
        System.out.println(studentInfo);
        con = databaseConnection.getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,studentInfo.getUsername());
            ps.executeUpdate();
            System.out.println("Data was deleted Successfully");
            con.close();
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }


    public List<studentInfo> ShowTable(){
        List<studentInfo> studentInfos = new ArrayList<>();
        final String sql ="select * from student";
        con = databaseConnection.getConnection();

        try {
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String telephone = rs.getString("telephone");
                studentInfos.add(new studentInfo(fname , lname , username , password , telephone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return studentInfos;
    }

    public void EditStudent(studentInfo studentInfo) {
        final String sql ="update users set fname = ?,lname = ?,username = ?,password = ? ,telephone = ? where id = ?;";

        System.out.println(studentInfo);

        con = databaseConnection.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getUsername());
            ps.setString(4,studentInfo.getPassword());
            ps.setString(5,studentInfo.getTelephone());
            ps.executeUpdate();
            System.out.println( "Data was Edited Successfully");
            con.close();
        }
        catch (Exception e){
            String result = "Data was not inserted.";
            System.out.println(result);
            System.out.println(e);
        }
    }

}
