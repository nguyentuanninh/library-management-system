/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BorrowerDAO;
import entity.Borrower;
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
public class SearchBorrower extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }

        String action = req.getParameter("action");
        String username= req.getParameter("name");
        if (action == null || action.length() == 0) {
            resp.sendRedirect("HomePageAdmin");
            return;
        }
        if (username == null || username.length() == 0) {
            resp.sendRedirect("ListBorrowAdmin?action="+action);
            return;
        }
        BorrowerDAO bDAO = new BorrowerDAO();
               System.out.println(action+" "+ username);
        ArrayList<Borrower> listAll = bDAO.getBorrowerByStatusAndUserId(action, username);
        int total = listAll.size();
        int numberPerPage = 6;
        int numberOfPage = (total % numberPerPage == 0) ? (total / numberPerPage) : (total / numberPerPage + 1); //Số trang
        int page;
        String xpage = req.getParameter("page");
        if (xpage == null) {
            page = 1;
        } else {
            page = Integer.parseInt(xpage);
        }
 
        int start = (page - 1) * numberPerPage;
        int end = Math.min((page) * numberPerPage, total);
        ArrayList<Borrower> list = bDAO.getListBorrowerByPage(listAll, start, end);
        req.setAttribute("action", action);
        req.setAttribute("usernameSearch", username);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.setAttribute("list", list);
        switch (action) {
            case "processing":
                req.getRequestDispatcher("ListProcessingAdmin.jsp").forward(req, resp);
                break;
            case "borrowed":
                req.getRequestDispatcher("ListBorrowedAdmin.jsp").forward(req, resp);
                break;
            case "returned":
                req.getRequestDispatcher("ListReturnedAdmin.jsp").forward(req, resp);
                break;
            default:

        }
    }

}
