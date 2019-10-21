<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>URL Rewriting Example</title>
</head>
<body>
<h1>Welcome to profile!</h1>
<h2>Welcome, <%=request.getParameter("name")%> </h2>
</body>
</html>