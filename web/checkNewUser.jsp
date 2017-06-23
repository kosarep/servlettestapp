<%--
  Created by IntelliJ IDEA.
  User: JF194405
  Date: 23.06.2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <jsp:useBean id="user" class="kosa.User" scope="session"></jsp:useBean>
    <jsp:setProperty name="user" property="*"></jsp:setProperty>
    <jsp:useBean id="dataSource" class="kosa.DataSource" scope="session"></jsp:useBean>

    <%
    boolean flag = true;
    String result = "";
    if (dataSource.nameExists(user)) {
        flag = true;
        session.setAttribute("flag", flag);
        response.sendRedirect("register.jsp");
    } else {
        dataSource.createUser(user);
        result = "Utworzono konto: " + user.getName();
    %>
    <%=result%>
    <%
    }
    %>

</body>
</html>
