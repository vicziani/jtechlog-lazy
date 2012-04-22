<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Employees</title>
</head>
<body>
<ul>
    <c:forEach var="employee" items="${employees}">

        <a href="<c:url value="/employee.html?id=${employee.id}" />">${employee.name}</a>
        [ <a href="<c:url value="/editEmployee.html?id=${employee.id}" />">edit</a> ]
        
        <p>${employee.cv}</p>
        <ul>
            <c:forEach var="phone" items="${employee.phones}">
                ${phone.number}
            </c:forEach>
        </ul>
    </c:forEach>
</ul>
</body>
</html>