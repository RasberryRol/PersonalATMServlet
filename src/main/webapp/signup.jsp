<%--
  Created by IntelliJ IDEA.
  User: dief9
  Date: 6/24/2024
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
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

        h4 {
            margin-bottom: 20px;
            color: #007bff;
        }

        #exist{
            text-align: center;
            color: indianred;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 0px;
            margin-bottom: 20px;
        }

        #mismatch{
            text-align: center;
            color: indianred;
            display: flex;
            justify-content: center;
            align-items: center;
            margin-top: 0px;
            margin-bottom: 20px;
        }

        input[type="text"],
        input[type="email"],
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

    <form action="SignUpServlet" method="post">
        <h4 id="exist">${existingUser}</h4>
        First Name <input type="text" name="firstname" required><br>
        Last Name <input type="text" name="lastname" required><br>
        Email <input type="email" name="email" required><br>
        Phone# <input type="text" name="phone" required placeholder="Ex: 3472232737"><br>
        UserName <input type="text" name="username" required><br>
        Password <input type="password" name="password" required><br>
        <h4 id="mismatch">${passwordMatch}</h4>

        <input type="submit" value="Submit">
        <h4>Already have an account? <a href="login.jsp">Login</a> </h4>
    </form>
</body>
</html>
