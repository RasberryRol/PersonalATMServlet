<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/24/2024
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container a, .container .balance{
            text-decoration: none;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        .container a input, .container .balance input {
            color: #f8f9fa;
            background-color: #007bff;
            font-size: 20px;
            margin-bottom: 10px; /* Optional: Adds spacing between inputs */
            padding: 8px;
            width: 200px; /* Adjust width as needed */
            box-sizing: border-box;
            border-radius: 6px;
        }

        .container a input:hover, .container .balance input:hover{
            background-color: #0056b3;
        }

        .cancel {
            text-decoration: none;
            display: flex;
            flex-direction: column;
            align-items: center;
            color: deepskyblue;
        }

        .cancel input {
            font-size: 20px;
        }

    </style>
</head>
<body>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setHeader("Expires", "0"); //Proxies

        if(session.getAttribute("username") == null){
            response.sendRedirect("login.jsp");
    }
    %>

<%--    remember to edit style--%>
    <div class="container" >
        <h3>${deposit}</h3>
        <h3>${withdraw}</h3>
        <h3>Hello ${username}, select an option below:</h3><br>

            <a href="deposit.jsp"><input type="submit" value="Deposit"><br></a>

            <a href="withdrawal.jsp"><input type="submit" value="Withdrawal"><br></a>

        <form action="Balance" class="balance">
            <input type="submit" value="View Balance">
        </form>

        <form action="Logout" class="cancel">
            <input type="submit" value="Cancel">
        </form>
    </div>

</body>
</html>
