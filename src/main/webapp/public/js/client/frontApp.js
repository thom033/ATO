var frontApp = angular.module("frontApp",[]);

// frontApp.component('notification', {
//     template: `
//         <div>
//             <h1>{{ $ctrl.title }}</h1>
//             <p>{{ $ctrl.description }}</p>
//         </div>
//     `,
//     bindings: {
//         titler : '@'
//     }
//     ,
//     controller: function() {
//         // console.log(this.notif);
//         this.titler = notif;
//         this.description = 'This is a simple AngularJS component example.';
//     }
// })

// Define the component with bindings
frontApp.component('myComponent', {
    bindings: {
        title: '@',
        description: '@'
    },
    template: `
        <div>
            <h1>{{ $ctrl.title }}</h1>
            <p>{{ $ctrl.description }}</p>
        </div>
    `,
    controller: function() {
        // The controller can use $onInit for initialization
        this.$onInit = function() {
            // console.log('Component initialized with title:', this.title);
        };
    }
});

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

    $scope.getData = function() {
        let aurl = "/notification/liste";
        $http({
            url: aurl,
            method: 'GET'
        })
        .then(function(response) {
            $scope.notifications = response.data;
            // console.log($scope.notifications);
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
        }
        else if(notification.point) {
            return -1;
        }
        return -2
    };

    $scope.interpreterUrl = function(url) {
        let valiny = "";
        if (url == -1) {
            valiny = "/utilisateur/profil";
        } else if (url >= 0 ) {
            valiny = "/utilisateur/inscription";
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
