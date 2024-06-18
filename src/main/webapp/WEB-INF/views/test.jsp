<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Postes</title>
</head>
<body>
    <h1>Liste des Postes</h1>
    
    <table>
        <thead>
            <tr>
                <th>Titre</th>
                <th>Description</th>
                <!-- Ajoutez d'autres colonnes ici selon vos besoins -->
            </tr>
        </thead>
        <tbody>
            <!-- Boucle sur chaque poste dans la liste -->
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
    <c:when test="${isEmpty}">
        <p>CC TEST TEST</p>
    </c:when>
    <c:otherwise>
        <table>
            <thead>
                <tr>
                    <th>Titre</th>
                    <th>Description</th>
                    <!-- Ajoutez d'autres colonnes ici selon vos besoins -->
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listPost}" var="post">
                    <tr>
                        <td>${post.xx}</td>
                        <td>${post.posteDescription}</td>
                        <!-- Ajoutez d'autres colonnes ici selon vos besoins -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>

        </tbody>
    </table>
</body>
</html>
