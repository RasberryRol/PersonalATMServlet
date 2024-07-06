<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/24/2024
  Time: 10:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h3 {
            padding-top: 20px;
            margin-top: 20px;
            margin-bottom: 20px;
            color: #007bff;
            color: indianred;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        #mismatch{
            text-align: center;
            color: indianred;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 0px;
            margin-bottom: 20px;
            padding-top: 20px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

    </style>

</head>
<body>
<%--    <h3>${blank}</h3>--%>

    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setHeader("Expires", "0"); //Proxies

        session.removeAttribute("username");
    %>

   <form action="Login" method="post">
       <h3 style="font-size: 17px">${error}</h3>
       <h3 style="font-size: 17px">${loginRequest}</h3>
       Username <input type="text" name="username" required> <br>
       Password <input type="password" name="password" required>

       <input type="submit" value="Submit">
       <h4 id="mismatch"><a href="signup.jsp">Sign Up</a></h4>
   </form>

</body>
</html>
