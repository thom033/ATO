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
            valiny = "/poste/details/show?idPoste=" + notification.poste.idPoste;
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


frontApp.controller("faqController", function($scope, $http, $location, $anchorScroll) {
    $scope.poserQuestion = function(idQuestion) {
        let aurl = "/faq/question/" + idQuestion;
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.getData();
            console.log("question posé avec succes");

            setTimeout(function() {
                // Définir l'ancre à l'ID de la nouvelle question
                $location.hash('question-' + response.data.retour);
                // Faire défiler vers l'ancre
                $anchorScroll();
            }, 0);

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
            $scope.historiqueQuestions = response.data;
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    $scope.getQuestion = function() {
        let aurl = "/question/get";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.questions = response.data;
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

    $scope.getData();
    $scope.getQuestion();
});

frontApp.controller("postulationController", function($scope, $http) {
    $scope.postuler = function(idPoste) {
        let aurl = "/postuler/" + idPoste;
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


frontApp.controller("entretienController", function($scope, $http) {
    $scope.getData = function() {
        let aurl = "/admin/entretien/encours";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.entretiens = response.data;
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    };

    $scope.delete = function(idEntretien) {
        let delUrl = "/admin/entretien/delete/" + idEntretien;
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

    $scope.valider = function(idEntretien) {
        let delUrl = "/admin/entretien/valider/" + idEntretien;
        $http({
            url: delUrl,
            method: 'GET'
        })
        .then(function(response) {
            console.log("valider avec succes");
            $scope.getData();
        }, function(error) {
            console.error('Erreur lors de la récupération des données:', error);
        });
    
    };

    $scope.postuler = function(idPoste) {
        let aurl = "/postuler/" + idPoste;
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

    $scope.formatDate = function (dateNotification) {
        let date = new Date(dateNotification);
        const formattedDate = date.toLocaleDateString('fr-FR');
        return formattedDate;
    }

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


    $scope.getData();

});