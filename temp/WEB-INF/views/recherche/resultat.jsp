<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Results - Job Search</title>
    <link rel="stylesheet" href="/public/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.reflowhq.com/v2/toolkit.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inter:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Aleo&amp;display=swap">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Space+Grotesk:300,400&amp;display=swap">
    <link rel="stylesheet" href="/public/css/Header.css">
    <link rel="stylesheet" href="/public/css/product.css">
    <link rel="stylesheet" href="/public/css/acceuil.css">
</head>

<body>
    <nav class="navbar navbar-expand-md sticky-top navbar-shrink py-3 navbar-light" id="mainNav" style="margin-bottom: -1px;padding-bottom: 30px;margin-top: -2px;padding-top: 0px;">
        <div class="container"><img src="/public/img/Brand%20100-33.png" style="margin-top: -32px;margin-bottom: -21px;"><a class="navbar-brand d-flex align-items-center" href="/"></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1" style="font-size: large;margin-bottom: -2px;font-family: Aleo, serif;">
                <ul class="navbar-nav mx-auto">
                    <li class="nav-item"><a class="nav-link" href="index.html" style="font-family: 'Space Grotesk';">Acceuil</a></li>
                    <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">Statistique</a></li>
                    <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">Mes Notifications</a></li>
                    <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">ChatBot</a></li>
                </ul>
            </div><a class="navbar-brand d-flex align-items-center" href="/"><span style="font-size: small;">Login</span><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-bell" style="color: var(--bs-navbar-active-color);">
                        <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"></path>
                    </svg></span><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-person-circle" style="color: var(--bs-navbar-active-color);">
                        <path d="M11 10a2 2 0 1 0-2-2 2 2 0 0 0 2 2zm-6 0a2 2 0 1 0-2-2 2 2 0 0 0 2 2zm4.5-10a7 7 0 1 0 7 7 7 7 0 0 0-7-7zm0 1a6 6 0 1 1-6 6 6 6 0 0 1 6-6z"></path>
                    </svg></span></a>
        </div>
    </nav>
    <header class="bg-light text-dark">
        <div class="container text-center">
            <h1>Résultats de la recherche</h1>
        </div>
    </header>
    <main class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>Résultats:</h2>
                <div class="list-group">
                    <div class="alert alert-info" th:if="${results.size()} == 0">
                        Aucun résultat trouvé.
                    </div>
                    <div th:each="result : ${results}" class="list-group-item list-group-item-action flex-column align-items-start">
                        <h5 class="mb-1" th:text="${result['poste_titre']}">Titre du Poste</h5>
                        <p class="mb-1"><strong>Diplôme:</strong> <span th:text="${result['id_diplome']}">Diplôme</span></p>
                        <p class="mb-1"><strong>Secteur:</strong> <span th:text="${result['id_secteur']}">Secteur</span></p>
                        <p class="mb-1"><strong>Compétences:</strong> <span th:text="${result['competence_requise']}">Compétences</span></p>
                        <p class="mb-1"><strong>Age Requis:</strong> <span th:text="${result['age_requise']}">Age</span></p>
                        <p class="mb-1"><strong>Salaire:</strong> <span th:text="${result['poste_salaire']}">Salaire</span></p>
                        <p class="mb-1"><strong>Distance:</strong> <span th:text="${result['distance']}">Distance</span></p>
                        <p class="mb-1"><strong>Années d'Expérience:</strong> <span th:text="${result['nbr_annee_experience']}">Expérience</span></p>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer class="text-white bg-dark">
        <div class="container text-center">
            <p>© 2023 Your Company. All rights reserved.</p>
        </div>
    </footer>
    <script src="/public/bootstrap/js/bootstrap.min.js"></script>
    <script src="/public/js/bs-init.js"></script>
</body>

</html>
