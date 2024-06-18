let UtilisateurApp = angular.module("UtilisateurApp",[]);

UtilisateurApp.controller('parametreController', function($scope, $http) {
    $scope.etatCivils=["Marié","Célibataire","Compliqué"];
    $http.get("/utilisateur/parametre/modify?idUtilisateur=1")
    .then(function(response) {
        $scope.utilisateur = response.data.utilisateur;
        console.log($scope.utilisateur);
    });

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/update', $scope.utilisateur)
        .then(function(response) {
            alert("Modification effectué");
        }, function(error) {
            console.log(error);
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});