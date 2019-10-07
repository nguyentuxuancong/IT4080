<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
    <title>View Students</title>
</head>
<body>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <th>Student ID</th>
            <th>Last Name</th>
            <th>First Name</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Email</th>
            <th>Password</th>
        </tr>
        <c:forEach var="student" items="${studentList}">
            <tr>
                <td>${student.getStudentId()}</td>
                <td>${student.getLastName()}</td>
                <td>${student.getFirstName()}</td>
                <td>${student.getAddress()}</td>
                <td>${student.getTelephone()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getPassword()}</td>
            </tr>
        </c:forEach>
    </table>

    <%--Privious display--%>
    <c:if test="${currentPage != 1}">
        <td><a href="student.do?page=${currentPage - 1}">Previous</a> </td>
    </c:if>

    <%--displaying page numbers--%>
    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="student.do?page=${i}"></a> </td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>

    <%--Next page display--%>
    <c:if test="${currentPage lt noOfPages}">
        <td><a href="student.do?page=${currentPage + 1}">Next</a></td>
    </c:if>


</body>
</html>
