/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Nguyen Minh
 */
public class User {
    private String username;
    private boolean role;
    private boolean sex;
    private String avt;
    private String date_birth;
    private String phone;
    private String gmail;

    public User() {
    }

    public User(String username, boolean role, boolean sex, String avt, String date_birth, String phone, String gmail) {
        this.username = username;
        this.role = role;
        this.sex = sex;
        this.avt = avt;
        this.date_birth = date_birth;
        this.phone = phone;
        this.gmail = gmail;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getAvt() {
        return avt;
    }

    public void setAvt(String avt) {
        this.avt = avt;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
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

    @Override
    public String toString() {
        String strrole;
        String strsex;
        if (role){
            strrole = "Admin";
        }else {
            strrole = "Student";
        }
        if (sex){
            strsex = "Male";
        }else{
            strsex = "Female";
        }
        return "User{" + ", username=" + username + ", role=" + strrole + ", sex=" + strsex + ", avt=" + avt + ", date_birth=" + date_birth + ", phone=" + phone + ", gmail=" + gmail + '}';
    }
}
  
    

