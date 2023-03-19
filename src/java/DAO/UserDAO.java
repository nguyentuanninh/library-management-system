/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class UserDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<User> getAllUser() {
        ArrayList<User> users = new ArrayList<>();
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT * FROM [USER]");
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getBoolean("role"));
                user.setName(rs.getString("name"));
                user.setAvt(rs.getString("avt"));
                user.setSex(rs.getBoolean("sex"));
                user.setDatebirth(rs.getString("datebirth"));
                user.setPhone(rs.getString("phone"));
                user.setGmail(rs.getString("gmail"));
                if(!user.isRole()){
                     users.add(user);

                }
               
            }
        } catch (Exception e) {

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }

        return users;
    }
    
    public User findUser(String username, String password) {
        User user = null;
        String sql = "SELECT * FROM [USER] WHERE username = ? and password= ?";
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getBoolean("role"));
                user.setName(rs.getString("name"));
                user.setAvt(rs.getString("avt"));
                user.setSex(rs.getBoolean("sex"));
                user.setDatebirth(rs.getString("datebirth"));
                user.setPhone(rs.getString("phone"));
                user.setGmail(rs.getString("gmail"));
            }
        }catch(Exception e){
            
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
        return user;
    }
    
    public User findUserByUsername(String username) {
        User user = null;
        String sql = "SELECT * FROM [USER] WHERE username = ?";
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getBoolean("role"));
                user.setName(rs.getString("name"));
                user.setAvt(rs.getString("avt"));
                user.setSex(rs.getBoolean("sex"));
                user.setDatebirth(rs.getString("datebirth"));
                user.setPhone(rs.getString("phone"));
                user.setGmail(rs.getString("gmail"));
            }
        }catch(Exception e){
            
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
        return user;
    }
    
    public void insertUser(User user) {
        conn = null;
        ps = null;
        String sql = "INSERT INTO dbo.[USER](username,password,role,name,avt,sex,datebirth,phone,gmail) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setBoolean(3, user.isRole());
            ps.setString(4, user.getName());
            if(user.getAvt()==null){
                ps.setString(5, "img/avt/avt.jpg");
            }else{
                 ps.setString(5, user.getAvt());
            }
           
            ps.setBoolean(6, user.isSex());
            ps.setString(7, user.getDatebirth());
            ps.setString(8, user.getPhone());
            ps.setString(9, user.getGmail());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
    }

    public void deleteUser(String username) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM [USER] WHERE username = '" + username + "'");
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public void updateUser(User user) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            String sql = "UPDATE [USER] "
                    + "SET [password]=?, [role]=?, name=?, avt=?, sex=?, datebirth=?, phone=?, gmail=? "
                    + "WHERE username=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getPassword());
            ps.setBoolean(2, user.isRole());
            ps.setString(3, user.getName());
            ps.setString(4, user.getAvt());
            ps.setBoolean(5, user.isSex());
            ps.setString(6, user.getDatebirth());
            
            ps.setString(7, user.getPhone());
            ps.setString(8, user.getGmail());
            ps.setString(9, user.getUsername());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
