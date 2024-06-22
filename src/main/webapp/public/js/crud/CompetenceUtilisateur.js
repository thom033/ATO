let CompetenceUtilisateurApp = angular.module("CompetenceUtilisateurApp",[]);

CompetenceUtilisateurApp.controller('tableController', function($scope, $http) {

    $scope.utilisateur={};
    $scope.competences=[];
    $scope.utilisateur.competences=[];
    $scope.recherche="";
    $http.get("/competenceUtilisateur/liste")
    .then(function(response) {
        $scope.competences = response.data;
        $scope.retirerDoublon();
    });

    $http.get("/utilisateur/connected")
    .then(function(response) {
        $scope.utilisateur = response.data;
        console.log($scope.utilisateur);
        $scope.retirerDoublon();
    },function(error){
        console.log("Erreur sur l'utilisateur");
    });

    $scope.initialize=function(){
        $scope.competenceUtilisateur.competence.competence="";
        $scope.competenceUtilisateur.competence.niveau=0;
    }

    $scope.submitForm = function() {
        $scope.updateForm();
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/update', $scope.utilisateur)
        .then(function(response) {
            alert("Modification effectué")
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.ajouter=function(competence){
        console.log(competence.id);
        $scope.competences = $scope.competences.filter(obj => obj.id !== competence.id);
        $scope.utilisateur.competences.push(competence);
    }

    $scope.retirer=function(competence){
        $scope.utilisateur.competences = $scope.utilisateur.competences.filter(obj => obj.id !== competence.id);
        $scope.competences.push(competence);
    }

    $scope.delete=function(array,objs){
        array = array.filter(obj => obj.id !== objs.id);
    }

    $scope.retirerDoublon=function(){
        for(let i=0;i<$scope.utilisateur.competences.length;i++){
            for(let e=0;e<$scope.competences.length;e++){
                if($scope.utilisateur.competences[i].id==$scope.competences[e].id){
                    $scope.competences = $scope.competences.filter(obj => obj.id !== $scope.utilisateur.competences[i].id);
                }
            }
        }
    }
});