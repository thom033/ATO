<link rel="stylesheet" href="/public/leaflet/leaflet.css" />
<link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
<link rel="stylesheet" href="/public/bootstrap/css/input.css">
<style>
    .form{
        height: auto;
        width: auto;
        overflow: hidden;
        border-radius: 5%;
        background-color: white;
        box-shadow: rgba(71, 70, 70, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    }
    .form-body{
        padding: 5%;
        width: 1000%;
        display: flex;
        flex-direction: row;
    }
    .form-parts{
        margin-right: 5%;
        width: 9%;
    }
    #map {
        height: 75vh; /* Vous pouvez ajuster la hauteur selon vos besoins */
        width: 100%;
    }
</style>
<!-- Modal -->
<div class="modal fade mt-3" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Localisation</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div id="map"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Valider</button>
            </div>
        </div>
    </div>
</div>
<div class="container" style="font-family:Helvetica;display: flex;justify-content: center;margin-top: 5%;">
    <div class="row">
        <div class="col-md-5">
            <div class="row">
                <button type="button" id="button-prev" onclick="next(0)" class="button">Information personnelles</button>
            </div>
            <div class="row">
                <button type="button" id="button-prev" onclick="next(1)" class="button">Joignabilité</button>
            </div>
            <div class="row">
                <button type="button" id="button-prev" onclick="next(2)" class="button">Proffessionalité</button>
            </div>
            <div class="row">
                <button type="button" id="button-next" onclick="next(3)" class="button">Confidentialité</button>
            </div>
        </div>
        <div class="col-md-7">
            <form action="#" method="post">
                <div class="form">
                    <div class="container"><h5>Paramètres</h5><hr></div>
                    <div id="form-body" class="form-body container-fluid">
                        <div class="form-parts">
                            <div class="row">
                                <h6>Information Personnelles</h6><hr>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-5">
                                    <div class="input-group">
                                        <input required="" type="text" name="nom" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Nom</label>
                                    </div>
                                </div>
                                <div class="col-md-1"></div>
                                <div class="col-md-5">
                                    <div class="input-group">
                                        <input required="" type="text" name="prenom" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Prenom</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-5">
                                    <div class="input-group">
                                        <input required="" type="date" name="dateNaissance" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Date de naissance</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="input-group">
                                    <span class="input-group-text">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-text" viewBox="0 0 16 16">
                                            <path d="M5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5M5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1z"/>
                                            <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1"/>
                                        </svg>
                                    </span>
                                    <select class="form-select" name="etatCivile" id="etatCivile" style="width: 10%;">
                                        <option value="">Etat Civile</option>
                                        <option value="Marié">Marié</option>
                                        <option value="Celibataire">Celibataire</option>
                                        <option value="Compliqué">Compliqué</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-parts">
                            <div class="row">
                                <h6>Joignabilité</h6><hr>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <input required="" type="text" name="adresse" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Adresse</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <input disabled required="" id="latitude" type="number" name="latitude" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label id="labelLatitude" class="user-label">latitude</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="input-group">
                                        <input disabled required="" id="longitude" type="number" name="longitude" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label id="labelLongitude" class="user-label">longitude</label>
                                    </div>
                                </div>
                                <div class="col-md-2">
                                    <div class="col-md-3">
                                        <button  type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" class="button">Localisation</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-parts">
                            <div class="row">
                                <h6>Proffessionalité</h6><hr>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-4">
                                    <a href="/utilisateur/diplome" class="btn btn-primary">Diplome</a>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="input-group">
                                    <input required="" type="number" name="adresse" autocomplete="off" class="input" style=" border-radius: 15px;">
                                    <label class="user-label">Salaire recherché</label>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6 mb-3">
                                    <div class="input-group">
                                        <span class="input-group-text">Description</span>
                                        <textarea class="form-control" name="description" aria-label="With textarea"></textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-parts">
                            <div class="row">
                                <h6>Confidentialité</h6><hr>
                            </div>
                            <div class="row mb-3">
                                <div class="row">
                                    <div class="col-md-4">
                                        <div class="input-group">
                                            <input required="" type="text" name="adresse" autocomplete="off" class="input" style=" border-radius: 15px;">
                                            <label class="user-label">Numéro téléphone</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <div class="col-md-4"><button class="btn btn-primary">Ajouter Contact</button></div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input required="" type="email" name="mail" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Email</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input required="" type="password" name="pwd1" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Mot de passe</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <input required="" type="password" name="pwd2" autocomplete="off" class="input" style=" border-radius: 15px;">
                                        <label class="user-label">Confirmer votre mot de passe</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-9"></div>
                                <div class="col-md-3"><button class="btn btn-primary">Valider</button></div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row" style="margin-left: 15%;">
            
    </div>
</div>
<script src="/public/bootstrap/css/bootstrap.min.css"></script>
<script src="/public/js/bs-init.js"></script>
<script src="/public/js/bold-and-bright.js"></script>
<script>
    const buttonNext=document.getElementById("button-next");
    const formulaire=document.getElementById("form-body");
    function next(number){
        let percent=13.75*(number);
        formulaire.style.transition="transform 0.8s cubic-bezier(0.25, 0.1, 0, 1.32) 0s";
        formulaire.style.transform="translateX(-"+percent+"%)";
    }
</script>
<script src="/public/leaflet/leaflet.js"></script>
<script>
    // Initialiser la carte et la centrer sur Antananarivo
    var map = L.map('map').setView([-18.8792, 47.5079], 13);
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
        longitude.value=lng;
        lattitude.value=lat;
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
    var marker = L.marker([-18.910590046209464, 47.527537567541174], { icon: customIcon }).addTo(map);
    function showMap(){
        const div=document.getElementById("map");
    }
</script>