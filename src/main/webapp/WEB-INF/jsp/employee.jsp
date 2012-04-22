<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
${employee.name}

<p>${employee.cv}</p>

<ul>
    <c:forEach var="phone" items="${employee.phones}">
        ${phone.number}
    </c:forEach>
</ul>

</body>
</html>