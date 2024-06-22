let FormationApp = angular.module("FormationApp",[]);

FormationApp.controller('tableController', function($scope, $http) {

    $http.get("/formation/liste")
    .then(function(response) {
        $scope.formations = response.data;
        for(let i=0;i<$scope.formations.length;i++){
            let date = new Date($scope.formations[i].dateDebut);
            date.setDate(date.getDate()+1)
            $scope.formations[i].dateDebut=date;
        }
        console.log($scope);
    });

    $http.get("/formation/diplome")
    .then(function(response) {
        $scope.diplomes = response.data;
        console.log($scope);
    });

    const submitButton=document.getElementById("buttonSubmit");

    $scope.recherche="";
    $http.get("/utilisateur/connected")
    .then(function(response) {
        $scope.utilisateur = response.data;
    },function(error){
        console.log("Erreur sur l'utilisateur");
    });

    $scope.initialize=function(){
        $scope.entreprise={};
        $scope.entreprise.dateDebut="";
        $scope.entreprise.dateFin="";
        $scope.entreprise.description="";
        submitButton.innerText="Ajouter";
    }

    $scope.modify = function(idFormation){
        $http.get("/formation/information?idFormation="+idFormation)
        .then(function(response) {
            $scope.formation = response.data;
            submitButton.innerText="Modifier";
            console.log($scope.formation);
        });
    }

    $scope.delete = function(idFormation){
        $http.get("/formation/delete?idFormation="+idFormation)
        .then(function(response) {
            $scope.formations = response.data;
        });
    }

    $scope.submitForm = function() {
        if(submitButton.innerText="Modifier"){
            $scope.updateForm();
        }
        else{
            $scope.insertForm();
        }
    };

    $scope.insertForm = function() {
        $scope.formation.dateDebut=document.getElementById("dateDebut").value;
        if(document.getElementById("dateFin").value!=""){
            $scope.formation.dateFin=document.getElementById("dateFin").value;
        }
        $scope.formation.utilisateur=$scope.utilisateur;
        console.log("Sending data:", JSON.stringify($scope.formation)); // Afficher le JSON dans la console
        $http.post('/formation/insert', $scope.formation)
        .then(function(response) {
            $scope.formations = response.data;
            $scope.initialize();
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    }

    $scope.updateForm = function() {
        $scope.formation.dateDebut=document.getElementById("dateDebut").value;
        if(document.getElementById("dateFin").value!=""){
            $scope.formation.dateFin=document.getElementById("dateFin").value;
        }
        console.log("Update");
        $scope.formation.utilisateur=$scope.utilisateur;
        console.log("Sending data:", JSON.stringify($scope.formation)); // Afficher le JSON dans la console
        $http.post('/formation/update', $scope.formation)
        .then(function(response) {
            $scope.formations = response.data;
            console.log($scope.formations);
            for(let i=0;i<$scope.formations.length;i++){
                let date = new Date($scope.formations[i].dateDebut);
                date.setDate(date.getDate()+1);
                $scope.formations[i].dateDebut=date;
            }
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            console.log(error);
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});