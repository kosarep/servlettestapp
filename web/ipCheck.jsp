<%@ page import="javax.xml.bind.JAXBException" %><%--
  Created by IntelliJ IDEA.
  User: JF194405
  Date: 26.06.2017
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <jsp:useBean id="serviceConnection" class="kosa.ip.ServiceConnection" scope="session"></jsp:useBean>

    <%
        try {
            serviceConnection.sendGet(request.getParameter("ipAddress"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    %>
    <%="IP: " + serviceConnection.ipParameteres.getRespIpAddress()%> <br />
    <%="Return Code: " + serviceConnection.ipParameteres.getReturnCode()%> <br />
    <%="Return Code Details: " + serviceConnection.ipParameteres.getReturnCodeDetails()%> <br />
    <%="Country Name: " + serviceConnection.ipParameteres.getCountryName()%> <br />
    <%="Country Code: " + serviceConnection.ipParameteres.getCountryCode()%> <br />

</body>
</html>
