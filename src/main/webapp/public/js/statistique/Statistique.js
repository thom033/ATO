let StatistiqueApp = angular.module("StatistiqueApp",[]);

StatistiqueApp.controller('statistiqueController', function($scope, $http) {

    $scope.annee=2024;
    
    $http.get("/point/statistique?annee=2024")
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
                labels: $scope.labels,
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
            labels: $scope.labels,
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
        $scope.chartPoint.data = $scope.data;
        $scope.chartPoint.datasets[0].data = $scope.labels;
        $scope.chartPoint.update();
    }
});