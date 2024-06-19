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
  <div class="row" ng-app="ExperienceApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Experience utilisateur</h5>
            <hr>
          </div>
          <div class="row mb-3">
            <p>Secteur</p>
            <div class="col-md-5">
                <select class="form-select" aria-label="Default select example" ng-model="experience.secteur">
                    <option ng-repeat="secteur in secteurs" ng-value="{{secteur}}" ng-selected="secteur.secteur==experience.secteur">{{secteur.secteur}}</option>
                </select>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-5">
              <div class="input-group">
                  <input required="" value="{{experience.dateDebut.split('T')[0]}}" type="date" id="dateDebut" auto complete="off" class="input" style=" border-radius: 15px;">
                  <label class="user-label">Début</label>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-5">
              <div class="input-group">
                  <input value="{{experience.dateFin.split('T')[0]}}" type="date" id="dateFin" autocomplete="off" class="input" style=" border-radius: 15px;">
                  <label class="user-label">Fin</label>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-9">
                <div class="input-group">
                    <span class="input-group-text">Description</span>
                    <textarea class="form-control" ng-model="experience.description" aria-label="With textarea"></textarea>
                </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-3">
              <button id="buttonSubmit" class="btn btn-primary">Ajouter</button>
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
              <th scope="col">Secteur</th>
              <th scope="col">Début</th>
              <th scope="col">Modifier</th>
              <th scope="col">Supprimer</th>
            </tr>
          </thead>
          <tbody>
            <tr ng-repeat="experience in experiences | filter: recherche">
              <td>{{experience.secteur.secteur}}</td>
              <td>{{experience.dateDebut.toISOString().split('T')[0]}}</td>
              <td><button class="btn btn-warning" ng-click="modify(experience.id)">Modifier</button></td>
              <td><button class="btn btn-danger" ng-click="delete(experience.id)">Supprimer</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<script src="/public/js/crud/Experience.js"></script>
<script src="/public/js/input.js"></script>