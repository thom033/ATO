<%@ page contentType='text/html;charset=UTF-8' language='java' %>

    <link rel="stylesheet" href="/public/css/notification.css">

    <section class="py-5">
            <div class="row mb-4 mb-lg-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 class="custom-h2">Notifications</h2>
                </div>
            </div>
    </section>
    <div class="notification-container" ng-app="frontApp" ng-controller="notificationController" >

        <div ng-repeat="notif in notifications">
            <div class="notification-item row align-items-center" style="padding-top: 20px;">
                <div class="col-1 text-center pl">
                    <a href="/notification/delete/{{ notif.id }}"><span class="notification-icon download" style="margin-left: 40px;"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-download" viewBox="0 0 16 16">
                        <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5"/>
                        <path d="M7.646 11.854a.5.5 0 0 0 .708 0l3-3a.5.5 0 0 0-.708-.708L8.5 10.293V1.5a.5.5 0 0 0-1 0v8.793L5.354 8.146a.5.5 0 1 0-.708.708z"/>
                    </svg></span></a>
                </div>
                <div class="col-1 text-center">
                    <a href="" ng-click="delete(notif.id)"><span class="notification-icon garbage"><svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5M11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47M8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5"/>
                    </svg></span></a>
                </div>
                
                <div class="col-8">
                    <div class="notification-time">{{ tempsEcoule(notif.dateNotification) }}</div>
                    <div class="nicolas-message">{{ notif.message }}</div>
                </div>
                <div class="col-1 text-center"></div>
                <div class="col-1 text-end" style="margin-bottom: 5px;">
                <div class="notification-date" >{{ formatDate(notif.dateNotification) }}</div>
                    <div ng-if="estDynamique(notif) >= 0"> 
                        <a href="{{ interpreterUrl(notif) }}"><span class="notification-icon chevron" ><svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
                        </svg></span></a>
                    </div>
                </div>
            </div>
        </div>
        
    </div>

    <script src="/public/js/angular.min.js"></script>
    <script src="/public/js/client/frontApp.js"></script>

