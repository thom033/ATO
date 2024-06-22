<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
<div class="container" style="font-family:Helvetica;border-bottom: solid;padding-bottom: 5%;">
    <div class="">
        <div class="container mt-5">
            <div class="content" ng-app="StatistiqueApp">
                <div class="row justify-content-center">

                    <div class="col-6" style="padding-left: 5%;">
                        <h1><strong> TABLEAU DE BORD</strong></h1>
                        <p class="pStatistique">Statistique des données selon différents sujet</p>

                        <button class="boutonStatistique">Age des Clients</button>
                        <br>
                        <button class="boutonStatistique">Secteurs les plus recherchés</button>
                        <br>
                        <button class="boutonStatistique">Succès travail selon points</button>
                        <br>
                        <button class="boutonStatistique">Achat de points</button>
                        
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
        <p class="pFaq">Les questions les plus posee</p>
    </div>

    <div class="row align-items-center" >
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/public/js/angular.min.js"></script>
<script src="/public/js/angular-route.js"></script>
<script src="/public/js/input.js"></script>
<script src="/public/js/statistique/Statistique.js"></script>