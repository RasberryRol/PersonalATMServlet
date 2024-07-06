package com.personalatmservlet.web;

import com.personalatmservlet.dao.UserDao;
import com.personalatmservlet.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
    private UserDao userDao = new UserDao();


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setHeader("Expires", "0"); //Proxies

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUserByUserName(username);

        if(user == null || !user.getPassword().equals(password)) {
            request.setAttribute("error", "Invalid credentials. Try again!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else if(user.getPassword().equals(password) && user.getUsername().equals(username)){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("menu.jsp");
        }
    }
}
