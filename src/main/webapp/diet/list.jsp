<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diet Records</title>
<link rel="stylesheet" href="/Board-WEB/resources/css/layout.css">
</head>
<body>
    <header>
        <jsp:include page="/include/topMenu.jsp" />
    </header>
    <section>
        <div align="center">
            <h2>Diet Records</h2>
            <table border="1" style="width:90%">
                <tr>
                    <th>Date</th>
                    <th>Meal</th>
                    <th>Food</th>
                    <th>Calories</th>
                    <th>Memo</th>
                </tr>
                <c:forEach items="${ dietList }" var="diet">
                    <tr>
                        <td>${ diet.date }</td>
                        <td>${ diet.mealType }</td>
                        <td><c:out value="${ diet.foodName }"/></td>
                        <td>${ diet.calories }</td>
                        <td><c:out value="${ diet.memo }"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </section>
    <footer>
        <%@ include file="/include/footer.jsp" %>
    </footer>
</body>
</html>
