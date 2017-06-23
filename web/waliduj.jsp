<%--
  Created by IntelliJ IDEA.
  User: JF194405
  Date: 23.06.2017
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>waliduj</title>
</head>
<body>
    <jsp:useBean id="user" class="kosa.User" scope="session"></jsp:useBean>
    <jsp:setProperty name="user" property="*"></jsp:setProperty>
    <jsp:useBean id="dataSource" class="kosa.DataSource" scope="session"></jsp:useBean>
    Nazwa: <%= user.getName() %><br />

    <% String result = "Dane niepoprawne!";
    if (dataSource.userExists(user)) {
        result = "Poprawny użytkownik oraz hasło.";
    }
    %>

    <%=result%>
</body>
</html>
