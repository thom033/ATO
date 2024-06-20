let DiplomeApp = angular.module("DiplomeApp",[]);

DiplomeApp.controller('tableController', function($scope, $http) {

    var submitButton=document.getElementById("buttonSubmit");

    $http.get("/diplome/liste")
    .then(function(response) {
        $scope.diplomes = response.data;
        console.log($scope);
    });

    $http.get("/secteur/liste")
    .then(function(response) {
        $scope.secteurs = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.diplome.id=0;
        $scope.diplome.diplome="";
        $scope.diplome.secteur=[];
        $scope.diplome.niveau=0;
        submitButton.innerText="Ajouter"
    }

    $scope.getNiveau=function(number){
        if(number==1){
            return "";
        }
        if(number==2){
            return "Licence";
        }
        if(number==3){
            return "Master";
        }
        else{
            return "Doctorat"
        }
    }

    $scope.modify = function(idDiplome){
        $http.get("/diplome/information?idDiplome="+idDiplome)
        .then(function(response) {
            $scope.diplome = response.data;
            submitButton.innerText="Modifier";
            console.log($scope.diplome);
        });
    }

    $scope.delete = function(idDiplome){
        $http.get("/diplome/delete?idDiplome="+idDiplome)
        .then(function(response) {
            $scope.diplomes = response.data;
        });
    }

    $scope.submitForm = function() {
        console.log("insert")
        if(submitButton.innerText=="Modifier"){
            $scope.updateForm();
        }
        else{
            $scope.insertForm();
        }
    };

    $scope.insertForm=function(){
        secteur=[];
        secteur.push($scope.diplome.secteur);
        $scope.diplome.secteur=secteur;
        console.log("Sending data:", JSON.stringify($scope.diplome)); // Afficher le JSON dans la console
        $http.post('/diplome/insert', $scope.diplome)
        .then(function(response) {
            $scope.diplomes = response.data;
            $scope.initialize();
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.diplome)); // Afficher le JSON dans la console
        $http.post('/diplome/update', $scope.diplome)
        .then(function(response) {
            $scope.diplomes = response.data;
            $scope.initialize();
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});