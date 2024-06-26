<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="/public/css/notification.css">

<div ng-app="frontApp" ng-controller="notificationController">
<section class="py-5">
    <div class="row mb-4 mb-lg-5">
        <div class="col-md-8 col-xl-6 text-center mx-auto">
            <h2 class="custom-h2">Notifications</h2>
        </div>
    </div>


        <select class="form-select" name="type" id="type" style="width: auto; margin: auto;" ng-model="selectedType" ng-change="filterNotifications()">
            <option value="" disabled>Ajouter un filtre</option>
            <option value="-1">Tous les notifications</option>
            <option value="0">Achat Points</option>
            <option value="1">Convocation</option>
            <option value="2">Opportunite</option>
            <option value="3">Resultat Entretien</option>
        </select>

</section>
<div class="notification-container" >
    <p ng-if="notifications.length == 0">404 aucune notification</p>
    <div ng-repeat="notif in notifications" class="notification-item row align-items-center" style="padding-top: 20px;">
        <div class="col-1 text-center pl">
            <a href="/notification/delete/{{ notif.id }}"><span class="notification-icon download" style="margin-left: 40px;">
                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z"/>
                </svg>
            </span></a>
        </div>
        <div class="col-1 text-center">
            <a href="" ng-click="delete(notif.id)"><span class="notification-icon garbage">
                <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                    <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
                </svg>
            </span></a>
        </div>
        <div class="col-8">
            <div class="notification-time">{{ tempsEcoule(notif.dateNotification) }}</div>
            <div class="nicolas-message">{{ notif.message }}</div>
        </div>
        <div class="col-1 text-center"></div>
        <div class="col-1 text-end" style="margin-bottom: 5px;">
            <div class="notification-date">{{ formatDate(notif.dateNotification) }}</div>
            <div ng-if="estDynamique(notif) >= 0">
                <a href="{{ interpreterUrl(notif) }}"><span class="notification-icon chevron">
                    <svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
                    </svg>
                </span></a>
            </div>
        </div>
    </div>
</div>

<script src="/public/js/angular.min.js"></script>
<script src="/public/js/client/frontApp.js"></script>
</div>