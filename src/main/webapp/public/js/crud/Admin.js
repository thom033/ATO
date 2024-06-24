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

AdminApp.controller("crudPostulationController", function($scope, $http) {
    $scope.postulation = {
        date: null
    }

    $scope.getData = function() {
        let aurl = "/postulation/liste";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.postulations = response.data;
            console.log($scope.postulations);

        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
        
    };

    $scope.delete = function(idPostulation) {
        let delUrl = "/admin/delete/postulation/" + idPostulation ;
        $http({
            url: delUrl,
            method: 'GET'
        })
        .then(function(response) {
            console.log("supprimé avec succes");
            $scope.getData();
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });

    };

    // $scope.valider = function(idPostulation) {
    //     console.log($scope.postulation.date);
    //     let delUrl = "/admin/valider/postulation/" + idPostulation;
    //     console.log($scope.postulation);
    //     $http({
    //         url: delUrl,
    //         method: 'GET',
    //         data: $scope.postulation
    //     })
    //     .then(function(response) {
    //         console.log("supprimé avec succes");
    //         // $scope.getData();
    //     }, function(error) {
    //         console.error('Erreur lors de la récupération des données:', error);
    //     });

    // };

    $scope.submitDate = function($scope, $http, idPostulation) {
        var dateTime = $scope.datetime;
        var dateOnly = dateTime.toISOString().split('T')[0];
        var dateData = {
            date: dateOnly
        }
        
        let delUrl = "/admin/valider/postulation/" + idPostulation;
        $http.post(idPostulation, dateData)
        .then(function(response) {
            console.log("DateEnvoyé");
        }, function(error) {

        });
    };

    $scope.getData();
    $scope.formatDate = function (dateNotification) {
        let date = new Date(dateNotification);
        const formattedDate = date.toLocaleDateString('fr-FR');
        return formattedDate;
    }
});

AdminApp.controller("posteController", function($scope, $http) {
    $scope.supprimer = function(idPoste) {
        let aurl = "/admin/supprimer/" + idPoste;
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            message = "Postulation effectue avec succes";
            Swal.fire({
                title: 'Succes postulation',
                text: message,
                icon: 'success',
                confirmButtonText: 'OK'
            });
        }, function(error) {
            message = "Vous n'avez pas assez de point";
            Swal.fire({
                title: 'Problème lors de la postulation',
                text: message,
                icon: 'error',
                confirmButtonText: 'OK'
            });
        });
        
    };

});