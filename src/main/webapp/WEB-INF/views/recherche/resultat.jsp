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
                <h5><%= result.get("poste_titre") != null ? result.get("poste_titre") : "Non spécifié" %></h5>
                <p><strong>Secteur:</strong> <%= result.get("secteur_nom") != null ? result.get("secteur_nom") : "Non spécifié" %></p>
                <p><strong>Compétence requise:</strong> <%= result.get("competence_requise") != null ? result.get("competence_requise") : "Non spécifié" %></p>
                <p><strong>Âge requis:</strong> <%= result.get("age_requise") != null ? result.get("age_requise") : "Non spécifié" %></p>
                <p><strong>Salaire:</strong> <%= result.get("poste_salaire") != null ? result.get("poste_salaire") : "Non spécifié" %></p>
                <p><strong>Distance:</strong> <%= result.get("distance") != null ? result.get("distance") : "Non spécifié" %></p>
                <p><strong>Années d'expérience:</strong> <%= result.get("nbr_annee_experience") != null ? result.get("nbr_annee_experience") : "Non spécifié" %></p>
                <p><strong>Entreprise:</strong> <%= result.get("entreprise_nom") != null ? result.get("entreprise_nom") : "Non spécifié" %></p>
                <p><strong>Type:</strong> <%= result.get("entreprise_type") != null ? result.get("entreprise_type") : "Non spécifié" %></p>
                <p><strong>Date de création:</strong> <%= result.get("entreprise_date_creation") != null ? result.get("entreprise_date_creation") : "Non spécifié" %></p>
                <p><strong>Adresse:</strong> <%= result.get("entreprise_adresse") != null ? result.get("entreprise_adresse") : "Non spécifié" %></p>
                <p><strong>Site web:</strong> <%= result.get("entreprise_site_web") != null ? result.get("entreprise_site_web") : "Non spécifié" %></p>
                <p><strong>Email:</strong> <%= result.get("entreprise_mail") != null ? result.get("entreprise_mail") : "Non spécifié" %></p>
                <p><strong>Numéro de téléphone:</strong> <%= result.get("entreprise_num_telephone") != null ? result.get("entreprise_num_telephone") : "Non spécifié" %></p>
                <img src="<%= result.get("entreprise_image") != null ? result.get("entreprise_image") : "default_image.jpg" %>" alt="Image de l'entreprise">
            </div>
            <hr/>
        <% } %>
    <% } else { %>
        <p>Aucun résultat trouvé.</p>
    <% } %>
</body>
</html>
