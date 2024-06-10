<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page 
import="itu.Compatibilite.PosteDetails"
%>
<%
    double[] result = (double[]) request.getAttribute("compatibility");
    List<PosteDetails> p = (List<PosteDetails>) request.getAttribute("posteDetails");
%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Products - Brand</title>
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
    <div class="container"><img src="/public/img/Brand%20100-33.png" style="margin-top: -32px;margin-bottom: -21px;"><a class="navbar-brand d-flex align-items-ce/public"></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1" style="font-size: large;margin-bottom: -2px;font-family: Aleo, serif;">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item"><a class="nav-link" href="index.html" style="font-family: 'Space Grotesk';">Acceuil</a></li>
                <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">Statistique</a></li>
                <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">Mes Notifications</a></li>
                <li class="nav-item"><a class="nav-link" href="#" style="font-family: 'Space Grotesk';">ChatBot</a></li>
            </ul>
        </div><a class="navbar-brand d-flex align-items-cepublic"><span style="font-size: small;">Login</span><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);margin-left: 10px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-bell" style="color: var(--bs-navbar-active-color);">
                        <path d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z"></path>
                    </svg></span><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="background: var(--bs-secondary-bg);"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-search" style="color: var(--bs-navbar-active-color);">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"></path>
                    </svg></span><span class="bs-icon-sm bs-icon-circle bs-icon-primary shadow d-flex justify-content-center align-items-center me-2 bs-icon" style="margin-left: 0px;"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-person-bounding-box">
                        <path d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1h-3zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5zM.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5zm15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5z"></path>
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"></path>
                    </svg></span></a>
    </div>
</nav>

<section class="py-5">
    <form action="/compatibility" method="post">
        <!-- Ajoutez ici les champs nécessaires pour soumettre les détails de PosteDetails -->
        <button type="submit">Calculer la compatibilité</button>
    </form>
    <div class="container py-5 text-center">
        <div class="row mb-4 mb-lg-5">
            <div class="col-md-8 col-xl-6 text-center mx-auto">
                <h2 class="fw-bold" >Pour vous</h2>
                <p class="text-muted">Les suggestions se basent sur les informations que vous avez inséré dans votre profil</p>
            </div>
        </div>
        <div class="d-flex justify-content-center">
            <button class="btn btn-light me-2" type="button">Best Point</button>
            <button class="btn btn-light" type="button">Compatibilite</button>
        </div>
    </div>
</section>

<div class="container py-5">
    <div class="row">
        <%
            for (int i = 0; i < result.length; i++) {
                PosteDetails pd = p.get(i);
                %>
        <div class="col-md-3 col-sm-6 mb-4" >
            <div class="card shadow-sm h-100 nicolas-card-1" >
                <div class="card-body nicolas-card">
                    <div class="d-flex justify-content-between align-items-center top-card-nicolas">
                        <h4 class="card-title box_name mb-0" ><%= pd.getPosteTitre() %></h4>
                        <h4 class="percent mb-0 nicolas-compatibilite" ><%= result[i]%> %</h4>
                    </div>
                    <div class="img_box flex-grow-1">
                        <img src="/public/img/products/4.jpg" class="img-fluid" alt="">
                    </div>
                    <h3 class="mt-3 nicolas-nom-travail">Expert comptable</h3>
                    <div class="d-flex justify-content-between align-items-center mt-3">
                        <p class="mb-2 nicolas-sous-titre">800 Ar</p>
                        <button class="btn btn-light me-2">Visiter</button>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>
        <nav aria-label="Pagination">
            <ul class="pagination justify-content-center mt-4">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&laquo;</a>
                </li>
                <li class="page-item active" aria-current="page">
                    <a class="page-link" href="#">1</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">2</a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="#">3</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">&raquo;</a>
                </li>
            </ul>
        </nav>
    </div>
</div>

<script src="/public/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.reflowhq.com/v2/toolkit.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
