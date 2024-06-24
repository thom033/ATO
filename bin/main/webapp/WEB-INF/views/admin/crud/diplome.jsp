<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="../../../../public/bootstrap/css/input.css">
<link rel="stylesheet" href="../../../../public/bootstrap/css/stylesRecherche.css">
<style>
  .form{
    border-radius: 5%;
    background-color: white;
    box-shadow: rgba(71, 70, 70, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    height: auto;
    width: auto;
    padding: 5%
  }
</style>
<script src="../../../../../public/js/angular.min.js"></script>
<div class="container" style="margin-top: 5%;">
  <div class="row" ng-app="DiplomeApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Diplome</h5>
            <hr>
          </div>
          <div class="row mb-3">
            <div class="col-md-6">
                <div class="input-group">
                    <input type="text" ng-model="diplome.diplome" autocomplete="off" class="input" style=" border-radius: 15px;">
                    <label class="user-label">Diplome</label>
                </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-6">
                <p>Secteur</p>
                <div class="input-group">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                            <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4z"/>
                        </svg>
                    </span>
                    <select class="form-select" ng-options="secteur as secteur.secteur for secteur in secteurs" name="secteur" id="secteur" ng-model="diplome.secteur" class="input" autocomplete="off">
                    </select>
                </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-6">
              <div class="input-group">
                    <span class="input-group-text">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                            <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4z"/>
                        </svg>
                    </span>
                    <select class="form-select" name="secteur" id="secteur" ng-model="diplome.niveau" class="input" autocomplete="off">
                        <option value="1" class="option">Bacalauréat</option>
                        <option value="2" class="option">Licence</option>
                        <option value="3" class="option">Master</option>
                        <option value="4" class="option">Doctorat</option>
                    </select>
                </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-3">
              <button id="buttonSubmit" onclick="checkValueBtn()" class="btn btn-primary">Ajouter</button>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-5">
      <div class="row mb-3">
        <div class="col-md-5">
          <div class="input-group">
            <input type="text" ng-model="recherche" autocomplete="off" class="input" style=" border-radius: 15px;">
            <label class="user-label">Recherche</label>
          </div>
        </div>
      </div>
      <div class="row">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Diplome</th>
              <th scope="col">Modifier</th>
              <th scope="col">Renvoyer</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="diplome in diplomes | filter: recherche">
              <th scope="row">{{diplome.id}}</th>
              <td>{{diplome.diplome}}</td>
              <td><button class="btn btn-warning" onclick="checkValueBtn()" ng-click="modify(diplome.id)">Modifier</button></td>
              <td><button class="btn btn-danger" ng-click="delete(diplome.id)">Supprimer</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script src="../../../../public/js/crud/Diplome.js"></script>
<script src="/public/js/input.js"></script>