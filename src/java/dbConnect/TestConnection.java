/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbConnect;

import DAO.BookDAO;
import entity.Book;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class TestConnection {
    public static void main(String[] args) throws Exception {
        DBContext db= new DBContext();
        BookDAO bdao= new BookDAO();
        ArrayList<Book> list= new ArrayList<>();
        list= bdao.getAllBook();
        for(Book b: list){
            System.out.println(b.getBookid()+ " "+ b.getName());
        }

    }
}
