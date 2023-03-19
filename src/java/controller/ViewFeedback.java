/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.BookDAO;
import DAO.FeedbackDAO;
import entity.Book;
import entity.Feedback;
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
public class ViewFeedback extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        FeedbackDAO fdao= new FeedbackDAO();
        ArrayList<Feedback> listAllFeedback= fdao.getListFeedback();
        int total=listAllFeedback.size();
        int bookPerPage= 5;
        int numberOfPage= (total%bookPerPage== 0)? (total/bookPerPage): (total/bookPerPage+ 1); //Số trang
        int page;
        String xpage= req.getParameter("page");
        if(xpage== null){
            page= 1;
        } else{
            page= Integer.parseInt(xpage);
        }
        int start= (page-1)* bookPerPage;
        int end= Math.min((page)*bookPerPage, total);
        ArrayList<Feedback> list= fdao.getListFeedbackByPage(listAllFeedback, start, end);

        req.setAttribute("listFeedback", list);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);
        req.getRequestDispatcher("ViewFeedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
