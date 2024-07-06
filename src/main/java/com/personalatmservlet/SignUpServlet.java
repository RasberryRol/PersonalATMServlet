package com.personalatmservlet;

import java.io.*;

import com.personalatmservlet.dao.UserDao;
import com.personalatmservlet.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/")
public class SignUpServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int count = 0;
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(firstname, lastname, email, phone, username, password);

        for(User userListObject: userDao.selectAllUsers()){
            if(userListObject.getPassword().equals(password)){
                request.setAttribute("passwordMatch", "Password taken. Try again!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                count++;
            }else if(userListObject.getEmail().equals(email)){
                request.setAttribute("existingUser", "Email already exist. Try again!");
                request.getRequestDispatcher("signup.jsp").forward(request, response);
                count++;
            }
        }

        if(count == 0){
            userDao.saveUser(user);
            request.setAttribute("user", user);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else
            request.getRequestDispatcher("signup.jsp").forward(request, response);
    }
}