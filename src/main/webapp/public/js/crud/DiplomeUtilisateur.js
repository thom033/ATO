let DiplomeUtilisateurApp = angular.module("DiplomeUtilisateurApp",[]);

DiplomeUtilisateurApp.controller('tableController', function($scope, $http) {

    $http.get("/diplomeUtilisateur/liste")
    .then(function(response) {
        $scope.diplomeUtilisateurs = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.diplomeUtilisateur.diplome.diplome="";
        $scope.diplomeUtilisateur.diplome.niveau=0;
    }

    $scope.modify = function(idDiplome,idUtilisateur){
        $http.get("/diplomeUtilisateur/information?idDiplome="+idDiplome+"&idUtilisateur="+idUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateur = response.data;
            const submitButton=document.getElementById("buttonSubmit");
            submitButton.innerText="Modifier";
            document.getElementById("formulaire").setAttribute("ng-submit", "updateForm()");
            console.log($scope.diplomeUtilisateur);
        });
    }

    $scope.delete = function(idDiplome,idUtilisateur){
        $http.get("/diplomeUtilisateur/delete?idDiplome="+idDiplome+"&idUtilisateur="+idUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateurs = response.data;
        });
    }

    $scope.submitForm = function() {
        console.log("Sending data:", JSON.stringify($scope.diplomeUtilisateur)); // Afficher le JSON dans la console
        $http.post('/diplomeUtilisateur/insert', $scope.diplomeUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateurs = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.diplomeUtilisateur)); // Afficher le JSON dans la console
        $http.post('/diplomeUtilisateur/update/', $scope.diplomeUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateurs = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});