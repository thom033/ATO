let UtilisateurApp = angular.module("UtilisateurApp",[]);

UtilisateurApp.controller('parametreController', function($scope, $http) {
    $scope.etatCivils=["Marié","Célibataire","Compliqué"];
    $http.get("/utilisateur/parametre/modify?idUtilisateur=1")
    .then(function(response) {
        $scope.utilisateur = response.data.utilisateur;
        console.log($scope.utilisateur);
    });

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify(utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/update/', $scope.utilisateur)
        .then(function(response) {
            $scope.utilisateurs = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});