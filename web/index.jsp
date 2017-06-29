<%--
  Created by IntelliJ IDEA.
  User: JF194405
  Date: 23.06.2017
  Time: 09:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Index</title>
    <link href="nyan_cat.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  <audio src="sound/nyan_cat.mp3" autoplay></audio>
  <a href="/Login.jsp">Login</a> <br/>
  <a href="/register.jsp">Zarejestruj</a> <br/>
  <a href="/ip.jsp">Sprawdź lokalizację IP</a>


    <form method="get" action="http://localhost:8080/test" style="text-align: center; color: aliceblue">
      Podaj swe imie kmiocie! <br />
      <input type="text" name="param1" /><br />
      <input type="submit" value="Klikaj!">
    </form>



  </body>
</html>
