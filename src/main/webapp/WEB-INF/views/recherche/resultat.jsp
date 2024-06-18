<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Résultats de la recherche</title>
</head>
<body>
<h1>Résultats de la recherche</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Date d'insertion</th>
        <th>Salaire</th>
        <th>Titre</th>
        <!-- Ajoutez d'autres colonnes selon vos besoins -->
    </tr>
    </thead>
    <tbody>
    <tr th:each="poste : ${results}">
        <td th:text="${poste.idPoste}"></td>
        <td th:text="${poste.posteDescription}"></td>
        <td th:text="${poste.posteDateInsertion}"></td>
        <td th:text="${poste.posteSalaire}"></td>
        <td th:text="${poste.posteTitre}"></td>
        <!-- Ajoutez d'autres colonnes selon vos besoins -->
    </tr>
    </tbody>
</table>
</body>
</html>
