<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Résultats de la recherche</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
</head>
<body>
    <h1>Résultats de la recherche</h1>

    <%-- Check if there are results to display --%>
    <% if (request.getAttribute("results") != null && !((List<Map<String, Object>>) request.getAttribute("results")).isEmpty()) { %>
        <%-- Loop through the results --%>
        <% for (Map<String, Object> result : (List<Map<String, Object>>) request.getAttribute("results")) { %>
            <div>
                <h5><%= result.get("poste_titre") %></h5>
                <p><strong>Diplôme:</strong> <%= result.get("id_diplome") %></p>
                <p><strong>Secteur:</strong> <%= result.get("id_secteur") %></p>
                <p><strong>Competence:</strong> <%= result.get("competence_requise") %></p>
                <p><strong>Age:</strong> <%= result.get("age_requise") %></p>
                <p><strong>Salaire:</strong> <%= result.get("salaire_requise") %></p>
                <p><strong>Distance:</strong> <%= result.get("distance") %></p>
                <p><strong>Annee d'experience:</strong> <%= result.get("nbr_annee_experience") %></p>

                <%-- Debug section --%>
                <pre><%= result %></pre>
            </div>
            <hr/>
        <% } %>
    <% } else { %>
        <p>Aucun résultat trouvé.</p>
    <% } %>
</body>
</html>
