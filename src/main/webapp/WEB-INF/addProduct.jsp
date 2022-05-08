<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 08.05.2022
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--@elvariable id="product" type="pl.coderslab.entity.Product"--%>
<form:form modelAttribute="product" >
    Nazwa <form:input path="name"/>

    Opis <form:input path="description" />

    Image URL <form:input path="image_url" />
    <br/>

    Price <form:input path="price"/>
    <br>
    Available Quantity <form:input path="quantity"/>
    <br>
    <form:select path="category" items="${categories}" itemLabel="category" itemValue="id"/>
    <br>
    <input type="submit">
</form:form>
</body>
</html>