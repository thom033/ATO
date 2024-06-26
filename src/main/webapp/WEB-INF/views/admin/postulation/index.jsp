<%@ page contentType='text/html;charset=UTF-8' language='java' %>

    <link rel="stylesheet" href="/public/css/postulation.css">
    
    <section class="py-5">
            <div class="row mb-4 mb-lg-5">
                <div class="col-md-10 col-xl-10 text-center mx-auto">
                    <h2 class="custom-h2">Postulation en cours</h2>
                </div>
            </div>
    </section>
    <style>
        .nom-boutton {
            font-size: 15px;
            font-weight: 400;
            transition: 0.2s;
        }
        .nom-boutton:hover {
            font-weight: 600;
            transition:0.2s;    
        }
    </style>
    <div class="notification-container" ng-app="AdminApp" ng-controller="crudPostulationController" >

            <form method="GET" action="/admin/valider/postulation" ng-repeat="postu in postulations | orderBy:'-date'" class="notification-item row align-items-center" style="padding-top: 20px;">
                <div class="col-1 text-center pl">
                    <button type="submit" class="sub-nico" ><span class="notification-icon download"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425z"/>
                    </svg></span></button>
                </div>
                <div class="col-1 text-center">
                    <a href="" ng-click="delete(postu.id)"><span class="notification-icon garbage"><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-x-lg" viewBox="0 0 16 16">
                    <path d="M2.146 2.854a.5.5 0 1 1 .708-.708L8 7.293l5.146-5.147a.5.5 0 0 1 .708.708L8.707 8l5.147 5.146a.5.5 0 0 1-.708.708L8 8.707l-5.146 5.147a.5.5 0 0 1-.708-.708L7.293 8z"/>
                    </svg></span></a>
                </div>
                
                <div class="col-4">
                    <div class="notification-time"><a class="nom-boutton" href="/admin/utilisateur/profil/{{ postu.utilisateur.id }}">{{ postu.utilisateur.nom }} {{ postu.utilisateur.prenom }}</a></div>
                    <div class="nicolas-message"><a class="nom-boutton" href="/poste/details?idPoste={{ postu.poste.idPoste }}">{{ postu.poste.posteTitre }}</a></div>
                    
                        <%-- <input type="datetime-local" class="input-date form-control" ng-model="postulation.date" name="date"  >
                        <input type="hidden" name="id" value="{{ postu.id }}">
                        <input type="hidden" name="idUtilisateur" value="{{ postu.utilisateur.id }}"> --%>
                </div>
                <div class="col-4">
                    <input type="datetime-local" class="form-control" ng-model="postulation.date" name="date"  >
                    <input type="hidden" name="id" value="{{ postu.id }}">
                    <input type="hidden" name="idUtilisateur" value="{{ postu.utilisateur.id }}">
                </div>
                
                <div class="col-1 text-center"></div>
                <div class="col-1 text-end" style="margin-bottom: 5px;">
                <div class="notification-date" >{{ formatDate(postu.date) }}</div>
                    <div ng-if="estDynamique(notif) >= 0"> 
                        <a href="{{ interpreterUrl(notif) }}"><span class="notification-icon chevron" ><svg xmlns="http://www.w3.org/2000/svg" width="15" height="15" fill="currentColor" class="bi bi-chevron-right" viewBox="0 0 16 16">
                            <path fill-rule="evenodd" d="M4.646 1.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1 0 .708l-6 6a.5.5 0 0 1-.708-.708L10.293 8 4.646 2.354a.5.5 0 0 1 0-.708"/>
                        </svg></span></a>
                    </div>
                </div>
            </form>
        
    </div>


    <script src="/public/js/angular.min.js"></script>
    <script src="/public/js/script.js"></script>
    <script src="/public/js/sweetalert2.js"></script>
    <script src="/public/js/crud/Admin.js"></script>
    <script>
        function validateForm() {
        // Vous pouvez ajouter ici la logique de validation du formulaire
        
        // Par exemple, récupérer la valeur du champ nom
        var nom = document.getElementById("fname").value;
        
        // Valider le champ nom
        if (nom == "") {
            alert("Le champ Nom doit être rempli");
            return false; // Empêche la soumission du formulaire si le champ est vide
        }
        
        // Si la validation est réussie, soumettre le formulaire
        document.getElementById("myForm").submit();
        }
    </script>

