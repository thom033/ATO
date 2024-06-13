<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../../../public/bootstrap/css/input.css">
<link rel="stylesheet" href="../../../../public/bootstrap/css/stylesRecherche.css">
<link rel="stylesheet" href="../../../../public/leaflet/leaflet.css">
<style>
  .form{
    border-radius: 5%;
    background-color: white;
    overflow: hidden;
    box-shadow: rgba(71, 70, 70, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    height: auto;
    width: auto;
    padding: 5%
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
<script src="../../../../../public/js/angular.min.js"></script>
  <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Localisation</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body" style="overflow: hidden">
                    <div id="map"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Valider</button>
                </div>
            </div>
        </div>
    </div>
<div class="container">
  <div class="row" ng-app="EntrepriseApp" ng-controller="tableController">
    <div class="col-md-5">
      <form id="formulaire" ng-submit="submitForm()">
        <div class="form">  
          <div class="container">
            <h5>Entreprise</h5>
            <hr>
          </div>
          <div id="form-body" class="form-body">
            <div class="form-parts">
              <div class="row mb-3">
                <div class="col-md-6">
                  <div class="input-group">
                    <input required="" type="text" ng-model="entreprise.entreprise" autocomplete="off" class="input" style=" border-radius: 15px;">
                    <label class="user-label">Nom de l'entreprise</label>
                  </div>
                </div>
                <div class="col-md-1"></div>
              </div>
              <div class="row mb-3">
                <div class="col-md-5">
                  <div class="input-group">
                      <input required="" type="text" ng-model="entreprise.type" name="type" autocomplete="off" class="input" style=" border-radius: 15px;">
                      <label class="user-label">Type</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-5">
                  <div class="input-group">
                      <input required="" type="email" ng-model="entreprise.mail" autocomplete="off" class="input" style=" border-radius: 15px;">
                      <label class="user-label">Mail</label>
                  </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-5">
                  <div class="input-group">
                      <input required="" id="dateCreation" type="date" ng-model="entreprise.dateCreation" autocomplete="off" class="input" style=" border-radius: 15px;" value="2020-10-10">
                      <label class="user-label">Date de creation</label>
                  </div>
                </div>
              </div>
            </div>
            <div class="form-parts">
              <div class="row mb-3">
                <div class="col-md-4">
                    <div class="input-group">
                        <input required="" type="text" ng-model="entreprise.adresse" autocomplete="off" class="input" style=" border-radius: 15px;">
                        <label class="user-label">Adresse</label>
                    </div>
                </div>
              </div>
              <div class="row mb-3">
                <div class="col-md-4">
                    <div class="input-group">
                        <input required="" type="text" ng-model="entreprise.siteWeb" autocomplete="off" class="input" style=" border-radius: 15px;">
                        <label class="user-label">Site web</label>
                    </div>
                </div>
              </div>
              <div class="row">
                <div class="col-md-8">
                  <div class="row mb-3">
                    <div class="input-group">
                      <input required disabled id="latitude" type="text" ng-model="entreprise.latitude" autocomplete="off" class="input" style=" border-radius: 15px;">
                      <label id="labelLatitude" class="user-label">latitude</label>
                    </div>
                  </div>
                  <div class="row mb-3">
                    <div class="input-group">
                      <input required disabled id="longitude" type="text" ng-model="entreprise.longitude" autocomplete="off" class="input" style=" border-radius: 15px;">
                      <label id="labelLongitude" class="user-label">longitude</label>
                    </div>
                  </div>
                </div>
                <div class="col-md-3">
                    <div class="col-md-3">
                        <button  type="button" data-bs-toggle="modal" data-bs-target="#exampleModal" class="button">Localisation</button>
                    </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-3 mb-3">
                <button type="button" id="button-prev" onclick="prev()" class="button">Précédent</button>
            </div>
            <div class="col-md-4"></div>
            <div class="col-md-3 mb-3">
                <button type="button" id="button-next" onclick="next()" class="button">Suivant</button>
            </div>
          </div>
        </div>
      </form>
    </div>
    <div class="col-md-7">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Entreprise</th>
                <th scope="col">Date de creation</th>
                <th scope="col">Site Web</th>
                <th scope="col">Voir plus/Modifier</th>
                <th scope="col">Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="entreprise in entreprises">
                <th scope="row">{{entreprise.id}}</th>
                <td>{{entreprise.entreprise}}</td>
                <td>{{entreprise.dateCreation.split('T')[0]}}</td>
                <td>{{entreprise.siteWeb}}</td>
                <td><button class="btn btn-warning" ng-click="modify(entreprise.id)">Modifier</button></td>
                <td><button class="btn btn-danger" ng-click="delete(entreprise.id)">Supprimer</button></td>
              </tr>
            </tbody>
          </table>
    </div>
  </div>
</div>
<script src="../../../../public/leaflet/leaflet.js"></script>
<script src="../../../../public/js/crud/Entreprise.js"></script>