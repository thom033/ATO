let ContactApp = angular.module("ContactApp",[]);

ContactApp.controller('tableController', function($scope, $http) {

    $http.get("/utilisateur/connected")
    .then(function(response) {
        $scope.utilisateur = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.contact.idContact=0;
        $scope.contact.contact="";
    }

    $scope.submitForm = function() {
        console.log("Sending data:", JSON.stringify($scope.utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/contact/update', $scope.utilisateur)
        .then(function(response) {
            console.log("Updated");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.ajouterNum=function(){
        newContact={}
        newContact.id=0;
        newContact.numTelephone="";
        $scope.utilisateur.contacts.push(newContact);
    }

    $scope.retirerContact=function(contact){
        $scope.utilisateur.contacts=$scope.utilisateur.contacts.filter(obj => obj !== contact);
    }
});