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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author MSII
 */
public class CompleteBorrower extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("username") == null || session.getAttribute("role") == null || !session.getAttribute("role").equals("admin")) {
            resp.sendRedirect("Login");
            return;
        }
        String id = req.getParameter("id");
        BorrowerDAO bDAO = new BorrowerDAO();
        Borrower b = bDAO.getBorrowerById(id);
        b.setStatus("Borrowed");
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        b.setBorrow_from(dateFormat.format(new Date()));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, 14);
        b.setBorrow_to(dateFormat.format(calendar.getTime()));
        
        System.out.println(b.getId());
        bDAO.updateBorrower(b);
        resp.sendRedirect("ListBorrowAdmin?action=processing");
    }

}
