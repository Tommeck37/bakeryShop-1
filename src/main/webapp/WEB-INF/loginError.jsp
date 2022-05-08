<%--
  Created by IntelliJ IDEA.
  User: tomek
  Date: 08.05.2022
  Time: 08:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login?error" method="get">

<div class="form-group has-success">
    <label class="col-xs-3 control-label" ></label>
    <div class="col-xs-9">
        <c:if test="${not empty error}">

            <div class="error" style="color:#ff0000">
                    ${error}
            </div>
        </c:if>
    </div>
</div>

<div class="form-group has-success">
    <label class="col-xs-3 control-label" ></label>
    <div class="col-xs-9">
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
    </div>
</div>
</form>
</body>
</html>
