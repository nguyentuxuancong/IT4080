<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="model.Reader" %>
<%@include file="link.html"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Reader reader = (Reader) request.getSession(false).getAttribute("reader");
    if(reader!=null){
        out.print("<font color=blue>Welcome to profile!</font>");
        out.print("<br>Welcome " + reader);
    }else
        out.print("<font color=red>Please login first</font>");
%>
</body>
</html>
