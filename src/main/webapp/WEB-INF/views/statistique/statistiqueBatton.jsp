<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<title>Statistique</title>


<link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
<link rel="stylesheet" href="/public/css/input.css">

<%-- contenus 1 --%>
<div class="container" ng-app="statApp" ng-controller="statController" style="font-family:Helvetica;border-bottom: solid;padding-bottom: 5%;">
    <div class="card">
        <div class="container mt-5">
            <div class="content">
                <div class="row justify-content-center">
                    <div class="col-6" style="padding-left: 5%;">
                        <h1><strong> TABLEAU DE BORD</strong></h1>
                        <p class="pStatistique">Statistique des données selon différents sujet</p>
                        <button ng-click="ageClient()" class="boutonStatistique">Age des Clients</button><br>
                        <button ng-click="secteurRecherche()" class="boutonStatistique">Secteurs les plus recherchés</button><br>
                        <button ng-click="coutTravail()" class="boutonStatistique">Succès travail selon points</button><br>
                        <button ng-click="achatPoint()" class="boutonStatistique">Achat de points</button>
                    </div>
                    <div class="col-md-6">
                        <canvas id="barChartCanvas"></canvas>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%-- end contenus 1 --%>

<%-- contenus 2 --%>
<div class="container" style="font-family:Helvetica;padding-top: 3%;">
    <div class="entete">
        <h1><strong>FAQ - QUESTIONS</strong></h1>
        <p class="pFaq">Les questions les plus posee</p>
    </div>

    <div class="row align-items-center">
        <div class="col colloneFaq">
            <p>je ne comprends pas tres bien le fonctionnement des points et leur utilites</p>
            <h4>104 fois</h4>
        </div>

        <div class="col colloneFaq">
            <p>je ne comprends pas tres bien le fonctionnement des points et leur utilites</p>
            <h4>104 fois</h4>
        </div>
        <div class="col colloneFaq">
            <p>je ne comprends pas tres bien le fonctionnement des points et leur utilites</p>
            <h4>104 fois</h4>
        </div>
    </div>
</div>
<%-- end contenus 2 --%>

<%-- script js --%>
    <script src="/public/js/angular.min.js"></script>
    <script src="/public/js/stat/statistique.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="/public/js/stat/scriptBatton.js"></script>
<%-- end scripy js --%>

<%-- css --%>
<style>
    .boutonStatistique {
        margin-bottom: 1.5%;
        border-radius: 20px;
        border: solid 2px solid;
        padding-left: 5%;
        padding-right: 5%;
        border-color: black;
    }

    .pStatistique {
        color: grey;
        margin-top: -2%;
    }

    .pFaq {
        color: grey;
        margin-top: -1%;
    }

    .card {
        border: none;
    }

    .colloneFaq {
        background-color: rgb(171, 171, 171);
        margin-left: 2%;
        margin-right: 2%;
        border-radius: 20px;
    }

    .colloneFaq p {
        padding-top: 10px;
    }

    .colloneFaq h2 {
        margin-bottom: -1%;
    }

</style>
<%-- end css --%>
