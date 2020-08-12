package com.dao;

import com.db.databaseConnection;
import com.model.StudentInfo;
import com.util.HashFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userDAO {
    static Connection con = null;
    static boolean status;

    public void registerStudent(StudentInfo studentInfo) {
        final String sql ="insert into student"
                + "(fname, lname, username, password,telephone) values" + "(?,?,?,?,?);";

        System.out.println(studentInfo);

        try {
            con = databaseConnection.getConnection();
            HashFunction hashFunction = new HashFunction();

            String password = studentInfo.getPassword();
            String hashedpassword = hashFunction.hashPassword(password);

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getUsername());
            ps.setString(4,hashedpassword);
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

    public boolean logIn(StudentInfo studentInfo) {
        final String sql ="select * from student where username = ? and password = ?";
        con = databaseConnection.getConnection();
        System.out.println("Connection : "+  con);

        try {
            PreparedStatement ps1 = con.prepareStatement(sql);
            HashFunction hashFunction = new HashFunction();

            String password = studentInfo.getPassword();
            String hashedPassword = hashFunction.hashPassword(password);

            ps1.setString(1,studentInfo.getUsername());
            ps1.setString(2,hashedPassword);
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
            System.out.println("Data was not inserted.");
            System.out.println(e);
        }
        return status;
    }


    public void DeleteUser(StudentInfo studentInfo) throws SQLException {
        final String sql ="delete from student where username =?";

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


    public List<StudentInfo> ShowTable(){
        List<StudentInfo> StudentInfos = new ArrayList<>();
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
                StudentInfos.add(new StudentInfo(fname , lname , username , password , telephone));
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return StudentInfos;
    }

    public void finalUpdate(StudentInfo studentInfo) {
        final String sql ="UPDATE  student SET fname = ?,lname = ? ,password = ? ,telephone = ? WHERE username = ?";

        try {
            con = databaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,studentInfo.getFname());
            ps.setString(2,studentInfo.getLname());
            ps.setString(3,studentInfo.getPassword());
            ps.setString(4,studentInfo.getTelephone());
            ps.setString(5,studentInfo.getUsername());
            ps.executeUpdate();
            System.out.println("Data was Updated Successfully");
            con.close();
        }
        catch (Exception e){
            String result = "Data was not Updated.";
            System.out.println(result);
            System.out.println(e);
        }
    }

    public StudentInfo ShowEditTable(StudentInfo studentInfo){

        final String sql ="select * from student where username = ? ";

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
                studentInfo = new StudentInfo(fname , lname , username , password , telephone);
            }
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return studentInfo;
    }

}
