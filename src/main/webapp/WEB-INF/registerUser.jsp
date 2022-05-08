<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Rejestracja</title>
    <style>
        .error {
            color: black;
            background: antiquewhite;
            font-weight: lighter;
            font-family: Fira Code Light;
        }
    </style>
</head>
<body>
<%--@elvariable id="user" type="pl.coderslab.entity.User"--%>

<form:form modelAttribute="user" method="post">
    FIRST NAME <form:input path="first_name"/><br>
    <form:errors path="first_name" cssClass="error"/><br>
    LAST NAME <form:input path="last_name"/><br>
    <form:errors path="last_name" cssClass="error"/><br>
    EMAIL <form:input path="email"/>
    <c:if test="${not empty emailMsg }">
        <label class="label-danger" style="color: red">${emailMsg}</label>
    </c:if>
    <form:errors path="email" cssClass="error"/><br>


    Street <form:input path="street"/><br>
    <form:errors path="street" cssClass="error"/><br>
    POST CODE <form:input path="post_code"/><br>
    <form:errors path="post_code" cssClass="error"/><br>
    CITY <form:input path="city"/><br>
    <form:errors path="city" cssClass="error"/><br>
    PHONE <form:input path="phone"/><br>
    <form:errors path="phone" cssClass="error"/><br>
    PASSWORD <form:password path="password"/>


    <br>

    <input type="submit">
</form:form>
</body>
</html>

