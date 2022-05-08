
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<form method="post">
	<div><label> User Name : <input type="text" name="email"/> </label></div>
	<div><label> Password: <input type="password" name="password"/> </label></div>

	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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
		<div><input type="submit" value="Sign In"/></div>
	</div>
</form>
