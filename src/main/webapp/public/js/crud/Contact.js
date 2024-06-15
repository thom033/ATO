let ContactApp = angular.module("ContactApp",[]);

ContactApp.controller('tableController', function($scope, $http) {

    $http.get("/contact/liste")
    .then(function(response) {
        $scope.contacts = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.contact.idContact=0;
        $scope.contact.contact="";

    }

    $scope.modify = function(idContact){
        $http.get("/contact/information?idContact="+idContact)
        .then(function(response) {
            $scope.contact = response.data;
            const submitButton=document.getElementById("buttonSubmit");
            submitButton.innerText="Modifier";
            document.getElementById("formulaire").setAttribute("ng-submit", "updateForm()");
            console.log($scope.contact);
        });
    }

    $scope.delete = function(idContact){
        $http.get("/contact/delete?idContact="+idContact)
        .then(function(response) {
            $scope.contacts = response.data;
        });
    }

    $scope.submitForm = function() {
        console.log("Sending data:", JSON.stringify($scope.contact)); // Afficher le JSON dans la console
        $http.post('/contact/insert', $scope.contact)
        .then(function(response) {
            $scope.contacts = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.contact)); // Afficher le JSON dans la console
        $http.post('/contact/update/', $scope.contact)
        .then(function(response) {
            $scope.contacts = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});