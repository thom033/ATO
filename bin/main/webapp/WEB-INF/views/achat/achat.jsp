<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    int type = (int) request.getAttribute("type");
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Achat points</title>
    <link rel="stylesheet" href="/public/css/input.css">
    <link rel="stylesheet" href="/public/css/achat.css">
</head>

<body>
    <div class="main">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-lg-6" style="background-color: rgb(176, 176, 176);">
                    <div class="gauche">

                        <%
                            if(type==0){
                        %>
                        <div class="achat">
                            <div class="head">
                                <span class="icon">
                                    <h3 id="titre" class="fw-bold">Notre Tarif</h3>
                                    <img class="icon-image" src="/public/bootstrap/icon/fi-rr-coins.svg" alt="">
                                </span>
                            </div>
                            <p class="my-1">1 point : 5 000 Ar</p>
                            <div class="head" style="margin-top: 30px;">
                                <span class="icon">
                                    <h3 id="titre" class="fw-bold">Achat</h3>
                                        <img src="/public/bootstrap/icon/fi-rr-shopping-cart.svg" alt="" class="icon-image">
                                </span>
                            </div>
                            <p class="description">Quantite de points</p>
                            <form class="form-quantite" method="get" action="/utilisateur/achat">
                                <div class="input-group">
                                    <input required type="number" id="quantite" name="quantite" autocomplete="off" class="input" style="border-radius: 15px;">
                                    <label class="user-label">Quantite</label>
                                </div>
                                <div class="my-2" style="margin-left: 20px;"><button style="background-color: #79A3C1; border-color: #79A3C1; " class="btn btn-primary shadow" type="submit">Valider</button></div>
                            </form>
                            <% if (request.getAttribute("error") != null) { %>
                                <div class="alert alert-danger" style="width: 350px; margin-top: 30px;">
                                    <%= request.getAttribute("error") %>
                                </div>
                            <% } %>
                            <div class="valeur">
                                <p class="tab">Valeur actuelle :</p>
                                <p id="solde"></p>
                            </div>
                        </div>

                        <%
                            }else{
                        %>
                        <div class="achat">
                            <div class="head">
                                <span class="icon">
                                    <h3 id="titre" class="fw-bold">Solde</h3>
                                    <img class="icon-image" src="/public/bootstrap/icon/fi-rr-coins.svg" alt="">
                                </span>
                            </div>
                            <div class="head" style="margin-top: 30px;">
                                <span class="icon">
                                    <h3 id="titre" class="fw-bold">Recharger</h3>
                                        <img src="/public/bootstrap/icon/fi-rr-shopping-cart.svg" alt="" class="icon-image">
                                </span>
                            </div>
                            <p class="description">Solde a recharger</p>
                            <form class="form-quantite" method="get" action="/utilisateur/solde">
                                <div class="input-group">
                                    <input required type="text" id="valeur" name="valeur" autocomplete="off" class="input" style="border-radius: 15px;">
                                    <label class="user-label">Montant</label>
                                </div>
                                <div class="my-2" style="margin-left: 20px;"><button style="background-color: #79A3C1; border-color: #79A3C1; " class="btn btn-primary shadow" type="submit">Valider</button></div>
                            </form>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="col-md-1 col-lg-1"></div>
                <div class="col-md-5 col-lg-5">
                    <div class="col offset-xl-0 mb-8">
                        <div class="card bg-body-tertiary border-0">
                            <div class="card-body p-4" style="background-color: black; color:white;">
                                <div style="margin-top: 20px; margin-bottom: 50px;">
                                    <h3 class="fw-bold">Nos offres</h3>
                                    <p style="margin-top: -2px; font-size: 10px;">Les propositions d'achat disponible:</p>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-6 col-lg-6">
                                            <div class="col offset-xl-0 mb-4">
                                                <div class="card bg-body-tertiary border-0">
                                                    <div class="card-body p-3">
                                                        <div class="element">
                                                            <div class="row">
                                                                <div class="col-md-9">
                                                                    <p class="point">5 pts</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <form action="/utilisateur/achat" method="get">
                                                                        <input required type="hidden" name="quantite" id="quantite" value="5">
                                                                        <input type="hidden" name="reduction" id="reduction" value="reduction">
                                                                        <button type="submit" class="btn-svg">
                                                                            <svg id="titre" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
                                                                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5z"/>
                                                                            </svg>
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <p class="montant">24 000 Ar</p>
                                                        </div>
                                                        <hr>
                                                        <div class="desc">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <p class="description">soit</p>
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <p class="description">1 point : 4 800 Ar</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6 col-lg-6">
                                            <div class="col offset-xl-0 mb-4">
                                                <div class="card bg-body-tertiary border-0">
                                                    <div class="card-body p-3" style="background-color: #79A3C1; color: white">
                                                        <div class="element">
                                                            <div class="row">
                                                                <div class="col-md-9">
                                                                    <p class="point">10 pts</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <form action="/utilisateur/achat" method="get">
                                                                        <input required type="hidden" name="quantite" id="quantite" value="10">
                                                                        <input type="hidden" name="reduction" id="reduction" value="reduction">
                                                                        <button class="btn-svg" style="background-color: #79A3C1;">
                                                                            <svg id="titre" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
                                                                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5z"/>
                                                                            </svg>
                                                                        </button>
                                                                    </form>                                                                    
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <p class="montant">48 000 Ar</p>
                                                        </div>
                                                        <hr>
                                                        <div class="desc">
                                                            <div class="row">
                                                                <div class="col-md-4">
                                                                    <p class="description">soit</p>
                                                                </div>
                                                                <div class="col-md-8">
                                                                    <p class="description">1 point : 4 700 Ar</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <hr class="ligne">
            <div class="container" style="margin-top: 40px;">
                <div class="row">
                    <div class="col-md-5 col-lg-5">
                        <div class="row">
                            <div class="col-md-4">
                                <img class="image" src="/public/img/concept-graphique-performance-gestion-donnees.jpg" alt="">
                            </div>
                            <div id="mot" class="col-md-8">
                                <h3 class="fw-bold">Utilite des points</h3>
                                <p>Les points permettent de postuler pour un travail dans le site</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1 col-lg-1"></div>
                    <div class="col-md-6 col-lg-6">
                        <div class="row">
                            <div id="mot" class="col-md-8">
                                <h3 class="fw-bold">Gestion des points</h3>
                                <p>Les points seront consommes au moment ou vous postulez mais sera rendu dans le cas ou vous n'obtenez pas le poste</p>
                            </div>
                            <div class="col-md-4">
                                <img class="image" src="/public/img/gros-plan-femme-aide-calculatrice-telephone-intelligent_1262-16076.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        // Fonction pour mettre à jour la valeur actuelle
        function updateCurrentValue() {
            var inputQuantite = document.getElementById("quantite");
            var solde = document.getElementById("solde");

            // Recuperer la valeur de la quantite entree
            var quantite = parseInt(inputQuantite.value) || 0; // Assurez-vous que la valeur est un nombre, sinon, utilisez 0

            // Mettre à jour la valeur actuelle
            var valeurActuelle = quantite * 5000; // Calculer la valeur actuelle en fonction de la quantite
            solde.innerHTML = valeurActuelle + " Ar";
        }

        // Attacher un evenement d'entree à l'input de quantite pour mettre à jour la valeur actuelle en temps reel
        document.getElementById("quantite").addEventListener("input", updateCurrentValue);

        window.onload = function() {
            updateCurrentValue();
        };
    </script>
</body>

</html>