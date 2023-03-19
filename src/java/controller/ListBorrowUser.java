/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.BorrowerDAO;
import DAO.CategoryDAO;
import entity.Book;
import entity.Borrower;
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
public class ListBorrowUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null) {
            resp.sendRedirect("Login");
            return;
        }
        String action = req.getParameter("action");
        if (action == null || action.length() == 0) {
            resp.sendRedirect("HomePageUser");
            return;
        }
        //list category in sidebar
        CategoryDAO cadao = new CategoryDAO();
        ArrayList<Category> listca = cadao.getListCategory();
        req.setAttribute("listca", listca);
  
        //Map book
        BookDAO bdao= new BookDAO();
        Map<Integer, Book> mapBook= bdao.getMapBook();
        req.setAttribute("mapBook", mapBook);
        
        //list borrow
        BorrowerDAO bDAO= new BorrowerDAO();
        ArrayList<Borrower> listAll= bDAO.getBorrowerByStatusAndUsername(action, session.getAttribute("username").toString());
        
        int total=listAll.size();
        int numberPerPage= 10;
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
               req.getRequestDispatcher("ListProcessingUser.jsp").forward(req, resp);
                break;
            case "borrowed":
                req.getRequestDispatcher("ListBorrowedUser.jsp").forward(req, resp);
                break;
            case "returned":
                req.getRequestDispatcher("ListReturnedUser.jsp").forward(req, resp);
                break;
            default:
                
        }
    }

}
