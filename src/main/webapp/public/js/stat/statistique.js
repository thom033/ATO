let ReponseApp = angular.module("statApp",[]);

ReponseApp.controller('statController', function($scope, $http) {
    $scope.secteurRecherche = function(){
        $http.get("/statistique/secteurRecherche")
            .then(function(response) {
                if (response){
                    console.log(response.data);
                }
            })
            .then(function(error) {
                if (error){
                    console.log(error);
                }
            });
    }

    // --- cout point travail betsaka mi_postule --
    $scope.coutTravail = function(){
        $http.get("/statistique/pointTravailPostule")
            .then(function(response) {
                if (response){
                    console.log(response.data);
                }
            })
            .then(function(error) {
                if (error){
                    console.log(error);
                }
            });
    }

    // --- total point vendu entre deux date données --
    $scope.achatPoint = function(){
        $http.get("/statistique/pointVendu")
            .then(function(response) {
                if (response){
                    console.log(response.data);
                }
            })
            .then(function(error) {
                if (error){
                    console.log(error);
                }
            });
    }
})