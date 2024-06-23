<div class="row mb-3">
    <div class="row mb-3">
        <div class="col-md-4">
            <div class="input-group">
                <input type="date" id="dateMin" ng-model="dateMin" class="input" style=" border-radius: 15px;">
                <label for="annee" class="user-label">Date min</label>
            </div>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input type="date" id="dateMax" ng-model="dateMax" class="input" style=" border-radius: 15px;">
                <label for="annee" class="user-label">Date max</label>
            </div>
        </div>
        <div class="col-md-4">
            <button class="btn btn-primary" ng-click="getMonnaieDate()">Voir revenue</button>
        </div>
    </div>
    <div class="row mb-3">
        <h2>{{monnaieString}}</h2>
    </div>
</div>
<div class="row">
    <div class="col-md-4">
        <div class="input-group">
            <input type="number" ng-model="annee" class="input" style=" border-radius: 15px;">
            <label for="annee" class="user-label">Annee</label>
        </div>
    </div>
    <div class="col-md-4">
        <button class="btn btn-primary" ng-click="getStatMonnaie()">Chercher</button>
    </div>
</div>
<div class="row">
    <canvas id="myChart" width="400" height="400"></canvas>
</div>