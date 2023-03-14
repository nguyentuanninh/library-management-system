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
public class ListBorrowAdmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null ||session.getAttribute("role")==null|| !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        String action = req.getParameter("action");
        if(action== null || action.length() == 0){
            resp.sendRedirect("HomePageAdmin");
            return;
        }
        BorrowerDAO bDAO= new BorrowerDAO();
        ArrayList<Borrower> listAll= bDAO.getBorrowerByStatus(action);
        int total=listAll.size();
        int numberPerPage= 6;
        int numberOfPage= (total%numberPerPage== 0)? (total/numberPerPage): (total/numberPerPage+ 1); //Số trang
        int page;
        String xpage= req.getParameter("page");
        if(xpage== null){
            page= 1;
        } else{
            page= Integer.parseInt(xpage);
        }
        int start= (page-1)* numberPerPage;
        int end= Math.min((page)*numberPerPage, total);
        ArrayList<Borrower> list= bDAO.getListBorrowerByPage(listAll, start, end);
        req.setAttribute("action", action);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.setAttribute("list", list);
        switch(action){
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

