/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.BorrowerDAO;
import entity.Book;
import entity.Borrower;
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
public class DeleteBorrower extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
//Update quanity of book when user return book
        String bookidStr= req.getParameter("bookid");
        int bookid=0;
        try {
            bookid= Integer.parseInt(bookidStr);
        } catch (Exception e) {
        }
        BookDAO bdao= new BookDAO();
        Book book= bdao.getBookById(bookid);
        book.setCurrent(book.getCurrent()+1);
        bdao.updateBook(book);
        String id= req.getParameter("id");
        BorrowerDAO bDAO= new BorrowerDAO();
        bDAO.deleteBorrower(id);
        resp.sendRedirect("ListBorrowAdmin?action=processing");
    }
    
    
}
