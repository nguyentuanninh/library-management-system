/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MSII
 */
public class BookDAO {

    Connection con = null;
    PreparedStatement pt = null;
    ResultSet rs = null;

    public ArrayList<Book> getListBookByPage(ArrayList<Book> list, int start, int end) {
        ArrayList<Book> arr = new ArrayList<>();
        for (int i = start; i < end; ++i) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public Map<Integer, Book> getMapBook() {
        Map<Integer, Book> list = new HashMap<>();
        String sql = "select * from book";
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(4), rs.getString(3),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
                list.put(book.getBookid(), book);
            }
            con.close();
            pt.close();
            rs.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public ArrayList<Book> getAllBook() {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "select * from book";
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(4), rs.getString(3),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
                list.add(book);
            }
            con.close();
            pt.close();
            rs.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public ArrayList<Book> getBookByName(String name) {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "select * from book where [name] like '%" + name + "%'";
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(4), rs.getString(3),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
                list.add(book);
            }
            con.close();
            pt.close();
            rs.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
        public ArrayList<Book> getBookByCategory(int cid) {
        ArrayList<Book> list = new ArrayList<>();
        String sql = "select * from book where category =" + cid;
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement(sql);
            rs = pt.executeQuery();
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(4), rs.getString(3),
                        rs.getInt(5), rs.getString(6),
                        rs.getString(7), rs.getInt(8),
                        rs.getInt(9), rs.getString(10));
                list.add(book);
            }
            con.close();
            pt.close();
            rs.close();
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE id = ?";
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement(sql);
            pt.setInt(1, id);
            Book book = null;
            rs = pt.executeQuery();
            if (rs.next()) {
                book = new Book(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("author"),
                        rs.getString("img"),
                        rs.getInt("category"),
                        rs.getString("publisher"),
                        rs.getString("language"),
                        rs.getInt("total"),
                        rs.getInt("current"),
                        rs.getString("position")
                );
            }
            rs.close();
            pt.close();
            return book;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (Exception e) {
                }
            }
        }
    }

    public void updateBook(Book book) {
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement("UPDATE book "
                    + "SET [name]=?, img=?, author=?, category=?, publisher=?, [language]=?, total=?, [current]=?, position=? "
                    + "WHERE id=?");

            // Set parameters
            pt.setString(1, book.getName());
            pt.setString(2, book.getImg());
            pt.setString(3, book.getAuthor());
            pt.setInt(4, book.getCategory());
            pt.setString(5, book.getPublisher());
            pt.setString(6, book.getLanguage());
            pt.setInt(7, book.getTotal());
            pt.setInt(8, book.getCurrent());
            pt.setString(9, book.getPosition());
            pt.setInt(10, book.getBookid());

            pt.executeUpdate();
            con.close();
            pt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertbook(Book book) {
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            String sql = "INSERT INTO book (id, [name], img, author, category, publisher, [language], total, [current], position) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pt = con.prepareStatement(sql);
            pt.setInt(1, book.getBookid());
            pt.setString(2, book.getName());
            pt.setString(3, book.getImg());
            pt.setString(4, book.getAuthor());
            pt.setInt(5, book.getCategory());
            pt.setString(6, book.getPublisher());
            pt.setString(7, book.getLanguage());
            pt.setInt(8, book.getTotal());
            pt.setInt(9, book.getCurrent());
            pt.setString(10, book.getPosition());
            pt.executeUpdate();
            con.close();
            pt.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean deleteBook(String id) {
        DBContext db = new DBContext();
        try {
            con = db.getConnection();
            pt = con.prepareStatement("DELETE FROM book WHERE id=?");
            pt.setString(1, id);
            pt.executeUpdate();
            con.close();
            pt.close();
            return true;
        } catch (Exception e) {
            return false;

        }
    }
}
