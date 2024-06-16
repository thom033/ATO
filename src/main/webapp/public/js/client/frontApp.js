var frontApp = angular.module("frontApp",[]);

frontApp.controller('notificationController', function($scope, $http) {

    $scope.nom = "albert";

    $scope.getData = function() {
        let aurl = "/notification/liste";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.notifications = response.data;
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    $scope.delete = function(idNotif) {
        let delUrl = "/notification/delete/" + idNotif;
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


    $scope.tempsEcoule = function(dateNotification) {
        // Obtient la date et l'heure actuelles
        const curDate = new Date();
    
        // Calcule la durée écoulée en millisecondes
        const duration = curDate - new Date(dateNotification);
    
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
    };

    $scope.estDynamique = function(notification) {
        if (notification.poste != null) {
            return 0;
        } else if (notification.entretien != null) {
            return 1;
        }
        else if(notification.point) {
            return 2;
        }
        return -1;
    };

    $scope.interpreterUrl = function(notification) {
        let valiny = "";
        let url = $scope.estDynamique(notification);
        if (url == 2) {
            valiny = "/utilisateur/profil";
        } else if (url == 0 ) {
            valiny = "/utilisateur/inscription";
        } else if (url == 1) {
            valiny = "/generer-pdf/" + notification.entretien.id;
        }
        return valiny;
    }


    $scope.getData();

    $scope.formatDate = function (dateNotification) {
        let date = new Date(dateNotification);
        const formattedDate = date.toLocaleDateString('fr-FR');
        return formattedDate;
    }
});


frontApp.controller("faqController", function($scope, $http) {
    $scope.question = function(idQuestion) {
        let aurl = "/faq/question/" + idQuestion;
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            console.log("question posé avec succes")
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    $scope.getData = function() {
        let aurl = "/faq/historique";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.notifications = response.data;
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    $scope.delete = function(idNotif) {
        let delUrl = "/notification/delete/" + idNotif;
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
});