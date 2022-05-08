<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 08.05.2022
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Lista produktów</title>
</head>
<body>


<%--@elvariable id="product" type="java.util.List<pl.coderslab.entity.Product>"--%>
<table>
    <c:forEach var="item" items="${products}">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.price}</td>
            <td><a href="/removal/${item.id}">usuń</a></td>
            <td><a href="/add/${item.id}">dodaj sztukę</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
