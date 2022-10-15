<%-- 
    Document   : Login
    Created on : Oct 9, 2022, 1:54:26 AM
    Author     : bo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login </title>
    </head>
    <body>
        <h1>Login</h1>
    <div>
    <form method="POST" action="login">
         <div> <label for="username">Username</label>
         <input type="text" name="username" value="${username}">
         </div><br>
         <div> <label for="password">Password</label>
         <input type="text" name="password" value="${password}">
         </div>
         <input type="submit" value="log in">
        </form>
     <c:if test="${error == true}">
            <h3>The username and password do not match!!.</h3>
        </c:if>
       <c:if test="${justLogout == true}">
            <h3>You have logged out.</h3>
        </c:if>
    </dic>
    </body>
</html>
