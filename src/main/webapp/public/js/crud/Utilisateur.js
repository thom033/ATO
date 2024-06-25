let UtilisateurApp = angular.module("UtilisateurApp",[]);

UtilisateurApp.controller('parametreController', function($scope, $http) {
    $scope.etatCivils=["Marié","Célibataire","Compliqué"];
    $http.get("/utilisateur/parametre/modify?idUtilisateur=1")
    .then(function(response) {
        $scope.utilisateur = response.data.utilisateur;
        $scope.initMap();
        console.log($scope.utilisateur);
    });

    $scope.updateForm = function() {
        $scope.utilisateur.longitude=parseFloat(document.getElementById("longitude").value);
        $scope.utilisateur.latitude=parseFloat(document.getElementById("latitude").value);
        console.log("Sending data:", JSON.stringify($scope.utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/update', $scope.utilisateur)
        .then(function(response) {
            alert("Modification effectué");
        }, function(error) {
            console.log(error);
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
    $scope.initMap=function(){
        // Initialiser la carte et la centrer sur Antananarivo
        var map = L.map('map').setView([$scope.utilisateur.latitude, $scope.utilisateur.longitude], 13);
        // Ajouter une couche de tuiles OpenStreetMap
        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="">OpenStreetMap</a> contributors'
        }).addTo(map);
        // Ajouter un événement de clic pour obtenir les coordonnées
        map.on('click', function(e) {
            var lat = e.latlng.lat;
            var lng = e.latlng.lng;
            marker.remove();
            marker = L.marker([lat,lng], { icon: customIcon }).addTo(map);
            const longitude=document.getElementById("longitude");
            const lattitude=document.getElementById("latitude");
            const labelLatitude=document.getElementById("labelLatitude");
            const labelLongitude=document.getElementById("labelLongitude");
            labelLatitude.style.color="#82b6fb";
            labelLatitude.style.backgroundColor="#ffffff";
            labelLongitude.style.backgroundColor="#ffffff";
            labelLongitude.style.color="#82b6fb";
            labelLatitude.style.transform="translateY(-0.5rem) translateX(1rem)";
            labelLongitude.style.transform="translateY(-0.5rem) translateX(1rem)";
            longitude.style.border="1.5px solid #82b6fb";
            lattitude.style.border="1.5px solid #82b6fb";
            $scope.utilisateur.longitude=lng;
            $scope.utilisateur.latitude=lat;
            console.log(lattitude.value);
        });
        // Définir une icône personnalisée
        var customIcon = L.icon({
            iconUrl: '/public/leaflet/images/marker-icon.png', // Chemin vers votre image personnalisée
            iconSize: [38, 38], // Taille de l'icône
            iconAnchor: [19, 38], // Point de l'icône correspondant à la position du marqueur
            popupAnchor: [0, -38] // Point où la bulle d'information est ancrée
        });
        //Latitude = -18.910590046209464, Longitude = 47.527537567541174
        var marker = L.marker([$scope.utilisateur.latitude, $scope.utilisateur.longitude], { icon: customIcon }).addTo(map);
        function showMap(){
            const div=document.getElementById("map");
        }
    }
});