/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import entity.Book;
import entity.Borrower;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author MSII
 */
public class BorrowerDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Borrower> getListBorrowerByPage(ArrayList<Borrower> list, int start, int end) {
        ArrayList<Borrower> arr = new ArrayList<>();
        for (int i = start; i < end; ++i) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void deleteBorrower(String id) {
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM [borrower] WHERE id = '" + id + "'");
            ps.executeUpdate();
            conn.close();
            ps.close();
        } catch (Exception e) {

        }
    }

    public ArrayList<Borrower> getBorrowerByStatusAndUsername(String status, String username) {
        DBContext db = new DBContext();
        ArrayList<Borrower> list = new ArrayList<>();
        String sql = "select * from borrower where status= ? and username=?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Borrower b = new Borrower(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                if (!status.equals("processing")) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = dateFormat.parse(rs.getString(5));
                    Date check = new Date();
                    if (!date.after(check)) {
                        b.setLate(true);
                    }
                }
                list.add(b);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Borrower> getBorrowerByStatus(String status) {
        DBContext db = new DBContext();
        ArrayList<Borrower> list = new ArrayList<>();
        String sql = "select * from borrower where [status]= ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                Borrower b = new Borrower(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                if (!status.equals("processing")) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = dateFormat.parse(rs.getString(5));
                    Date check = new Date();
                    if (!date.after(check)) {
                        b.setLate(true);
                    }
                }
                list.add(b);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;

        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public ArrayList<Borrower> getBorrowerByStatusAndUserId(String status, String username) {
        DBContext db = new DBContext();
        ArrayList<Borrower> list = new ArrayList<>();
        String sql = "select * from borrower where [status]= ? and [username]= ?";
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                Borrower b = new Borrower(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
                list.add(b);
            }
            conn.close();
            ps.close();
            rs.close();
            return list;
        } catch (Exception e) {
        }
        return list;
    }

    public Borrower getBorrowerById(String id) {
        DBContext db = new DBContext();
        String sql = "select * from [borrower] WHERE id = '" + id + "'";
        Borrower b = new Borrower();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = new Borrower(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4),
                        rs.getString(5), rs.getString(6));
            }
            conn.close();
            ps.close();
            rs.close();
            return b;
        } catch (Exception e) {
        }
        return null;
    }

    public void updateBorrower(Borrower borrower) {
        String sql = "UPDATE borrower SET [username]=?, book_id=?, form=?, [to]=?, [status]=? WHERE id=?";
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, borrower.getUsername());
            ps.setInt(2, borrower.getBookid());
            ps.setString(3, borrower.getBorrow_from());
            ps.setString(4, borrower.getBorrow_to());
            ps.setString(5, borrower.getStatus());
            ps.setInt(6, borrower.getId());
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBorrower(String username, String bookid) {
        String sql = "insert into borrower (username, book_id, [status])\n"
                + "values (?, ?,'processing' )";
        DBContext db = new DBContext();
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, bookid);
            ps.executeQuery();
        } catch (Exception e) {
            System.out.println("insertBorrower: " + e.getMessage());
        }
    }
}
