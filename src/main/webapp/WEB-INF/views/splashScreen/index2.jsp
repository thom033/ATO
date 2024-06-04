
<%@ page import="itu.user.Utilisateur" %>
<%@ page import="java.util.List" %>
<%
    List<Utilisateur> utilisateurList = (List<Utilisateur>) request.getAttribute("listeUtilisateur");
    Utilisateur user = request.getAttribut("user");
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
    <%
        for (int i = 0; i < utilisateurList.size() ; i++) { %>
            <tr>
                <td><%= i %></td>
                <td><%= utilisateurList.get(i).getNom() %></td>
            </tr>
        <% } %>
</body>
</html>
