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
public class HomePageUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("user")) {
            resp.sendRedirect("Login");
            return;
        }

        //set list category will show in Sidebar
        CategoryDAO cadao = new CategoryDAO();
        ArrayList<Category> listca = cadao.getListCategory();
        req.setAttribute("listca", listca);

        //view is type of category
        String viewStr = req.getParameter("view");
        int view = 0;
        if (viewStr == null || viewStr.length() == 0) {
            view = 0;
        }
        try {
            view = Integer.parseInt(viewStr);
        } catch (Exception e) {
            view = 0;
        }
        req.setAttribute("view", view);

        //select list book by category
        CategoryDAO cDAO = new CategoryDAO();
        Map<Integer, Category> mapCategory = cDAO.getMapCategory();
        BookDAO bDAO = new BookDAO();
        ArrayList<Book> listAllBook = new ArrayList<>();
        if (view == 0) {
            listAllBook = bDAO.getAllBook();
        } else {
            listAllBook = bDAO.getBookByCategory(view);
        }

        int total = listAllBook.size();
        int bookPerPage = 5;
        int numberOfPage = (total % bookPerPage == 0) ? (total / bookPerPage) : (total / bookPerPage + 1); //Số trang
        int page;
        String xpage = req.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
        int start = (page - 1) * bookPerPage;
        int end = Math.min((page) * bookPerPage, total);
        ArrayList<Book> list = bDAO.getListBookByPage(listAllBook, start, end);

        
        req.setAttribute("mapCategory", mapCategory);
        req.setAttribute("listBook", list);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.getRequestDispatcher("HomePageUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
