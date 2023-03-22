/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.CategoryDAO;
import entity.Book;
import entity.Category;
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
public class ViewBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null ||session.getAttribute("role")==null|| !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            BookDAO bDAO = new BookDAO();
            Book book = bDAO.getBookById(id);
            CategoryDAO cDAO = new CategoryDAO();
            ArrayList<Category> list = cDAO.getListCategory();
            req.setAttribute("category", list);

            req.setAttribute("book", book);
            req.getRequestDispatcher("ViewBook.jsp").forward(req, resp);
            
        } catch (Exception e) {
        }
        
    }

}
