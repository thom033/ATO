<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <title>Résultats de la recherche</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Résultats de la recherche</h1>

    <%-- Check if there are results to display --%>
    <% if (request.getAttribute("results") != null && !((List<Map<String, Object>>) request.getAttribute("results")).isEmpty()) { %>
        <div class="list-group">
            <%-- Loop through the results --%>
            <% for (Map<String, Object> result : (List<Map<String, Object>>) request.getAttribute("results")) { %>
                <div class="list-group-item">
                    <h5 class="mb-1"><%= result.get("poste_titre") %></h5>
                    <p class="mb-1"><strong>Diplôme:</strong> <%= result.get("id_diplome") %></p>
                </div>
            <% } %>
        </div>
    <% } else { %>
        <p>Aucun résultat trouvé.</p>
    <% } %>
</body>
</html>
