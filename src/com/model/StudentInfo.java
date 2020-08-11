package com.model;

public class StudentInfo {
    private String fname , lname , username , password , telephone ;


    public StudentInfo() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public StudentInfo(String fname, String lname, String uname, String password, String telephone) {
        this.fname = fname;
        this.lname = lname;
        this.username = uname;
        this.password = password;
        this.telephone = telephone;
    }

}
