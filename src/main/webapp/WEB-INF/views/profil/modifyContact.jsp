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
  <div class="row" ng-app="ContactApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Contactistrateur</h5>
            <hr>
          </div>
          <div class="row mb-3">
            <div class="col-md-5">
              <div class="input-group">
                  <input required="" type="text" ng-model="contact.mail" auto complete="off" class="input" style=" border-radius: 15px;">
                  <label class="user-label">Numéro téléphone</label>
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
                <th scope="col">#</th>
                <th scope="col">Contact</th>
                <th scope="col">Modifier</th>
                <th scope="col">Renvoyer</th>
              </tr>
            </thead>
            <tbody>
              <tr ng-repeat="contact in contacts">
                <th scope="row">{{contact.idContact}}</th>
                <td>{{contact.numTelephone}}</td>
                <td><button class="btn btn-warning" ng-click="modify(contact.idContact)">Modifier</button></td>
                <td><button class="btn btn-danger" ng-click="delete(contact.idContact)">Renvoyer</button></td>
              </tr>
            </tbody>
          </table>
    </div>
  </div>
</div>
<script src="../../../../public/js/crud/Contact.js"></script>