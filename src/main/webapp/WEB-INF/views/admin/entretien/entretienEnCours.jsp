<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <link rel="stylesheet" href="/public/css/notification.css">

    <section class="py-5">
            <div class="row mb-4 mb-lg-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 class="custom-h2">Entretien en cours</h2>
                </div>
            </div>
    </section>
    <div class="notification-container" ng-app="frontApp" ng-controller="entretienController" >
            <p ng-if="entretiens.length == 0">404 aucune notification</p>
            <div ng-repeat="entretien in entretiens | orderBy:'-dateEnvoi'" class="notification-item row align-items-center" style="padding-top: 20px;">
                <div class="col-1 text-center pl">
                    <a href="" ng-click="valider(entretien.id)"><span class="notification-icon download" style="margin-left: 40px;"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z"/>
                    </svg></span></a>
                    
                </div>
                <div class="col-1 text-center">
                    <a href="" ng-click="delete(entretien.id)"><span class="notification-icon garbage"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                    <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
                    </svg></span></a>
                </div>
                
                <div class="col-8">
                    <div class="notification-time">{{ tempsEcoule(entretien.dateEnvoi) }}</div>
                    <div class="nicolas-message">{{ entretien.poste.posteDescription }}</div>
                </div>
                <div class="col-1 text-center"></div>
                <div class="col-1 text-end" style="margin-bottom: 5px;">
                <div class="notification-date" >{{ formatDate(entretien.dateEntretien) }}</div>
                    <div ng-if="estDynamique(notif) >= 0"> 
                        <a href="{{ interpreterUrl(notif) }}"><span class="notification-icon chevron" ><svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
                        </svg></span></a>
                    </div>
                </div>
            </div>
        
    </div>

    <script src="/public/js/angular.min.js"></script>
    <script src="/public/js/client/frontApp.js"></script>

