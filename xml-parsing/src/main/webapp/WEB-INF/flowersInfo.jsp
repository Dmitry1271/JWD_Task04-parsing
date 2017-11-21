<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <title>flowers</title>
    <meta http-equiv="Content-type" content="text/html" charset="UTF-8">
</head>
<body>
<a href="../index.jsp"><h2>back</h2></a>
<table border="1" style="width: 64%; margin-left: 18%; margin-top: 100px;">
    <tr>
        <th>№</th>
        <th>name</th>
        <th>leaves color</th>
        <th>stem color</th>
        <th>soil</th>
        <th>temperature</th>
        <th>lighting</th>
        <th>watering</th>
        <th>multiplying</th>
    </tr>
    <c:forEach var="flower" items="${requestScope.flowerList}">
        <tr>
            <td>${flower.id}</td>
            <td>${flower.name}</td>
            <td>${flower.leavesColor}</td>
            <td>${flower.stemColor}</td>
            <td style="text-transform:lowercase">${flower.soil}</td>
            <td>${flower.growingType.temperature}</td>
            <td>${flower.growingType.lighting}</td>
            <td>${flower.growingType.watering}</td>
            <td style="text-transform: lowercase">${flower.multiplying}</td>
        </tr>
    </c:forEach>
</table>

<div style="margin-left: 45%;">
    <c:if test="${requestScope.currentPage != requestScope.firstPage && requestScope.prevPage != requestScope.firstPage}">
        <a href="/FrontController?command=${requestScope.command}&page=${requestScope.firstPage}">${requestScope.firstPage}</a> ...
    </c:if>


    <c:if test="${requestScope.currentPage != requestScope.firstPage}">
        <a href="/FrontController?command=${requestScope.command}&page=${requestScope.prevPage}">${requestScope.prevPage}</a>
    </c:if>

    <a><b><c:out value="${requestScope.currentPage}"/></b></a>

    <c:if test="${requestScope.currentPage != requestScope.lastPage}">
        <a href="/FrontController?command=${requestScope.command}&page=${requestScope.nextPage}">${requestScope.nextPage}</a>
    </c:if>


    <c:if test="${requestScope.currentPage != requestScope.lastPage && requestScope.nextPage != requestScope.lastPage}">
        ... <a href="/FrontController?command=${requestScope.command}&page=${requestScope.lastPage}">${requestScope.lastPage}</a>
    </c:if>
</div>

</body>
</html>
