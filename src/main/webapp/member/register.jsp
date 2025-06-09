<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/Board-WEB/resources/css/layout.css">
</head>
<body>
<header>
    <jsp:include page="/include/topMenu.jsp" />
</header>
<section>
    <div align="center">
        <h2>회원가입</h2>
        <form action="/Board-WEB/member/register.do" method="post">
            <table>
                <tr><th>ID</th><td><input type="text" name="id"></td></tr>
                <tr><th>PASSWORD</th><td><input type="password" name="password"></td></tr>
                <tr><th>NAME</th><td><input type="text" name="name"></td></tr>
                <tr><th>NICKNAME</th><td><input type="text" name="nickname"></td></tr>
                <tr><th>AGE</th><td><input type="number" name="age"></td></tr>
                <tr><th>GENDER</th><td><input type="text" name="gender"></td></tr>
                <tr><th>HEIGHT</th><td><input type="number" step="0.1" name="height"></td></tr>
                <tr><th>WEIGHT</th><td><input type="number" step="0.1" name="weight"></td></tr>
            </table>
            <button type="submit">가입</button>
        </form>
    </div>
</section>
<footer>
    <%@ include file="/include/footer.jsp" %>
</footer>
</body>
</html>
