package com.personalatmservlet.services;

import com.personalatmservlet.dao.UserDao;
import com.personalatmservlet.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("deposit.jsp");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double depositAmount = Math.abs(Double.parseDouble(req.getParameter("depositAmount")));

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        User user = userDao.getUserByUserName(username);
        double balance = user.getBalance();

        if(user != null){
            if((depositAmount + balance) > 20){
                balance = balance + depositAmount;
                userDao.updateBalance(user.getId(), balance);
                req.setAttribute("deposit", "Deposit successfully completed.");
                req.getRequestDispatcher("menu.jsp").forward(req, resp);
            }else{
                req.setAttribute("balance_too_low", "Your balance cannot be below or equal to $20. Try again!");
                req.getRequestDispatcher("deposit.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("loginRequest", "Login required!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
