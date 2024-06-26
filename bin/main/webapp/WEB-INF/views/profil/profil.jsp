<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="itu.utilisateur.Utilisateur"%>
<%@ page import="itu.experience.Experience"%>
<%@ page import="itu.formation.Formation"%>
<%@ page import="itu.diplome.Diplome"%>
<%@ page import="itu.competence.Competence"%>
<%@ page import="itu.secteur.Secteur"%>
<%@ page import="itu.contact.Contact"%>
<%@ page import="itu.achat.Argent"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%
    Utilisateur user = (Utilisateur) request.getAttribute("utilisateur");
    List<Experience> exp = (List<Experience>) request.getAttribute("experiences");
    List<Formation> form = (List<Formation>) request.getAttribute("formations");
    List<Diplome> dip = (List<Diplome>) request.getAttribute("diplomes");
    List<Competence> comp = (List<Competence>) request.getAttribute("competences");
    List<Secteur> sect = (List<Secteur>) request.getAttribute("secteurs");
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
    Argent arg = (Argent) request.getAttribute("argent");
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>profile</title>
    <link rel="stylesheet" href="/public/bootstrap/css/pikaday.min.css">
    <link rel="stylesheet" href="/public/css/profile.css">
    <link rel="stylesheet" href="/public/css/achat.css">
</head>

<body>
    <div class="container-principale">
        <div class="row">
            <div class="col-md-3 fixed-top" style="margin-left: 20px;top: 30px;">
                <div class="sticky-top">
                <div class="profile">
                    <div class="container">
                        <div class="div_avatar">
                            <a class="nav-link active" data-bs-toggle="offcanvas" href="#offcanvasEntretien" role="button" aria-controls="offcanvasExample" style="font-family: 'Space Grotesk';">
                            <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <img class="avatar" id="avatar" src="/public/img/uploaded/<%= user.getId() %>.jpg" alt="" onerror="this.onerror=null; this.src='/public/img/uploaded/avatar.png';">
                            </a>
                        </div>
                    </div>
                </div>

                <!-- Vertically centered modal -->
                <div class="modal-dialog modal-dialog-centered">
                    
                </div>
                <div class="contact">
                    <div class="info-perso">
                        <div class="svg">
                            <img class="icon-contact" src="/public/img/icon/fi-rr-phone-flip.svg">
                        </div>
                        <div class="apropos">
                            <% 
                                for(Contact contact : contacts) {
                            %>
                            <p><%= contact.getNumTelephone() %></p>
                            <% } %>
                        </div>
                    </div>
                    <div class="info-perso">
                        <div class="svg">
                            <img class="icon-contact" src="/public/img/icon/fi-rr-envelope.svg">
                        </div>
                        <div class="apropos">
                            <p><%= user.getMail()%></p>
                        </div>
                    </div>
                </div>
                    <p><%= user.getDescription() %></p>
                <div class="button-info">
                    <div class="my-2"><a href="/utilisateur/parametre" style="background-color: #fff; border-color: #000; color: #000;" class="btn btn-primary shadow btn-full" type="submit">Compléter vos informations</a></div>
                    <div class="my-2" ><form action="/utilisateur/deconnexion"><button style="background-color: #79A3C1; border-color: #79A3C1; " class="btn btn-primary shadow btn-full" type="submit">Deconnexion</button></form></div>
                </div>
                </div>
            </div>
            <div class="col-md-1 col-lg-1" style="position:relative; margin-left: auto;"></div>
            <div class="col-md-8 col-lg-8">
                <div>
                    <section class="position-relative py-4 py-xl-5">
                        <div class="container">
                            <div class="row mb-2">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/img/icon/fi-rr-user.svg">
                                    </div>
                                    <div>
                                        <h4>INFORMATIONS PERSONNELLES :</h4>
                                    </div>
                                </div>
                                <div class="information">
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Nom</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= user.getNom() %></p>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Prenom(s)</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= user.getPrenom() %></p>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Adresse</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= user.getAdresse() %></p>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Secteur</p>
                                        </div>
                                        <div class="variable">
                                        <% 
                                            for(Secteur secteur : sect) {
                                        %>
                                        <p><%= secteur.getSecteur() %></p>
                                        <% } %>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Age</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= user.calculateAge()%></p>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Coordonnées</p>
                                        </div>
                                        <div class="variable">
                                            <p>Longitude : <%= user.getLongitude() %>°</p> 
                                            <p>Latitude : <%= user.getLatitude() %>°</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="container" style="margin-top: 30px;">
                            <div class="row mb-2">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/img/icon/fi-rr-building.svg">
                                    </div>
                                    <div>
                                        <h4>INFORMATIONS PROFESSIONNELLES :</h4>
                                    </div>
                                </div>
                                <div class="information">
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Compétence(s)</p>
                                        </div>
                                        <div class="variable">
                                        <% 
                                            for(Competence competence : comp) {
                                        %>
                                        <p><%= competence.getCompetence() %></p>
                                        <% } %>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Expérience(s)</p>
                                        </div>
                                        <div class="variable">
                                        <%
                                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                            for (Experience experience : exp) {
                                                String dateDebut = sdf.format(experience.getDateDebut());
                                                String dateFin = sdf.format(experience.getDateFin());
                                        %>
                                                <p><%= experience.getDescription() %></p>
                                                <p>Date : <%= dateDebut %> au <%= dateFin %></p>
                                        <% 
                                            } 
                                        %>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Formation(s)</p>
                                        </div>
                                        <div class="variable">
                                        <%
                                            SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
                                            for (Formation formation : form) {
                                                String dateDebutt = sdff.format(formation.getDateDebut());
                                                String dateFinn = sdff.format(formation.getDateFin());
                                        %>
                                                <p><%= formation.getDescription() %></p>
                                                <p>Date : <%= dateDebutt %> au <%= dateFinn %></p>
                                        <% 
                                            } 
                                        %>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Diplôme(s)</p>
                                        </div>
                                        <div class="variable">
                                        <% 
                                            for(Diplome diplome : dip) {
                                        %>
                                        <p><%= diplome.getDiplome() %></p>
                                        <% } %>
                                        </div>
                                    </div>
                                    <div class="input">
                                        <div class="invariable">
                                            <p>Salaire Recherché</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= user.getSalaireRecherche()%></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="container" style="margin-top: 30px;">
                            <div class="row mb-2">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/img/icon/fi-rr-wallet.svg">
                                    </div>
                                    <div>
                                        <h4>PORTEFEUILLE :</h4>
                                    </div>
                                </div>
                                <div class="container" style="margin-top: 20px;">
                                    <div class="row">
                                        <div class="col-md-3 col-lg-3">
                                            <div class="col offset-xl-0 mb-4">
                                                <div class="card bg-body-tertiary border-0">
                                                    <div class="card-body p-3">
                                                        <div class="element">
                                                            <div class="row">
                                                                <div class="col-md-9">
                                                                    <p class="point">Points</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <form action="/achat" method="get">
                                                                        <input type="hidden" name="type" value="0" />
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
                                                            <p class="montant"><%= user.getPoint() %> pts</p>
                                                        </div>
                                                        <hr>
                                                        <div class="desc">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <p class="description">Achetes</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-3 col-lg-3">
                                            <div class="col offset-xl-0 mb-4">
                                                <div class="card bg-body-tertiary border-0">
                                                    <div class="card-body p-3" style="background-color: #79A3C1; color: white">
                                                        <div class="element">
                                                            <div class="row">
                                                                <div class="col-md-9">
                                                                    <p class="point">Solde</p>
                                                                </div>
                                                                <div class="col-md-3">
                                                                    <form action="/achat" method="get">
                                                                        <input type="hidden" name="type" value="1" />
                                                                        <button type="submit" class="btn-svg" style="background-color: #79A3C1; color: #fff;">
                                                                            <svg id="titre" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
                                                                                <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8m15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0M4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5z"/>
                                                                            </svg>
                                                                        </button>
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <p class="montant"><%= arg.getSolde() %> Ar</p>
                                                        </div>
                                                        <hr>
                                                        <div class="desc">
                                                            <div class="row">
                                                                <div class="col-md-6">
                                                                    <p class="description">Date</p>
                                                                </div>
                                                                <div class="col-md-6">
                                                                    <%
                                                                    String date = sdf.format(arg.getDate());
                                                                    %>
                                                                    <p class="description"><%=  date %></p>
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
                </section>
            </div>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
        <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Changer de photo de profil</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-footer">
            <form id="uploadForm" enctype="multipart/form-data">
                <input type="file" id="fileInput" name="file" accept="image/*">
                <button type="button" class="btn btn-primary" onclick="uploadImage()">Upload</button>
            </form>
            <button type="button" class="btn btn-light" data-bs-dismiss="modal">Close</button>
        </div>
        </div>
    </div>
    </div>

    <script src="/public/bootstrap/js/pikaday.min.js"></script>
    <script src="/public/bootstrap/js/theme.js"></script>
    <script src="/public/js/upload.js"></script>
</body>
</html>