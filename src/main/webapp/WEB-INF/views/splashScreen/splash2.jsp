
<%@ page import="itu.user.Notification" %>
<%@ page import="java.util.List" %>
<%
    Utilisateur user = (Utilisateur) request.getAttribute("user");
    out.print(user.getNom());
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome to ATO</h1>
    <h2>Vous etes sur splash screen</h2>
</body>
</html>
