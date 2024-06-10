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
  <div class="row" ng-app="ReponseApp" ng-controller="tableController">
    <div class="col-md-5">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Question/Reponse</h5>
            <hr>
          </div>
          <div class="row mb-3">
            <div class="col-md-12">
              <div class="input-group">
                <span class="input-group-text">Question</span>
                <textarea ng-model="reponse.question.question" class="form-control" aria-label="With textarea"></textarea>
              </div>
            </div>
          </div>
          <div class="row mb-3">
            <div class="col-md-12">
              <div class="input-group">
                <span class="input-group-text">Reponse</span>
                <textarea ng-model="reponse.reponse" class="form-control" aria-label="With textarea"></textarea>
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
    <div class="col-md-7">
        <table class="table">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Question</th>
                <th scope="col">Reponse</th>
                <th scope="col">Modifier</th>
                <th scope="col">Supprimer</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="reponse in reponses">
                <th scope="row">{{reponse.idReponse}}</th>
                <td>{{reponse.question.question}}</td>
                <td>{{reponse.reponse}}</td>
                <td><button class="btn btn-warning" ng-click="modify(reponse.idReponse)">Modifier</button></td>
                <td><button class="btn btn-danger" ng-click="delete(reponse.idReponse)">Renvoyer</button></td>
              </tr>
            </tbody>
          </table>
    </div>
  </div>
</div>
<script src="../../../../public/js/crud/Reponse.js"></script>