<%@ page import="itu.utilisateur.Utilisateur"%>
<%
    String pages = (String) request.getAttribute("page");
    pages = pages + ".jsp";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Rohy</title>
    <link rel="stylesheet" href="/public/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/public/css/Splash.css">
    <link rel="stylesheet" href="/public/css/Header.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aleo&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Grotesk:300,400&amp;display=swap">
</head>

<body style="background: var(--bs-body-bg);">
    <nav class="navbar navbar-expand-md sticky-top navbar-shrink py-3 navbar-light" id="mainNav" style="margin-bottom: -1px;padding-bottom: 30px;padding-top: 0px;">
        <div class="container"><a href="/" style="margin-top: -32px;margin-bottom: -21px;margin-left: -33px;width: 150px;"><img class="img-fluid" src="/public/img/rohy1.jpg" ></a><a class="navbar-brand d-flex align-items-center" href="/"></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1" style="font-size: large;margin-bottom: -2px;font-family: Aleo, serif;">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"><a class="nav-link active" href="/acceuil" style="font-family: 'Space Grotesk';">Acceuil</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#" style="font-family: 'Space Grotesk';">Statistique</a></li>
                    <li class="nav-item"><a class="nav-link active" href="/notification/index" style="font-family: 'Space Grotesk';">Mes Notifications</a></li>
                    <li class="nav-item"><a class="nav-link active" href="/faq/index" style="font-family: 'Space Grotesk';">FAQ</a></li>
                </ul>
            </div>
                <%
                    if (session.getAttribute("utilisateur") == null) { %>
                        <a class="navbar-brand d-flex align-items-center" href="/login"><span style="font-size: small;">login</span></a>
                    <% } else { %>
                        <a href="/utilisateur/deconnexion" class="logout-button navbar-brand d-flex align-items-center">
                            Deconnexion
                        </a>
                    <% } %>
                    

                    <a class="navbar-brand d-flex align-items-center" href="/notification/index"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-bell" style="color: var(--bs-navbar-active-color);">
                        <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"></path>
                    </svg></span></a>
                    
                    <a class="navbar-brand d-flex align-items-center" href="/recherche"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-search" style="color: var(--bs-navbar-active-color);">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg></span></a>
                    <% if (session.getAttribute("utilisateur") != null) { 
                        Utilisateur user = (Utilisateur) session.getAttribute("utilisateur"); %>
                        <a class="navbar-brand d-flex align-items-center" href="/utilisateur/profil">
                            <img style="width: 30px;height: 30px;border-radius: 100px;" src="/public/img/avatars/<%= user.getPhoto() %>">
                        </a>
                    <% } %>
        </div>
    </nav>

    <jsp:include page="<%= pages %>" />

    <!-- <footer class="bg-primary-gradient">
        <div class="container py-4 py-lg-5">
            <div class="row justify-content-center">
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Team</h3>
                    <ul class="list-unstyled">
                        <li style="color: var(--bs-body-color);">ANDRIAMITAHANTSOA Stefan Fiderana</li>
                        <li style="color: var(--bs-emphasis-color);">ANDRIANAHERISOA Jaela Matehotia</li>
                        <li style="color: var(--bs-body-color);">NAMBININTSOA Tahianjanahary Julien</li>
                        <li style="color: var(--bs-body-color);">RABENARIVO Ryan Lizka</li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Team</h3>
                    <ul class="list-unstyled">
                        <li style="color: var(--bs-emphasis-color);">RAKOTOMANJATO Nekena Prisila</li>
                        <li style="color: var(--bs-emphasis-color);">RAMANJATOMANITRA Ony Herilaza&nbsp;</li>
                        <li style="color: var(--bs-emphasis-color);">RAVONIHANITRARIVO Aina Tiana Manampisoa</li>
                        <li style="color: var(--bs-emphasis-color);">RANAIVOJAONA Rova Marc Nicolas</li>
                    </ul>
                </div>
                <div class="col-sm-4 col-md-3 text-center text-lg-start d-flex flex-column">
                    <h3 class="fs-6 fw-bold">Team</h3>
                    <ul class="list-unstyled">
                        <li style="color: var(--bs-body-color);">RASOLOFONJATOVO Hasimanarivo Loïc</li>
                        <li style="color: var(--bs-emphasis-color);">RASOLOMANDIMBY Nomenjanahary Thomis</li>
                        <li style="color: var(--bs-emphasis-color);">RAHARISON Christian Sanja</li>
                        <li style="color: var(--bs-body-color);">RAKOTOARIMANANA Tojo</li>
                    </ul>
                </div>
                <div class="col-lg-3 text-center text-lg-start d-flex flex-column align-items-center order-first align-items-lg-start order-lg-last"><img src="/public/img/rohy2.png" style="width: 200px;margin-left: 32px;margin-top: 34px;">
                    <div class="fw-bold d-flex align-items-center mb-2"></div>
                    <p class="text-muted" style="text-align: center;color: var(--bs-emphasis-color);font-size: 20px;font-weight: bold;"></p>
                </div>
            </div>
            <hr>
            <div class="text-muted d-flex justify-content-between align-items-center pt-3">
                <p class="mb-0">Rohy.mg © 2024&nbsp;</p>
                <ul class="list-inline mb-0">
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-facebook">
                            <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-twitter">
                            <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"></path>
                        </svg></li>
                    <li class="list-inline-item"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-instagram">
                            <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"></path>
                        </svg></li>
                </ul>
            </div>
        </div>
    </footer> -->
    <script src="/public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/public/js/bs-init.js"></script>
    <script src="/public/js/bold-and-bright.js"></script>
</body>
</html>