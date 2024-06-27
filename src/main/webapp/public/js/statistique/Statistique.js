let StatistiqueApp = angular.module("StatistiqueApp",["ngRoute"]);

StatistiqueApp.config(['$routeProvider',function ($routeProvider){
    $routeProvider
        .when('/point',{
            templateUrl:'/admin/dashboard/statistique/point',
            controller:'statistiquePointController'
        })
        .when('/embauche',{
            templateUrl:'/admin/dashboard/statistique/embauche',
            controller:'statistiqueEmbaucheController'
        })
        .when('/secteur',{
            templateUrl:'/admin/dashboard/statistique/secteur',
            controller:'statistiqueSecteurController'
        })
        .when('/monnaie',{
            templateUrl:'/admin/dashboard/statistique/monnaie',
            controller:'statistiqueMonnaieController'
        })
        .when('/changer_prix',{
            templateUrl:'/admin/dashboard/prix_point/changer',
            controller:'changePriceController'
        })
}]);

StatistiqueApp.controller('statistiquePointController', function($scope, $http) {
    const currentDate=new Date();
    $scope.annee=currentDate.getFullYear();
    const mois=["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];    
    $http.get("/point/statistique?annee="+$scope.annee)
    .then(function(response) {
        $scope.statistique = response.data;
        $scope.initialize($scope.createCourbe);
        console.log($scope);
    });

    $scope.getStatPoint=function(){
        $http.get("/point/statistique?annee="+$scope.annee)
        .then(function(response) {
            $scope.statistique = response.data;
            $scope.initialize($scope.updateCourbe);
            console.log($scope);
        }); 
    }

    $scope.initialize=function(callback){
        $scope.labels=[];
        $scope.data=[];
        for(let i=0;i<$scope.statistique.length;i++){
            $scope.labels.push($scope.getMois($scope.statistique[i].mois));
            $scope.data.push($scope.statistique[i].nombre);
        }
        callback();
    }

    $scope.getMois=function (number){
        const mois=["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];
        return mois[number-1];
    }

    $scope.createBaton= function () {
        // Statistique en bâtons
        const barChartContainer = document.getElementById('barChartCanvas');
        if (!barChartContainer) {
            console.error('Bar chart container not found.');
            return;
        }
        const barCtx = barChartContainer.getContext('2d');
        const barChart = new Chart(barCtx, {
            type: 'bar',
            data: {
                labels: mois,
                datasets: [{
                    label: 'Statistique Bâton',
                    data: $scope.data,
                    backgroundColor: 'rgba(255, 99, 132, 0.2)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    };

    $scope.createCamembert=function(){
        var data = {
            labels: ['Catégorie 1', 'Catégorie 2', 'Catégorie 3'],
            datasets: [{
                data: [30, 40, 30],
                backgroundColor: ['#ff6384', '#36a2eb', '#ffce56']
            }]
        };
        
        var options = {
            responsive: true,
            maintainAspectRatio: false
        };
        
        var ctx = document.getElementById('myPieChart').getContext('2d');
        
        var myPieChart = new Chart(ctx, {
            type: 'pie',
            data: data,
            options: options
        });
    }

    $scope.createCourbe=function(){
        var ctx = document.getElementById('myChart').getContext('2d');

        var data = {
            labels: mois,
            datasets: [{
                label: 'Nombre de points obtenues',
                data: $scope.data,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        };

        var options = {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        };

        // Créer le graphique
        $scope.chartPoint = new Chart(ctx, {
            type: 'line', 
            data: data, 
            options: options
        });
    }

    $scope.updateCourbe=function(){
        console.log($scope.chartPoint);
        $scope.chartPoint.data.datasets[0].data = $scope.data;
        $scope.chartPoint.labels = $scope.labels;
        $scope.chartPoint.update();
    }
});

StatistiqueApp.controller('statistiqueEmbaucheController', function($scope, $http) {
    const currentDate=new Date();
    $scope.annee=currentDate.getFullYear();
    const mois=["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];    
    $scope.getMois=function (number){
        return mois[number-1];
    }
    
    $http.get("/embauche/statistique?annee="+$scope.annee)
    .then(function(response) {
        $scope.statistique = response.data;
        $scope.initialize($scope.createCourbe);
        console.log($scope);
    });

    $scope.getStatEmbauche=function(){
        $http.get("/embauche/statistique?annee="+$scope.annee)
        .then(function(response) {
            $scope.statistique = response.data;
            $scope.initialize($scope.updateCourbe);
        });
    }

    $scope.createCourbe=function(){
        var ctx = document.getElementById('myChart').getContext('2d');

        var data = {
            labels: mois,
            datasets: [{
                label: 'Nombre de personnes embauchés',
                data: $scope.data,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        };

        var options = {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        };

        // Créer le graphique
        $scope.chartPoint = new Chart(ctx, {
            type: 'line', 
            data: data, 
            options: options
        });
    }

    $scope.initialize=function(callback){
        $scope.labels=[];
        $scope.data=[];
        for(let i=0;i<$scope.statistique.length;i++){
            $scope.labels.push($scope.getMois($scope.statistique[i].mois));
            $scope.data.push($scope.statistique[i].nbEntretien);
        }
        callback();
    }

    $scope.updateCourbe=function(){
        console.log($scope.chartPoint);
        $scope.chartPoint.data.datasets[0].data = $scope.data;
        $scope.chartPoint.update();
    }
});

StatistiqueApp.controller('statistiqueMonnaieController', function($scope, $http) {
    const currentDate=new Date();
    $scope.monnaieString="";
    $scope.annee=currentDate.getFullYear();
    const mois=["Janvier","Février","Mars","Avril","Mai","Juin","Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];    
    $scope.getMois=function (number){
        return mois[number-1];
    }
    
    $http.get("/monnaie/statistique?annee="+$scope.annee)
    .then(function(response) {
        $scope.statistique = response.data;
        $scope.initialize($scope.createCourbe);
        console.log($scope);
    });

    $scope.getStatMonnaie=function(){
        $http.get("/monnaie/statistique?annee="+$scope.annee)
        .then(function(response) {
            $scope.statistique = response.data;
            $scope.initialize($scope.updateCourbe);
        });
    }

    $scope.getMonnaieDate=function(){
        var data={
            dateMin:document.getElementById("dateMin").value,
            dateMax:document.getElementById("dateMax").value
        }
        var link="/monnaie/rentrant_date?dateMin="+data.dateMin+"&dateMax="+data.dateMax
        console.log(link);
        $http.get(link)
        .then(function(response) {
            $scope.monnaieString="Revenu :"+response.data;
        });
    }

    $scope.createCourbe=function(){
        var ctx = document.getElementById('myChart').getContext('2d');

        var data = {
            labels: mois,
            datasets: [{
                label: 'Revenu par mois',
                data: $scope.data,
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                borderColor: 'rgba(255, 99, 132, 1)',
                borderWidth: 1
            }]
        };

        var options = {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        };

        // Créer le graphique
        $scope.chartPoint = new Chart(ctx, {
            type: 'line', 
            data: data, 
            options: options
        });
    }

    $scope.initialize=function(callback){
        $scope.labels=[];
        $scope.data=[];
        for(let i=0;i<$scope.statistique.length;i++){
            $scope.labels.push($scope.getMois($scope.statistique[i].mois));
            $scope.data.push($scope.statistique[i].monnaie);
        }
        callback();
    }

    $scope.updateCourbe=function(){
        console.log($scope.chartPoint);
        $scope.chartPoint.data.datasets[0].data = $scope.data;
        $scope.chartPoint.update();
    }
});

StatistiqueApp.controller('statistiqueSecteurController', function($scope, $http) {
    const currentDate=new Date();
    $scope.annee=currentDate.getFullYear();
    $scope.mois=currentDate.getMonth()+1;
    $scope.months=[{value:0,mois:"Tous"},{value:1,mois:"Janvier"},{value:2,mois:"Février"}
                    ,{value:3,mois:"Mars"},{value:4,mois:"Avril"},
                    {value:5,mois:"Mai"},{value:6,mois:"Juin"},{value:7,mois:"Juillet"}
                    ,{value:8,mois:"Aout"},{value:9,mois:"Septembre"},{value:10,mois:"Octobre"},
                    {value:11,mois:"Novembre"},{value:12,mois:"Decembre"}];
    
    $http.get("/secteur/statistique?annee="+$scope.annee+"&mois="+$scope.mois)
    .then(function(response) {
        $scope.statistique = response.data;
        $scope.initialize($scope.createCamembert);
        console.log($scope);
    });

    $scope.getStatSecteur=function(){
        var link="/secteur/statistique?annee="+$scope.annee;
        if($scope.mois!=0){
            link+="&mois="+$scope.mois;
        }
        else{
            link="/secteur/statistique/annee?annee="+$scope.annee;
        }
        console.log(link);
        $http.get(link)
        .then(function(response) {
            $scope.statistique = response.data;
            $scope.initialize($scope.updateCamembert);
        });
    }

    $scope.createCamembert=function(){
        var data = {
            labels: [...new Set($scope.labels)],
            datasets: [{
                data: $scope.data,
                backgroundColor: ['#ff6384', '#36a2eb', '#ffce56']
            }]
        };
        
        var options = {
            responsive: true,
            maintainAspectRatio: false
        };
        
        var ctx = document.getElementById('myPieChart').getContext('2d');
        
        $scope.camembert = new Chart(ctx, {
            type: 'pie',
            data: data,
            options: options
        });
    }

    $scope.initialize=function(callback){
        $scope.labels=[];
        $scope.data=[];
        for(let i=0;i<$scope.statistique.length;i++){
            $scope.labels.push($scope.statistique[i].secteur);
            $scope.data.push($scope.statistique[i].pourcentage);
        }
        callback();
    }

    $scope.updateCamembert=function(){
        console.log($scope.camembert);
        $scope.camembert.data.datasets[0].data = $scope.data;
        $scope.camembert.update();
    }
});

StatistiqueApp.controller('changePriceController', function($scope, $http) {
    const currentDate=new Date();
    $scope.newPrice=0;
    $scope.prixPoint={};
    $scope.prixPoint.prix=0;
    $scope.prixPoint.dateChangement=currentDate;

    $scope.promotion={};
    
    $http.get("/prix_point/actuel")
    .then(function(response) {
        $scope.newPrice = response.data;
        console.log($scope);
    });

    $http.get("/promotion/actuel")
    .then(function(response) {
        $scope.promotion = response.data;
        console.log($scope);
    });

    $scope.changePrice=function(){
        $scope.prixPoint.prix=$scope.newPrice;
        console.log(JSON.stringify($scope.prixPoint));
        $http.post("/prix_point/changer",$scope.prixPoint)
        .then(function(response){
            alert("updated");
        });
    }

    $scope.changePromotion=function(){
        $scope.promotion.id=0;
        $scope.promotion.dateChangement=currentDate;
        console.log(JSON.stringify($scope.promotion));
        $http.post("/promotion/changer",$scope.promotion)
        .then(function(response){
            alert("updated");
        });
    }
});