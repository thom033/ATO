<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultats de la recherche</title>
    <!-- Include your CSS and JavaScript files here -->
</head>
<body>
    <div class="container">
        <h1>Résultats de la recherche</h1>

        <%-- Check if there are results to display --%>
        <% if (request.getAttribute("results") != null && !((List<Map<String, Object>>) request.getAttribute("results")).isEmpty()) { %>
            <div class="list-group">
                <%-- Loop through the results --%>
                <% for (Map<String, Object> result : (List<Map<String, Object>>) request.getAttribute("results")) { %>
                    <div class="list-group-item">
                        <h5 class="mb-1"><%= result.get("poste_titre") %></h5>
                        <p class="mb-1"><strong>Diplôme:</strong> <%= result.get("id_diplome") %></p>
                        <p class="mb-1"><strong>Secteur:</strong> <%= result.get("id_secteur") %></p>
                        <!-- Add other fields as needed -->
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="alert alert-info">
                Aucun résultat trouvé.
            </div>
        <% } %>

        <a href="/" class="btn btn-primary mt-3">Retour à l'accueil</a>
    </div>

    <!-- Include your JavaScript files here -->
</body>
</html>
