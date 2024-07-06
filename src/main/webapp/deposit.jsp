<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/26/2024
  Time: 12:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deposit Amount</title>
</head>
<body>
    <h3>${balance_too_low}</h3>
    <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0
        response.setHeader("Expires", "0"); //Proxies

        if(session.getAttribute("username") == null){
            response.sendRedirect("login.jsp");
        }
    %>

    <%--remember to protect this page and the others--%>
    <form action="Deposit" method="post">
        <label for="depositAmount">Enter deposit amount:</label>
        <input type="number" name="depositAmount" id="depositAmount" required>
        <input type="submit" value="Submit">
    </form>

    <form action="Logout" class="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
