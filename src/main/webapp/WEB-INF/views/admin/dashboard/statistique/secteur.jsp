<div class="row">
    <div class="col-md-4">
        <div class="input-group">
            <input type="number" ng-model="annee" class="input" style=" border-radius: 15px;">
            <label for="annee" class="user-label">Annee</label>
        </div>
    </div>
    <div class="col-md-4">
        <div class="input-group">
            <select class="form-select" ng-model="mois" aria-label="Default select example">
                <option selected ng-repeat="month in months" ng-value="month.value">{{month.mois}}</option>
            </select>
        </div>
    </div>
    <div class="col-md-4">
        <button class="btn btn-primary" ng-click="getStatSecteur()">Chercher</button>
    </div>
</div>
<div class="row">
    <canvas id="myPieChart" width="400" height="400"></canvas>
</div>