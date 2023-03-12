/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import entity.Category;
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
public class CategoryDAO {
    Connection conn= null;
    PreparedStatement ps= null;
    ResultSet rs= null;
    
    public Map<Integer, Category> getMapCategory(){
        Map<Integer, Category> list= new HashMap<>();
        DBContext db= new DBContext();
        String sql= "select * from category";
        try{
            conn= db.getConnection();
            ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Category category= new Category(rs.getInt(1), rs.getString(2));
                list.put(rs.getInt(1), category);
            }
            conn.close();
            rs.close();
            ps.close();
        } catch(Exception e){
            
        }
        return list;
    }
    public ArrayList< Category> getListCategory(){
        ArrayList<Category> list= new ArrayList<>();
        DBContext db= new DBContext();
        String sql= "select * from category";
        try{
            conn= db.getConnection();
            ps= conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Category category= new Category(rs.getInt(1), rs.getString(2));
                list.add(category);
            }
            conn.close();
            rs.close();
            ps.close();
        } catch(Exception e){
            
        }
        return list;
    }
}
