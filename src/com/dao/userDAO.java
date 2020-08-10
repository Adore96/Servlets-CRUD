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

        try {
            con = databaseConnection.getConnection();
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
        System.out.println("UserDAO.DeleteUser Details : "+studentInfo);

        try {
            con = databaseConnection.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,studentInfo.getUsername());
            preparedStatement.executeUpdate();
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

        try {
            con = databaseConnection.getConnection();
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
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return studentInfos;
    }

    public void finalUpdate(studentInfo studentInfo) {
        final String sql ="update users set fname = ?,lname = ?,username = ?,password = ? ,telephone = ? where username = ?";

        try {
            con = databaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(6,studentInfo.getUsername());
            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getUsername());
            ps.setString(4,studentInfo.getPassword());
            ps.setString(5,studentInfo.getTelephone());
            ps.executeUpdate();
            String result = "Data was Updated Successfully";
            System.out.println(result);
            con.close();
        }
        catch (Exception e){
            String result = "Data was not Updated.";
            System.out.println(result);
            System.out.println(e);
        }
    }

    public studentInfo ShowEditTable(studentInfo studentInfo){

        final String sql ="select * from student where username = ? ";
        System.out.println("Show edit table in DAO");

        try {
            con = databaseConnection.getConnection();
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1,studentInfo.getUsername());
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String telephone = rs.getString("telephone");
                studentInfo = new studentInfo(fname , lname , username , password , telephone);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        System.out.println("Show edit table values: "+studentInfo.getFname()+" "+studentInfo.getLname()+" "+studentInfo.getPassword());
        return studentInfo;
    }

}
