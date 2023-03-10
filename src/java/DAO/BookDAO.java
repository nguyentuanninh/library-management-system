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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class BookDAO {
    Connection con= null;
    PreparedStatement pt= null;
    ResultSet rs= null;
    
    public ArrayList<Book> getAllBook(){
        ArrayList<Book> list= new ArrayList<>();
        String sql= "select * from book";
        DBContext db= new DBContext();
        try {
            con= db.getConnection();
            pt= con.prepareStatement(sql);
            rs= pt.executeQuery();
            while(rs.next()){
                Book book= new Book(
                        rs.getInt(1), rs.getString(2), 
                        rs.getString(4), rs.getString(3),
                        rs.getInt(5), rs.getString(6), 
                        rs.getString(7),  rs.getInt(8),  
                        rs.getInt(9), rs.getString(10));
                list.add(book);
            }
            return list;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public void updateBook(Book book){
        DBContext db = new DBContext();
        try{
            con = db.getConnection();
            String sql = "Update book set "
                    + "Name= ? "
                    + "Where ID= ?";
        } catch (Exception e){
            
        }
    }
}
