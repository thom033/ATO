<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="itu.compatibilite.PosteDetails"%>
<%@ page import="java.util.List" %>
<%@ page import="itu.contact.Contact"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    PosteDetails postedetails = (PosteDetails) request.getAttribute("details");
    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
%>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>profile</title>
    <link rel="stylesheet" href="/public/bootstrap/css/pikaday.min.css">
    <link rel="stylesheet" href="/public/css/travail.css">
</head>

<body ng-app="adminApp" ng-controller="posteController">
    <div class="container-principale">
        <div class="row">
            <div class="col-md-3 fixed-top" style="margin-left: 20px;top: 30px;">
                <div class="profile">
                    <div class="container">
                        <a type="button" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            <div class="div_avatar">
                                <img class="avatar" style="object-fit: cover" src="/public/img/uploaded/p_<%= postedetails.getIdPoste() %>.jpg" alt="" onerror="this.onerror=null; this.src='/public/img/uploaded/travail.jpg';">
                            </div>
                        </a>
                    </div>
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
                            <p><%= postedetails.getEntrepriseMail() %></p>
                        </div>
                    </div>
                </div>
                <p><%= postedetails.getPosteDescription() %></p>
                <div class="button-info">
                    <div class="my-2" ><a href="/admin/supprimer/<%= postedetails.getIdPoste() %>"><button style="background-color: #79A3C1; border-color: #79A3C1; " class="btn btn-primary shadow" >Supprimer</button></a></div>
                </div>
            </div>
            <div class="col-md-1 col-lg-1" style="position:relative; margin-left: auto;"></div>
            <div class="col-md-8 col-lg-8">
                <div>
                    <section class="position-relative py-4 py-xl-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-md-7 col-lg-7">
                                    <p class="W"><%= postedetails.getPosteTitre() %></p>
                                    <p class="descW"><%= postedetails.getEntrepriseNom() %></p>
                                    <p class="ptsW"><%= postedetails.getPosteCout() %> points</p>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="container" style="margin-top: 30px;">
                            <div class="row mb-2">
                                <div class="info-perso">
                                    <div  class="svg">
                                        <img class="icon" src="/public/img/icon/fi-rr-briefcase.svg">
                                    </div>
                                    <div>
                                        <h4>INFORMATIONS DU TRAVAIL</h4>
                                    </div>

                                    <% if (request.getAttribute("error") != null) { %>
                                            <p><%= request.getAttribute("error") %></p>
                                    <% } %>

                                </div>
                                <div class="information">
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Titre</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= postedetails.getPosteTitre() %></p>
                                        </div>
                                    </div>
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Salaire</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= postedetails.getPosteSalaire() %> Ariary</p>
                                        </div>
                                    </div>
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Age min-max</p>
                                        </div>
                                        <div class="variable">
                                            <p><%= postedetails.getPosteAgeMin() %> - <%= postedetails.getPosteAgeMax() %> ans</p>
                                        </div>
                                    </div>
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Formation</p>
                                        </div>
                                        <div class="variable">
                                            <p class="inpute"><%= postedetails.getNbrAnneeFormation() %> ans de formations</p> <!-- Zay <p> farany asiana class="inpute" -->
                                        </div>
                                    </div>
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Expérience</p>
                                        </div>
                                        <div class="variable">
                                            <p class="inpute"><%= postedetails.getNbrAnneeExperience() %> ans d'expérience</p> <!-- Zay <p> farany asiana class="inpute" -->
                                        </div>
                                    </div>
                                    <div class="inpute">
                                        <div class="invariable">
                                            <p>Diplôme</p>
                                        </div>
                                        <div class="variable">
                                            <p class="inpute"><%= postedetails.getDiplomeNom() %></p> <!-- Zay <p> farany asiana class="inpute" -->
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
                                        <h4>ENTREPRISE</h4>
                                    </div>
                                </div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="information">
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Nom</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p><%= postedetails.getEntrepriseNom() %></p>
                                                    </div>
                                                </div>
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Secteur</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p>Informatique</p>
                                                    </div>
                                                </div>
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Site web</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p><%= postedetails.getEntrepriseSiteWeb() %></p>
                                                    </div>
                                                </div>
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Adresse</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p><%= postedetails.getEntrepriseAdresse() %></p>
                                                    </div>
                                                </div>
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Coordonnées</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p><%= postedetails.getEntrepriseLatitude() %>° <%= postedetails.getEntrepriseLongitude() %>°</p>
                                                    </div>
                                                </div>
                                                <div class="inpute">
                                                    <div class="invariable">
                                                        <p>Points</p>
                                                    </div>
                                                    <div class="variable">
                                                        <p><%= postedetails.getEntreprisePoint() %></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <img src="/public/img/avatars/<%= postedetails.getEntrepriseImage() %>" alt="">
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
    
</body>
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
                <button type="button" onclick="uploadImagePoste(<%= postedetails.getIdPoste()  %>)">Upload</button>
            </form>
            <button type="button" class="btn btn-light" data-bs-dismiss="modal">Close</button>
        </div>
        </div>
    </div>
    </div>
<script src="/public/bootstrap/js/pikaday.min.js"></script>
<script src="/public/bootstrap/js/theme.js"></script>
<script src="/public/js/sweetalert2.js"></script>
<script src="/public/js/angular.min.js"></script>
<script src="/public/js/client/frontApp.js"></script>
<script src="/public/js/script.js"></script>
<script src="/public/js/upload.js"></script>
</html>