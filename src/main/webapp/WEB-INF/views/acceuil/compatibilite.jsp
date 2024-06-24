<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="itu.compatibilite.ResultAcceuil" %>

<%
    // Récupération des attributs depuis l'objet request
    ResultAcceuil poste = (ResultAcceuil) request.getAttribute("data");
    String[] positif = (String[]) request.getAttribute("positif");
    String[] negatif = (String[]) request.getAttribute("negatif");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Résultats de compatibilité</title>
    <style>
        .roundGreen, .roundRed {
            width: 75%;
            height: 25%;
            border-radius: 70%;
            margin-top: 70%;
        }
        .roundGreen {
            background-color: #7DF260;
        }
        .roundRed {
            background-color: red;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 mb-3" style="overflow: hidden;">
                <img src="/public/img/products/4.jpg" class="rounded mx-auto d-block" alt="..." style="width: 90%;">
            </div>
            <div class="col-md-8">
                <div class="container" style="padding-left: 5%;">
                    <div class="row">
                        <p style="font-size: 300%; font-weight: bold;"><%= poste.getPosteTitre() %></p>
                    </div>
                    <div class="row">
                        <p style="font-size: 150%; color: gray;">Nom de l'entreprise : <%= poste.getEntrepriseNom() %></p>
                    </div>
                    <div class="row">
                        <button style="width: 15%; margin-left: 1.75%" class="btn btn-outline-dark" type="button"><a href="/poste/details?idPoste=<%= poste.getIdPoste() %>">Voir le travail</a></button>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-6">
                        <p style="font-size: 150%; color: gray;">Taux de compatibilité :</p>
                    </div>
                    <div class="col-md-6">
                        <p style="font-size: 340%; color: red; font-weight: bold;"><%= poste.getPtsTotal() %> %</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-9">
                        <p style="font-size: 240%; font-weight: 600; color: gray;">+ Points positifs: </p>
                    </div>
                    <div class="col-md-2">
                        <p style="font-size: 240%; color: #00CF00; font-weight: 600;"><%= positif.length %></p>
                    </div>
                </div>
                <% for (int i = 0; i < positif.length; i++) { %> 
                <div class="row">
                    <div class="col-md-1">
                        <div class="roundGreen"></div>
                    </div>
                    <div class="col-md-11">
                        <p><%= positif[i] %></p>
                    </div>
                </div>
                <% } %>
            </div>
            <div class="col-md-4">
                <div class="row">
                    <div class="col-md-9">
                        <p style="font-size: 240%; font-weight: 600; color: gray;">- Points négatifs:</p>
                    </div>
                    <div class="col-md-2">
                        <p style="font-size: 240%; color: red; font-weight: 600;"><%= negatif.length %></p>
                    </div>
                </div>
                <% for (int i = 0; i < negatif.length; i++) { %>
                <div class="row">
                    <div class="col-md-1">
                        <div class="roundRed"></div>
                    </div>
                    <div class="col-md-11">
                        <p><%= negatif[i] %></p>
                    </div>
                </div>
                <% } %>
            </div>
        </div>
    </div>
</body>