<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
<link rel="stylesheet" href="/public/bootstrap/css/input.css">
<style>
    .form{
        height: auto;
        width: 190%;
        padding: 5%;
        overflow: hidden;
        border-radius: 5%;
        background-color: white;
        box-shadow: rgba(71, 70, 70, 0.4) 0px 2px 4px, rgba(0, 0, 0, 0.3) 0px 7px 13px -3px, rgba(0, 0, 0, 0.2) 0px -3px 0px inset;
    }
</style>
<script src="/public/js/angular.min.js"></script>
<div class="container" ng-app="PosteApp" ng-controller="tableController" style="font-family:Helvetica;display: flex;justify-content: center;margin-top: 5%;">
    <div class="row" style="display: flex;justify-content: center;">
        <div class="col-md-7">
            <form ng-submit="submitForm()">
                <div class="form">
                    <div class="container"><h5>Insertion Poste</h5><hr></div>
                        <div class="row mb-3">
                            <div class="input-group">
                                <input type="text" ng-model="poste.titre" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Titre</label>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="input-group">
                                <span class="input-group-text">Description</span>
                                <textarea ng-model="poste.description" class="form-control" aria-label="With textarea"></textarea>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="input-group">
                                <input type="number" ng-model="poste.salaire" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Salaire</label>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="input-group">
                                <input type="number" ng-model="poste.anneeExperience" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Année d'experience</label>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="input-group">
                                <input type="number" ng-model="poste.anneeFormation" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Année de formation</label>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <div class="input-group">
                                    <input type="number" ng-model="poste.ageMin" autocomplete="off" class="input" style=" border-radius: 15px;">
                                    <label class="user-label">Âge minimum</label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="input-group">
                                    <input type="number" ng-model="poste.ageMax" autocomplete="off" class="input" style=" border-radius: 15px;">
                                    <label class="user-label">Année maximum</label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <div class="input-group">
                                    <input type="number" ng-model="poste.cout" autocomplete="off" class="input" style=" border-radius: 15px;">
                                    <label class="user-label">Cout</label>
                                </div>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="exampleDataList" class="form-label">Diplome</label>
                                <input class="form-control" ng-model="poste.diplome" list="diplome" placeholder="Type to search...">
                                <datalist id="diplome">
                                    <option ng-repeat="diplome in diplomes" value="{{diplome.diplome}}"></option>
                                </datalist>
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-md-6">
                                <label for="exampleDataList" class="form-label">Entreprise</label>
                                <input class="form-control" ng-model="poste.entreprise" list="entreprise" placeholder="Type to search...">
                                <datalist id="entreprise">
                                    <option ng-repeat="entreprise in entreprises" value="{{entreprise.entreprise}}"></option>
                                </datalist>
                            </div>
                        </div>
                    <div class="container"><hr></div>
                    <div class="row mb-3">
                        <div class="col-md-9"></div>
                        <div class="col-md-3"><button class="btn btn-primary">Valider</button></div>
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
<script src="/public/js/input.js"></script>
<script src="/public/js/crud/Poste.js"></script>