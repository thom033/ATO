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
<div class="container" style="margin-top:5%">
  <div class="row" ng-app="CompetenceUtilisateurApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <div class="container">
          <h5>Competence de l'utilisateur</h5>
          <hr>
        </div>
        <div class="row">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Competence</th>
                <th scope="col">Niveau</th>
                <th scope="col">Retirer</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="competence in utilisateur.competences">
                <td>{{competence.competence}}</td>
                <td>{{competence.description}}</td>
                <td><button class="btn btn-danger" ng-click="retirer(competence)">Retirer</button></td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="row">
          <div class="col-md-9"></div>
          <div class="col-md-3">
            <button class="btn btn-primary" ng-click="submitForm()">Valider</button>
          </div>
        </div>
      </div>
    </div>
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <div class="row">
          <div class="input-group">
            <input type="text" ng-model="recherche" class="input" style=" border-radius: 15px;">
            <label class="user-label">Recherche</label>
          </div>
        </div>
        <div class="row">
          <table class="table">
            <thead>
              <tr>
                <th scope="col">Competence</th>
                <th scope="col">Description</th>
                <th scope="col">Ajouter</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="competence in competences | filter: recherche">
                <td scope="row">{{competence.competence}}</td>
                <td>{{competence.description}}</td>
                <td><button class="btn btn-primary" ng-click="ajouter(competence)">Ajouter</button></td>
              </tr>
            </tbody>
          </table>
        </div>
    </div>
  </div>
</div>
<script src="../../../../public/js/crud/CompetenceUtilisateur.js"></script>