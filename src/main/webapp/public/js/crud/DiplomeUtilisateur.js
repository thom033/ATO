let DiplomeUtilisateurApp = angular.module("DiplomeUtilisateurApp",[]);

DiplomeUtilisateurApp.controller('tableController', function($scope, $http) {

    $http.get("/diplomeUtilisateur/liste")
    .then(function(response) {
        $scope.diplomeUtilisateurs = response.data.diplomeUtilisateurs;
        $scope.diplomeExists = response.data.diplomeExists;
        console.log($scope.diplomeUtilisateurs);
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
        const submitButton=document.getElementById("buttonSubmit");
        if(submitButton.innerText=="Modifier"){
            $scope.updateForm();
        }
        else{
            $scope.insertForm();
        }
    };

    $scope.insertForm=function(){
        console.log("Insert");
        console.log("Sending data:", JSON.stringify($scope.diplomeUtilisateur)); // Afficher le JSON dans la console
        $http.post('/diplomeUtilisateur/insert', $scope.diplomeUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateurs = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    }

    $scope.updateForm = function() {
        console.log("JSON");
        // console.log($scope.diplomeUtilsateur.diplome);
        $scope.diplomeUtilisateur.id.diplome=$scope.diplomeUtilisateur.diplome.id;
        $scope.diplomeUtilisateur.id.utilisateur=$scope.diplomeUtilisateur.utilisateur.id;
        console.log("Sending data:", JSON.stringify($scope.diplomeUtilisateur)); // Afficher le JSON dans la console
        $http.post('/diplomeUtilisateur/update', $scope.diplomeUtilisateur)
        .then(function(response) {
            $scope.diplomeUtilisateurs = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});