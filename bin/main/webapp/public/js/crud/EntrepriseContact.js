let EntrepriseContactApp = angular.module("EntrepriseContactApp",[]);

EntrepriseContactApp.controller('tableController', function($scope, $http) {

    $http.get("/entreprise/choosed")
    .then(function(response) {
        $scope.entreprise = response.data;
        console.log($scope);
    });

    $scope.submitForm = function() {
        console.log("Sending data:", JSON.stringify($scope.entreprise)); // Afficher le JSON dans la console
        $http.post('/entreprise/contact/update', $scope.entreprise)
        .then(function(response) {
            alert("Modification effectué")
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.ajouterNum=function(){
        newContact={}
        newContact.id=0;
        newContact.numTelephone="";
        $scope.entreprise.contacts.push(newContact);
    }

    $scope.retirerContact=function(contact){
        $scope.entreprise.contacts=$scope.entreprise.contacts.filter(obj => obj !== contact);
    }
});