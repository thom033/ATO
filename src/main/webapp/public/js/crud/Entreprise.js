let EntrepriseApp = angular.module("EntrepriseApp",[]);

var buttonText="Ajouter";

EntrepriseApp.controller('tableController', function($scope, $http) {
    $scope.entreprise={}

    $http.get("/entreprise/liste")
    .then(function(response) {
        $scope.entreprises = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        buttonText="Ajouter"
        $scope.entreprise.idEntreprise=0;
        $scope.entreprise.mail="";
        $scope.entreprise.entreprise="";
        $scope.entreprise.point="";
        $scope.entreprise.type="";
        $scope.entreprise.dateCreation="";
        $scope.entreprise.adresse="";
        $scope.entreprise.siteWeb="";
        $scope.entreprise.latitude="";
        $scope.entreprise.longitude="";
        const longitude=document.getElementById("longitude");
        const lattitude=document.getElementById("latitude");
        const labelLatitude=document.getElementById("labelLatitude");
        const labelLongitude=document.getElementById("labelLongitude");
        labelLatitude.style.color="#000";
        labelLatitude.style.backgroundColor="#fff";
        labelLongitude.style.backgroundColor="#fff";
        labelLongitude.style.color="#000";
        labelLatitude.style.transform="";
        labelLongitude.style.transform="";
        longitude.style.border="";
        lattitude.style.border="";
    }

    $scope.modify = function(idEntreprise){
        $http.get("/entreprise/information?idEntreprise="+idEntreprise)
        .then(function(response) {
            $scope.entreprise = response.data;
            document.getElementById("formulaire").setAttribute("ng-submit", "updateForm()");
            console.log($scope.entreprise.dateCreation);
            const dateInput=document.getElementById("dateCreation");
            const dateOnly = $scope.entreprise.dateCreation.split('T')[0]; // Extraire la partie date
            dateInput.value = dateOnly;
            buttonText="Modifier";
        });
        

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
    }

    $scope.delete = function(idEntreprise){
        $http.get("/entreprise/delete?idEntreprise="+idEntreprise)
        .then(function(response) {
            $scope.entreprises = response.data;
        });
    }

    $scope.submitForm = function() {
        if(buttonNext.innerText=="Modifier"){
            $scope.updateForm();
        }
        else{
            $scope.insertForm();
        }
    };

    $scope.insertForm=function(){
        var newEntreprise = {
            idEntreprise: $scope.entreprise.idEntreprise,
            entreprise: $scope.entreprise.entreprise,
            mail:$scope.entreprise.mail,
            type: $scope.entreprise.type,
            dateCreation: document.getElementById("dateCreation").value,
            adresse: $scope.entreprise.adresse,
            siteWeb: $scope.entreprise.siteWeb,
            latitude: $scope.entreprise.latitude,
            image: "",
            longitude: $scope.entreprise.longitude
        };
        console.log("Sending data:", JSON.stringify(newEntreprise)); // Afficher le JSON dans la console
        $http.post('/entreprise/insert', newEntreprise)
        .then(function(response) {
            $scope.entreprises = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

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
    longitude.value=lng;
    lattitude.value=lat;
    $scope.entreprise.latitude=lat;
    $scope.entreprise.longitude=lng;
});

    $scope.updateForm = function() {
        var entreprise = {
            id: $scope.entreprise.id,
            entreprise: $scope.entreprise.entreprise,
            type: $scope.entreprise.type,
            mail: $scope.entreprise.mail,
            dateCreation: document.getElementById("dateCreation").value,
            adresse: $scope.entreprise.adresse,
            siteWeb: $scope.entreprise.siteWeb,
            latitude: $scope.entreprise.latitude,
            longitude: $scope.entreprise.longitude
        };
        console.log("Sending data:", JSON.stringify(entreprise)); // Afficher le JSON dans la console
        $http.post('/entreprise/update', entreprise)
        .then(function(response) {
            $scope.entreprises = response.data;
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };
});


// Initialiser la carte et la centrer sur Antananarivo
var map = L.map('map').setView([-18.8792, 47.5079], 13);

// Ajouter une couche de tuiles OpenStreetMap
L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="">OpenStreetMap</a> contributors'
}).addTo(map);

// Définir une icône personnalisée
var customIcon = L.icon({
    iconUrl: '../../../../public/leaflet/images/marker-icon.png', // Chemin vers votre image personnalisée
    iconSize: [38, 38], // Taille de l'icône
    iconAnchor: [19, 38], // Point de l'icône correspondant à la position du marqueur
    popupAnchor: [0, -38] // Point où la bulle d'information est ancrée
});

//Latitude = -18.910590046209464, Longitude = 47.527537567541174
var marker = L.marker([-18.910590046209464, 47.527537567541174], { icon: customIcon }).addTo(map);

function showMap(){
    const div=document.getElementById("map");
}


const buttonNext=document.getElementById("button-next");
const formulaire=document.getElementById("form-body");
var number=0;
function next(){
    console.log(number)
    if(number==0){
        buttonNext.type="button";
        buttonNext.innerText="Suivant";
        buttonNext.setAttribute("onclick", "next()");
        number++;
    }
    let percent=13.75*(number);
    formulaire.style.transition="transform 0.8s cubic-bezier(0.25, 0.1, 0, 1.32) 0s";
    formulaire.style.transform="translateX(-"+percent+"%)";
    if(number==1){
        buttonNext.innerText=buttonText;
        buttonNext.setAttribute("onclick", "");
        setTimeout(() => {
            buttonNext.type="submit";
        }, 500);
    }
}
function prev(){
    if(number!=0){
        number--;
        buttonNext.type="button";
        buttonNext.innerText="Suivant";
        buttonNext.setAttribute("onclick", "next()");
    }
    let percent=13.75*(number);
    formulaire.style.transition="transform 0.8s cubic-bezier(0.25, 0.1, 0, 1.32) 0s";
    formulaire.style.transform="translateX(-"+percent+"%)";
}