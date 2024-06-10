let AdminApp = angular.module("AdminApp",[]);

AdminApp.controller('tableController', function($scope, $http) {

    $http.get("/admin/liste")
    .then(function(response) {
        $scope.admins = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.admin.idAdmin=0;
        $scope.admin.mail="";
        $scope.admin.motDePasse="";
        document.getElementById("password").value="";
    }

    $scope.modify = function(idAdmin){
        $http.get("/admin/information?idAdmin="+idAdmin)
        .then(function(response) {
            $scope.admin = response.data;
            const pwd=document.getElementById("password");
            pwd.value=$scope.admin.motDePasse;
            const submitButton=document.getElementById("buttonSubmit");
            submitButton.innerText="Modifier";
            document.getElementById("formulaire").setAttribute("ng-submit", "updateForm()");
            console.log($scope.admin);
        });
    }

    $scope.delete = function(idAdmin){
        $http.get("/admin/delete?idAdmin="+idAdmin)
        .then(function(response) {
            $scope.admins = response.data;
        });
    }

    $scope.submitForm = function() {
        var admin = {
            idAdmin: $scope.admin.idAdmin,
            mail: $scope.admin.mail,
            motDePasse: $scope.admin.motDePasse
        };
        console.log("Sending data:", JSON.stringify(admin)); // Afficher le JSON dans la console
        $http.post('/admin/insert', admin)
        .then(function(response) {
            $scope.admins = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.updateForm = function() {
        var admin = {
            idAdmin: $scope.admin.idAdmin,
            mail: $scope.admin.mail,
            motDePasse: $scope.admin.motDePasse
        };
        console.log("Sending data:", JSON.stringify(admin)); // Afficher le JSON dans la console
        $http.post('/admin/update/', admin)
        .then(function(response) {
            $scope.admins = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});