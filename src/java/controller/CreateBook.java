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
import java.util.Map;

/**
 *
 * @author MSII
 */
public class CreateBook extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        CategoryDAO cDAO = new CategoryDAO();
        ArrayList<Category> list = cDAO.getListCategory();
        req.setAttribute("list", list);
        req.getRequestDispatcher("CreateBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        try {
            int bookid = Integer.parseInt(request.getParameter("bookid"));
            String name = request.getParameter("name");
            String author = request.getParameter("author");
            int category = Integer.parseInt(request.getParameter("category"));
            String publisher = request.getParameter("publisher");
            String language = request.getParameter("language");
            int total = Integer.parseInt(request.getParameter("total"));
            int current = Integer.parseInt(request.getParameter("current"));
            String position = request.getParameter("position");

            // Create a new Book object with the given parameters
            Book newBook = new Book(bookid, name, author, category, publisher, language, total, current, position);
            BookDAO bDAO = new BookDAO();
            if (bDAO.getBookById(bookid) != null) {
                CategoryDAO cDAO = new CategoryDAO();
                ArrayList<Category> list = cDAO.getListCategory();
                request.setAttribute("list", list);
                request.setAttribute("book", newBook);
                request.setAttribute("mess", "BookId really exsit");
                request.getRequestDispatcher("CreateBook.jsp").forward(request, resp);
                return;
            }
            bDAO.insertbook(newBook);
            resp.sendRedirect("ListBook");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
