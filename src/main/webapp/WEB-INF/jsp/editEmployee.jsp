<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Employees</title>
</head>
<body>

<form:form modelAttribute="employee">
    <form:input path="name" />
    <input class="button" type="submit" value="Save" />
</form:form>


</body>
</html>