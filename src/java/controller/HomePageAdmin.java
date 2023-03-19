/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.BorrowerDAO;
import DAO.CategoryDAO;
import DAO.DAOO;
import DAO.UserDAO;
import entity.Book;
import entity.Borrower;
import entity.Category;
import entity.TopBook;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author MSII
 */
public class HomePageAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        
        //table top borrowed book
        DAOO dao= new DAOO();
        ArrayList<TopBook> listTopBook = dao.getTopBook();
        ArrayList<TopBook> listTopUser = dao.getTopUser();
        req.setAttribute("listTopBook", listTopBook);
        req.setAttribute("listTopUser", listTopUser);
        
        BookDAO bdao = new BookDAO();
        ArrayList<Book> listBook = bdao.getAllBook();

        UserDAO udao = new UserDAO();
        ArrayList<User> listUser = udao.getAllUser();

        BorrowerDAO brdao = new BorrowerDAO();
        ArrayList<Borrower> listBr = brdao.getBorrowerByStatus("borrowed");
        ArrayList<Borrower> listPr = brdao.getBorrowerByStatus("processing");

        req.setAttribute("numberBorrow", listBr.size());
        req.setAttribute("numberUser", listUser.size());
        req.setAttribute("numberProcessing", listPr.size());
        req.setAttribute("numberBook", listBook.size());
        req.getRequestDispatcher("HomePageAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
