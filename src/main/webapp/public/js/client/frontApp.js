var frontApp = angular.module("frontApp",[]);

frontApp.controller('notificationController', function($scope, $http) {

    $scope.nom = "albert";

    // $scope.submitForm = function () {
    //     console.log("Championnat")
    //     console.log($scope.championnat)
    //     $http({
    //         url: 'championnat-controller',
    //         method: 'POST',
    //         data: $scope.championnat,
    //         headers: { 'Content-Type': 'application/x-www-form-urlencoded'},
    //         transformRequest: function(obj) {
    //             var str = [];
    //             for (var p in obj)
    //                 str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
    //             return str.join("&");
    //         }
    //     })
    //         .then(function(response) {
    //             $scope.submitted = true;
    //             $scope.tableData = response.data;
    //         }, function(error) {
    //             console.error('Erreur lors de l\'envoi des données', error);
    //         });
    // };

    $scope.delete = function(idNotif) {
        let delUrl = "/notification/delete/" + idNotif;
        $http({
            url: delUrl,
            method: 'GET'
        })
            .then(function(response) {
                $scope.tableData = response.data;
                console.log(response.data);
            }, function(error) {
                console.error('Erreur lors de la récupération des données:', error);
            });

        $http({
            url: 'categorie-controller',
            method: 'GET'
        })
            .then(function(response) {
                $scope.categories = response.data;
                console.log(response.data);
            }, function(error) {
                console.error('Erreur lors de la récupération des données:', error);
            });
    };

    $scope.getData = function() {
        let aurl = "/notification/liste";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.notifications = response.data.notifications;
            console.log($scope.notifications);
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    function tempsEcoule(dateNotification) {
        // Obtient la date et l'heure actuelles
        const curDate = new Date();
    
        // Calcule la durée écoulée en millisecondes
        const duration = curDate - dateNotification;
    
        // Convertit la durée en secondes
        const seconds = Math.floor(duration / 1000);
        // Détermine le nombre de minutes, d'heures, de jours, etc., en fonction de la durée
        const minutes = Math.floor(seconds / 60);
        const hours = Math.floor(minutes / 60);
        const days = Math.floor(hours / 24);
    
        // Gère les cas spéciaux pour les messages
        let message = " il y a ";
        if (days > 0) {
            message += days + " jours";
        } else if (hours > 0) {
            message += hours + " heures";
        } else if (minutes > 0) {
            message += minutes + " minutes";
        } else {
            message = "juste maintenant";
        }
    
        // Affiche le message
        return message;
    }

    function estDynamique(notification) {
        if (notification.poste != null) {
            return 0;
        }
        else if(notification.point) {
            return -1;
        }
        return -2
    }


    $scope.getData();
    console.log("Nicolas");
});
