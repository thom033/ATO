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
<div class="container">
  <div class="row" ng-app="ContactApp" ng-controller="tableController">
    <div class="col-md-6">
      <div class="form">
        <form id="formulaire" ng-submit="submitForm()">
          <div class="container">
            <h5>Contact utilisateur</h5>
            <hr>
          </div>
          <div class="row mb-3" ng-repeat="contact in utilisateur.contacts">
            <div class="col-md-6">
              <div class="input-group">
                <input required="" type="text" ng-model="contact.numTelephone" auto complete="off" class="input" style=" border-radius: 15px;">
                <label class="user-label">Numéro téléphone</label>
              </div>
            </div>
            <div class="col-md-1"></div>
            <div class="col-md-5">
              <button class="btn btn-danger" type="button" ng-click="retirerContact(contact)">Retirer</button>
            </div>
          </div>
          <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-3">
              <button class="btn btn-primary" type="button" ng-click="ajouterNum()">Ajouter</button>
            </div>
          </div>
          <div class="row">
            <div class="container">
              <hr>
            </div>
          </div>
          <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-3">
              <button id="buttonSubmit" class="btn btn-primary">Valider</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script src="../../../public/js/crud/Contact.js"></script>