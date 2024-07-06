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

@WebServlet("/Balance")
public class ViewBalance extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = userDao.getUserByUserName((String) session.getAttribute("username"));

        if(user != null){
            req.setAttribute("balance", user.getBalance());
            req.getRequestDispatcher("view_balance.jsp").forward(req, resp);
        }else {
            req.setAttribute("loginRequest", "Login required!");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }
}
