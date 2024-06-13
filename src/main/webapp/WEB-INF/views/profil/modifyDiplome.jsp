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
<div class="container">
  <div class="row" ng-app="DiplomeUtilisateurApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Diplome de l'utilisateur</h5>
            <hr>
          </div>
          <div class="row mb-3">
            <div class="col-md-5">
              <div class="input-group">
                  <span class="input-group-text">
                      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-text" viewBox="0 0 16 16">
                          <path d="M5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5M5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1z"/>
                          <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1"/>
                      </svg>
                  </span>
                  <select class="form-select" ng-model="diplomeUtilsateur.diplome.diplome" style="width: 10%;">
                      <option ng-repeat="diplomeExist in diplomeExists" value="{{diplomeExist.diplome}}"
                       ng-selected="diplomeExist.diplome == diplomeUtilsateur.diplome.diplome">{{diplomeExist.diplome}}</option>
                  </select>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-5">
              <div class="input-group">
                  <span class="input-group-text">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-text" viewBox="0 0 16 16">
                        <path d="M5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5M5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1z"/>
                        <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1"/>
                    </svg>
                  </span>
                  <select class="form-select" ng-model="diplomeUtilsateur.diplome.niveau" style="width: 10%;">
                      <option value="1">Licence</option>
                      <option value="2">Master</option>
                      <option value="3">Doctorat</option>
                  </select>
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
        <table class="table">
            <thead>
              <tr>
                <th scope="col">Diplome</th>
                <th scope="col">Niveau</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="diplomeUtilisateur in diplomeUtilisateurs">
                <td scope="row">{{diplomeUtilisateur.diplome.diplome}}</td>
                <td>{{diplomeUtilisateur.diplome.niveau}}</td>
                <td><button class="btn btn-warning" ng-click="modify({{diplomeUtilisateur.diplome.id}},{{diplomeUtilisateur.utilisateur.id}})">Modifier</button></td>
                <td><button class="btn btn-danger" ng-click="delete({{diplomeUtilisateur.diplome.id}},{{diplomeUtilisateur.utilisateur.id}})">Supprimer</button></td>
              </tr>
            </tbody>
          </table>
    </div>
  </div>
</div>
<script src="../../../../public/js/crud/DiplomeUtilisateur.js"></script>