<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<form action="LoginServlet" method="post">
    Username: <input type="text" name="usr"><br>
    Password: <input type="password" name="pwd"><br>
    <input type="submit" value="Login">
</form>
</body>
</html>