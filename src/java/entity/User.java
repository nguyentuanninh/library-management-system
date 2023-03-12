/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Nguyen Minh
 */
public class User {
   private String username;
   private String password;
   private boolean role;
   private String name;
   private String avt;
   private boolean sex;
   private String datebirth;
   private String phone;
   private String gmail;

    public User() {
    }

    public User(String username, String password, boolean role, String name, String avt, boolean sex, String datebirth, String phone, String gmail) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.avt = avt;
        this.sex = sex;
        this.datebirth = datebirth;
        this.phone = phone;
        this.gmail = gmail;
    }
    public User(String username, String password, String name, String avt, boolean sex, String datebirth, String phone, String gmail) {
        this.username = username;
        this.password = password;
        this.role = false;
        this.name = name;
        this.avt = avt;
        this.sex = sex;
        this.datebirth = datebirth;
        this.phone = phone;
        this.gmail = gmail;
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

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getDatebirth() {
        return datebirth;
    }

    public void setDatebirth(String datebirth) {
        this.datebirth = datebirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
   
   

}
  
    

