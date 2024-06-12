<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="itu.secteur.Secteur" %>
<%@ page import="itu.diplome.Diplome" %>
<%@ page import="itu.competence.Competence" %>
<%
    List<Secteur> secteurs = (List<Secteur>) request.getAttribute("allSecteurs");
    List<Competence> competences = (List<Competence>) request.getAttribute("allCompetences");
    List<Diplome> diplomes = (List<Diplome>) request.getAttribute("allDiplomes");
%>    

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Recherche</title>
    <link rel="stylesheet" href="/public/bootstrap/css/stylesRecherche.css">
    <link rel="stylesheet" href="/public/bootstrap/css/input.css">
</head>

<body>
    <header class="bg-primary-gradient"  style="font-family: Helvetica;">
        <section style="margin-bottom: -2px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1 style="font-size: 35px;margin-left: 89px;padding-bottom: 0px;margin-bottom: -1px;margin-top: -2px; font-weight: bold"><br>Explorez de nouvelles perspectives. <strong>new*</strong> <br><br></h1>
                    </div>
                    <div class="col-md-6" style="padding-left: 82px;">
                        <p style="padding-bottom: 0px;margin-top: 53px;margin-bottom: 56px;margin-right: 244px;">Nos recherches ouvrent des horizons insoupçonnés pour un avenir innovant&nbsp;</p>
                    </div>
                </div>
            </div>
        </section>
    </header>

    <div class="container" style="font-family:Helvetica" style="background-image: url(/public/img/fond.png);">
        <div class="card">
            <div class="container mt-5">
                <div class="content">
                    <h5>Recherche de travail</h5><hr>
                    <form method="get" action="recherche_result">
                    <div class="row" >
                        <div class="input-group">
                            <span class="input-group-text" style="height:47px;">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" viewBox="0 0 16 16" class="bi bi-search">
                                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                                </svg>
                            </span>
                            <input type="text" class="form-control mb-2" placeholder="Recherche par titre">
                        </div>
                    </div>
                    <p>Plus de details</p>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <span class="input-group-text">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-file-text" viewBox="0 0 16 16">
                                        <path d="M5 4a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm-.5 2.5A.5.5 0 0 1 5 6h6a.5.5 0 0 1 0 1H5a.5.5 0 0 1-.5-.5M5 8a.5.5 0 0 0 0 1h6a.5.5 0 0 0 0-1zm0 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1z"/>
                                        <path d="M2 2a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2zm10-1H4a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h8a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1"/>
                                    </svg>
                                </span>
                                <select class="form-select" name="diplome" id="diplome">
                                    <option value="">Diplome</option>
                                    <% 
                                        for(Diplome Diplome : diplomes) {
                                    %>
                                    <option value="<%= Diplome.getId() %>"><%= Diplome.getDiplome() %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Age min</label>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3"> 
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Age max</label>
                            </div>
                        </div>
                    </div>
                    <p>A propos de l'entreprise et salaire</p>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <span class="input-group-text">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                                        <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4z"/>
                                    </svg>
                                </span>
                                <select class="form-select" name="secteur" id="secteur">
                                    <option value="">Secteur</option>
                                    <% 
                                        for(Secteur secteur : secteurs) {
                                    %>
                                    <option value="<%= secteur.getId() %>"><%= secteur.getSecteur() %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Salaire min</label>
                            </div>
                        </div> 
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Salaire max</label>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Distance</label>
                            </div>
                        </div>
                    </div>
                    <p>Experience de travail et compétence</p>
                    <div class="row">
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <input type="text" name="text" autocomplete="off" class="input" style=" border-radius: 15px;">
                                <label class="user-label">Année</label>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3">
                            <div class="input-group">
                                <span class="input-group-text">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-hammer" viewBox="0 0 16 16">
                                        <path d="M9.972 2.508a.5.5 0 0 0-.16-.556l-.178-.129a5 5 0 0 0-2.076-.783C6.215.862 4.504 1.229 2.84 3.133H1.786a.5.5 0 0 0-.354.147L.146 4.567a.5.5 0 0 0 0 .706l2.571 2.579a.5.5 0 0 0 .708 0l1.286-1.29a.5.5 0 0 0 .146-.353V5.57l8.387 8.873A.5.5 0 0 0 14 14.5l1.5-1.5a.5.5 0 0 0 .017-.689l-9.129-8.63c.747-.456 1.772-.839 3.112-.839a.5.5 0 0 0 .472-.334"/>
                                    </svg>
                                </span>
                                <select class="form-select" name="Competence" id="Competence">
                                    <option value="">Competence</option>
                                    <% 
                                        for(Competence Competence : competences) {
                                    %>
                                    <option value="<%= Competence.getId() %>"><%= Competence.getCompetence() %></option>
                                    <% } %>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-3 mb-3"> </div>
                        <div class="col-md-3 mb-3">
                            <button type="submit" class="button">Valider</button>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>