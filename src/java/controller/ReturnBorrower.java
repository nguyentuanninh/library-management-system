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

/**
 *
 * @author MSII
 */
public class ReturnBorrower extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        String id = req.getParameter("id");
        if(id== null || id.length()== 0){
            resp.sendRedirect("HomePageAdmin");
            return;
        }
        BorrowerDAO bDAO = new BorrowerDAO();
        Borrower b = bDAO.getBorrowerById(id);
        b.setStatus("Returned");
        bDAO.updateBorrower(b);
        resp.sendRedirect("ListBorrowAdmin?action=borrowed");
    }

}
