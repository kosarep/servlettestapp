<%--
  Created by IntelliJ IDEA.
  User: JF194405
  Date: 23.06.2017
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <%
    boolean flag;
    if (session.getAttribute("flag") != null) {
        flag = (boolean) session.getAttribute("flag");
    } else {
        flag = false;
    }
    if (flag) {
    %>
        Nazwa jest zajęta! Wpisz jeszcze raz. <br/>
    <%
    }
    %>
    <form method="post" action="checkNewUser.jsp">
    Podaj login: <br />
    <input type="text" name="name" /><br />
    Podaj hasło: <br />
    <input type="text" name="password" /><br />
    <input type="submit" value="Zarejestruj">
    </form>
</body>
</html>
