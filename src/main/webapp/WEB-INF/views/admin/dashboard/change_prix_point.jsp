<div class="row mb-3">
    <div class="container">
        <h4>Changement prix des points</h4>
        <hr>
        <div class="row mb-3">
            <div class="col-md-4">
                <div class="input-group">
                    <input type="text" ng-model="newPrice" class="input" style=" border-radius: 15px;">
                    <label for="annee" class="user-label">Prix point</label>
                </div>
            </div>
        </div>
        <div class="row" style="justify-content:center;display:flex;">
            <div class="col-md-4">
                <button class="btn btn-primary" ng-click="changePrice()">Changer Prix</button>
            </div>
        </div>
        <hr>
    </div>
    <div class="container">
        <h4>Changement des promotions</h4>
        <hr>
        <div class="row mb-3">
            <div class="col-md-4">
                <div class="input-group">
                    <input type="number" ng-model="promotion.nombrePromotion1" class="input" style=" border-radius: 15px;">
                    <label for="annee" class="user-label">Nombre de point</label>
                </div>
            </div>
            <div class="col-md-4">
                <div class="input-group">
                    <input type="text" ng-model="promotion.pourcentage1" class="input" style=" border-radius: 15px;">
                    <label for="annee" class="user-label">Pourcentage</label>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-4">
                <div class="input-group">
                    <input type="number" ng-model="promotion.nombrePromotion2" class="input" style=" border-radius: 15px;">
                    <label for="annee" class="user-label">Nombre de point</label>
                </div>
            </div>
            <div class="col-md-4">
                <div class="input-group">
                    <input type="text" ng-model="promotion.pourcentage2" class="input" style=" border-radius: 15px;">
                    <label for="annee" class="user-label">Pourcentage</label>
                </div>
            </div>
        </div>
        <div class="row" style="justify-content:center;display:flex;">
            <div class="col-md-4">
                <button class="btn btn-primary" ng-click="changePromotion()">Changer</button>
            </div>
        </div>
        <hr>
    </div>
</div>