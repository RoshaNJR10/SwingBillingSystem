<%--
  Created by IntelliJ IDEA.
  User: RoshaNJR
  Date: 11/30/2023
  Time: 5:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<h1>Student Details</h1>
<c:if test="${!empty student}">
    <table class="table table-striped">
        <thead>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Address</th>
            <th scope="col">Age</th>
            <th scope="col">Gender</th>
            <th scope="col">Faculty</th>
            <th scope="col">Contact</th>
            <th scope="col">Email</th>
        </thead>
        <tbody>
            <c:forEach items="${student}" var="std">
                <tr>
                <td>${std.id}</td>
                <td>${std.name}</td>
                <td>${std.address}</td>
                <td>${std.age}</td>
                <td>${std.gender}</td>
                <td>${std.faculty}</td>
                <td>${std.contact}</td>
                <td>${std.email}</td>
                </tr>
            </c:forEach>

        </tbody>
    </table>


</c:if>
</body>
</html>
