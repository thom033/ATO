<div class="row">
    <div class="col-md-4">
        <div class="input-group">
            <input type="number" ng-model="annee" class="input" style=" border-radius: 15px;">
            <label for="annee" class="user-label">Annee</label>
        </div>
    </div>
    <div class="col-md-4">
        <button class="btn btn-primary" ng-click="getStatPoint()">Chercher</button>
    </div>
</div>
<div class="row">
    <canvas id="myChart" width="400" height="400"></canvas>
</div>