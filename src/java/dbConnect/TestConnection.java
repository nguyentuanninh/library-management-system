/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import java.sql.Connection;

/**
 *
 * @author MSII
 */
public class TestConnection {
    public static void main(String[] args) throws Exception {
        DBContext db= new DBContext();
        Connection con= db.getConnection();
        System.out.println(con);
    }
}
