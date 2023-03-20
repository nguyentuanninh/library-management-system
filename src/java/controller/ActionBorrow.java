/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.BorrowerDAO;
import entity.Book;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author MSII
 */
public class ActionBorrow extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            resp.sendRedirect("Login");
            return;
        }
        
        String url= req.getParameter("url");
        String bookid= req.getParameter("id");

        BookDAO bookdao= new BookDAO();
        Book book= bookdao.getBookById(Integer.parseInt(bookid));
        book.setCurrent(book.getCurrent()-1);
        bookdao.updateBook(book);
        //Update quantity book
        
        //insert into borrower
        BorrowerDAO bdao= new BorrowerDAO();
        bdao.insertBorrower(session.getAttribute("username").toString(), bookid);
        resp.sendRedirect(url);
    }

}
