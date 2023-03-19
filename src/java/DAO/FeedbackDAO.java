/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import entity.Book;
import entity.Feedback;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class FeedbackDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    DBContext db= new DBContext();
    
    public ArrayList<Feedback> getListFeedbackByPage(ArrayList<Feedback> list, int start, int end) {
        ArrayList<Feedback> arr = new ArrayList<>();
        for (int i = start; i < end; ++i) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public ArrayList<Feedback> getListFeedback(){
        ArrayList<Feedback> list= new ArrayList<>();
        String sql= "select * from feedback order by id desc";
        try {
            conn= db.getConnection();
            ps= conn.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                Feedback fb= new Feedback(rs.getString(3), rs.getString(4), rs.getString(2));
                list.add(fb);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public void insertFeedback(Feedback fb){
        String sql= "insert into feedback([user_id], title, [content]) values (?,?,?)";
        try {
            conn= db.getConnection();
            ps= conn.prepareStatement(sql);
            ps.setString(1, fb.getUsername());
            ps.setString(2, fb.getTitle());
            ps.setString(3, fb.getConnent());
            ps.executeQuery();
        } catch (Exception e) {
        }
    }
}
