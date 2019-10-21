<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="link.html"%>
<html>
<head>
    <title>Register</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<h3><font color="blue">Register new user:</font> </h3>
<form action="RegisterServlet" method="post">
    Username: <input type="text" name="usr"><br>
    Password: <input type="password" name="pwd"><br>
    FullName: <input type="text" name="fullName"><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
