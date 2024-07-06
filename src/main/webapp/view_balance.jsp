<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/26/2024
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Balance</title>
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

    The balance is ($): ${balance}
    <form action="Logout" class="logout">
        <input type="submit" value="Logout">
    </form>
</body>
</html>
