<%@ page import="itu.utilisateur.Utilisateur" %>
<%
    String pages = (String) request.getAttribute("page");
    pages = pages + ".jsp";
%>
<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Home - Brand</title>
    <link rel="stylesheet" href="/public/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/public/css/Splash.css">
    <link rel="stylesheet" href="/public/css/Header.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aleo&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Grotesk:300,400&amp;display=swap">
</head>

<body style="background: var(--bs-body-bg);">
    <nav class="navbar navbar-expand-md sticky-top navbar-shrink py-3 navbar-light" id="mainNav" style="margin-bottom: -1px;padding-bottom: 30px;padding-top: 0px;">
        <div class="container"><a href="/" style="margin-top: -32px;margin-bottom: -21px;margin-left: -33px;width: 150px;"><img class="img-fluid" src="/public/img/rohy1.png" ></a><a class="navbar-brand d-flex align-items-center" href="/"></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1" style="font-size: large;margin-bottom: -2px;font-family: Aleo, serif;">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"><a class="nav-link active" href="/" style="font-family: 'Space Grotesk';">Acceuil</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#" style="font-family: 'Space Grotesk';">Statistique</a></li>
                    <li class="nav-item"><a class="nav-link active" href="/notification/index" style="font-family: 'Space Grotesk';">Mes Notifications</a></li>
                    <li class="nav-item"><a class="nav-link active" href="#" style="font-family: 'Space Grotesk';">FAQ</a></li>
                </ul>
            </div>
                <%
                    if (session.getAttribute("utilisateur") == null) { %>
                        <a class="navbar-brand d-flex align-items-center" href="/login"><span style="font-size: small;">login</span></a>
                    <% } %>
                
                    <a class="navbar-brand d-flex align-items-center" href="/utilisateur/deconnexion"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-bell" style="color: var(--bs-navbar-active-color);">
                        <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"></path>
                    </svg></span></a>

                    <a class="navbar-brand d-flex align-items-center" href="/notification/index"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-bell" style="color: var(--bs-navbar-active-color);">
                        <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"></path>
                    </svg></span></a>
                    
                    <a class="navbar-brand d-flex align-items-center" href="/"><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-search" style="color: var(--bs-navbar-active-color);">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg></span></a>
                    <a class="navbar-brand d-flex align-items-center" href="/">
                    <img style="width: 30px;height: 30px;border-radius: 100px;" src="/public/img/branch.jpeg">
                    </a>
        </div>
    </nav>

    <jsp:include page="<%= pages %>" />

    
    <script src="/public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/public/js/bs-init.js"></script>
    <script src="/public/js/bold-and-bright.js"></script>
</body>

</html>