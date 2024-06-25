<%@ page import="itu.faq.StatistiqueQuestion"%>
<%@ page import="java.util.List"%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%
    List<StatistiqueQuestion> statistiqueQuestions=(List<StatistiqueQuestion>)request.getAttribute("statistiqueQuestion");
%>
<style>
    .question{
        margin: 3%;
        border-radius:15px;
        border: solid 1px;
    }
</style>
<link rel="stylesheet" href="/public/css/input.css">
<link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
<div class="container" style="font-family:Helvetica;border-bottom: solid;padding-bottom: 5%;">
    <div class="">
        <div class="container mt-5">
            <div class="content" ng-app="StatistiqueApp">
                <div class="row justify-content-center">

                    <div class="col-6" style="padding-left: 5%;">
                        <h1><strong> TABLEAU DE BORD</strong></h1>
                        <p class="pStatistique">Statistique des données selon différents sujet</p>
                        <div class="row mb-3">
                            <ul class="navbar-nav mx-auto">
                                <a class="btn btn-light" href="/admin/dashboard#!/monnaie" style="font-family: 'Space Grotesk';width: fit-content;">Revenu</a>
                            </ul>
                        </div>
                        <div class="row mb-3">
                            <ul class="navbar-nav mx-auto">
                                <a class="btn btn-light" href="/admin/dashboard#!/point" style="font-family: 'Space Grotesk';width: fit-content;">Nombre de points par mois</a>
                            </ul>
                        </div>
                        <div class="row mb-3">
                            <ul class="navbar-nav mx-auto">
                                <a class="btn btn-light" href="/admin/dashboard#!/embauche" style="font-family: 'Space Grotesk';width: fit-content;">Nombre de personnes embauché</a>
                            </ul>
                        </div>
                        <div class="row mb-3">
                            <ul class="navbar-nav mx-auto">
                                <a class="btn btn-light" href="/admin/dashboard#!/secteur" style="font-family: 'Space Grotesk';width: fit-content;">Secteurs le plus demandé</a>
                            </ul>
                        </div>
                        <div class="row mb-3">
                            <ul class="navbar-nav mx-auto">
                                <a class="btn btn-light" href="/admin/dashboard#!/changer_prix" style="font-family: 'Space Grotesk';width: fit-content;">Changer la prix des points</a>
                            </ul>
                        </div>
                    </div>
                    <%-- <div class="col-md-6" ng-app="StatistiqueApp" ng-controller="statistiqueController">
                        <canvas id="barChartCanvas"></canvas>
                    </div> --%>
                    <div class="col-md-6" ng-view>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container" style="font-family:Helvetica;padding-top: 3%;">
    <div class="entete">
        <h1><strong>FAQ  -  QUESTIONS</strong></h1>
        <a href="/admin/dashboard/question/delete" class="btn btn-danger">Réinitialiser historique</a>
        <p class="pFaq">Les questions les plus posee</p>
    </div>

    <div class="row align-items-center" >
    <%
        if(statistiqueQuestions.size()==0){
    %>
    <p>Aucune question dans l'historique</p>
    <%}%>
    <% for(int i=0;i<statistiqueQuestions.size();i++){%>
        <div class="col colloneFaq question">
            <p><%= statistiqueQuestions.get(i).getQuestion() %></p>
            <h4 style="font-weight:bold;"><%= statistiqueQuestions.get(i).getNbQuestion() %> fois</h4>
        </div>
    <% } %>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/public/js/angular.min.js"></script>
<script src="/public/js/angular-route.js"></script>
<script src="/public/js/statistique/Statistique.js"></script>