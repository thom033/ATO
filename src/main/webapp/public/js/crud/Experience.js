let ExperienceApp = angular.module("ExperienceApp",[]);

ExperienceApp.controller('tableController', function($scope, $http) {

    $http.get("/experience/liste")
    .then(function(response) {
        $scope.experiences = response.data;
        for(let i=0;i<$scope.experiences.length;i++){
            let date = new Date($scope.experiences[i].dateDebut);
            date.setDate(date.getDate()+1)
            $scope.experiences[i].dateDebut=date;
        }
        console.log($scope);
    });

    $http.get("/experience/secteur")
    .then(function(response) {
        $scope.secteurs = response.data;
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
    }

    $scope.modify = function(idExperience){
        $http.get("/experience/information?idExperience="+idExperience)
        .then(function(response) {
            $scope.experience = response.data;
            submitButton.innerText="Modifier";
            console.log($scope.experience);
        });
    }

    $scope.delete = function(idExperience){
        $http.get("/experience/delete?idExperience="+idExperience)
        .then(function(response) {
            $scope.experiences = response.data;
        });
    }

    $scope.submitForm = function() {
        if(submitButton.innerText="Modifier"){
            $scope.insertForm();
        }
        else{
            $scope.updateForm();
        }
    };

    $scope.insertForm = function() {
        $scope.experience.dateDebut=document.getElementById("dateDebut").value;
        if(document.getElementById("dateFin").value!=""){
            $scope.experience.dateFin=document.getElementById("dateFin").value;
        }
        $scope.experience.utilisateur=$scope.utilisateur;
        console.log("Sending data:", JSON.stringify($scope.experience)); // Afficher le JSON dans la console
        $http.post('/experience/insert', $scope.experience)
        .then(function(response) {
            $scope.experiences = response.data;
            $scope.initialize();
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    }

    $scope.updateForm = function() {
        $scope.experience.dateDebut=document.getElementById("dateDebut").value;
        if(document.getElementById("dateFin").value!=""){
            $scope.experience.dateFin=document.getElementById("dateFin").value;
        }
        $scope.experience.utilisateur=$scope.utilisateur;
        console.log("Sending data:", JSON.stringify($scope.experience)); // Afficher le JSON dans la console
        $http.post('/experience/update', $scope.experience)
        .then(function(response) {
            $scope.experiences = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});