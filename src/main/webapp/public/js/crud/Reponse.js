let ReponseApp = angular.module("ReponseApp",[]);

ReponseApp.controller('tableController', function($scope, $http) {

    $http.get("/reponse/liste")
    .then(function(response) {
        $scope.reponses = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.reponse.idReponse=0;
        $scope.reponse.reponse="";
        $scope.reponse.question.question="";
    }

    $scope.modify = function(idReponse){
        $http.get("/reponse/information?idReponse="+idReponse)
        .then(function(response) {
            $scope.reponse = response.data;
            console.log($scope.reponse);
        });
    }

    $scope.delete = function(idReponse){
        $http.get("/reponse/delete?idReponse="+idReponse)
        .then(function(response) {
            $scope.reponses = response.data;
        });
    }

    $scope.submitForm = function() {
        console.log("Sending data:", JSON.stringify($scope.reponse)); // Afficher le JSON dans la console
        $http.post('/reponse/insert', $scope.reponse)
        .then(function(response) {
            $scope.reponses = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.reponse)); // Afficher le JSON dans la console
        $http.post('/reponse/update/', $scope.reponse)
        .then(function(response) {
            $scope.reponses = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});