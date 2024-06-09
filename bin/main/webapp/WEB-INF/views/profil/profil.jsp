<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="itu.utilisateur.Utilisateur"%>
<%@ page import="itu.experience.Experience"%>
<%@ page import="itu.diplome.Diplome"%>
<%@ page import="itu.competence.Competence"%>
<%@ page import="itu.secteur.Secteur"%>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    Utilisateur user = (Utilisateur) request.getAttribute("utilisateur");
    List<Experience> exp = (List<Experience>) request.getAttribute("experiences");
    List<Diplome> dip = (List<Diplome>) request.getAttribute("diplomes");
    List<Competence> comp = (List<Competence>) request.getAttribute("competences");
    List<Secteur> sect = (List<Secteur>) request.getAttribute("secteurs");

%> 

<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head> 
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>profile</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato:300,400,700&amp;display=swap">
    <link rel="stylesheet" href="/public/assetsProfil/bootstrap/css/pikaday.min.css">
    <link rel="stylesheet" href="/public/assetsProfil/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/public/assetsProfil/css/Login-Form-Basic-icons.css">
    <link rel="stylesheet" href="/public/assetsProfil/css/profile.css">
</head>

<body>
    <div class="container-principale">
        <div class="row">
            <div class="col-md-3 col-lg-3">
                <div class="profile">
                    <div class="container">
                        <div class="div_avatar">
                            <img class="avatar" src="/public/assetsProfil/img/avatars/avatar.jpg" alt="">
                        </div>
                    </div>
                </div>
                <div class="contact">
                    <div class="info-perso">
                        <div class="svg">
                            <img class="icon" src="/public/assetsProfil/img/icon/fi-rr-phone-flip.svg">
                        </div>
                        <div>
                            <p>034 56 556 56</p>
                        </div>
                    </div>
                    <div class="info-perso">
                        <div class="svg">
                            <img class="icon" src="/public/assetsProfil/img/icon/fi-rr-envelope.svg">
                        </div>
                        <div>
                            <p><%= user.getMail()%></p>
                        </div>
                    </div>
                </div>
                <p><%= user.getDescription() %></p>
            </div>
            <div class="col-md-1 col-lg-1"></div>
            <div class="col-md-6 col-lg-6">
                <div>
                    <section class="position-relative py-4 py-xl-5">
                        <div class="container">
                            <div class="row mb-5">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/assetsProfil/img/icon/fi-rr-user.svg" style="margin-top: -10px; width: 25px; height: 25px">
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
                                            <p>Longitude: <%= user.getLongitude() %></p> 
                                            <p>Latitude: <%= user.getLatitude() %></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="container">
                            <div class="row mb-5">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/assetsProfil/img/icon/fi-rr-building.svg" style="margin-top: -10px; width: 25px; height: 25px">
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
                    </section>
                </div>
            </div>
            <div class="col-md-2 col-lg-2" >
                <a href="#">Completer les informations></a>
            </div>
        </div>
    </div>
    <script src="/public/assetsProfil/bootstrap/js/bootstrap.min.js"></script>
    <script src="/public/assetsProfil/bootstrap/js/pikaday.min.js"></script>
    <script src="/public/assetsProfil/bootstrap/js/theme.js"></script>
</body>

</html>