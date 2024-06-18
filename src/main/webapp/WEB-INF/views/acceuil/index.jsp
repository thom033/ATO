<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="itu.Compatibilite.ResultAcceuil" %>
<%
    List<ResultAcceuil> p = (List<ResultAcceuil>) request.getAttribute("data");
%>
<link rel="stylesheet" href="/public/css/acceuil.css">

<section class="py-5" style="padding-top: 1rem!important;padding-bottom: 1rem!important;">
        <div class="container py-5 text-center">
            <div class="row mb-4 mb-lg-5">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h2 class="fw-bold" >Pour vous</h2>
                    <p class="text-muted">Les suggestions se basent sur les informations que vous avez inséré dans votre profil. <a href="utilisateur/profil" class="see-more">Aller voir</a></p>
                </div>
            </div>
            <div class="d-flex justify-content-center">
                <button class="btn btn-dark me-2" type="button">Best Point</button>
                <button class="btn btn-light" type="button">Compatibilite</button>
            </div>
        </div>
    </section>

<div class="container py-5" style="padding-top: 1rem!important;">
    <div class="row">
        <%
            for (int i = 0; i < p.size(); i++) {
                Long id = (long) p.get(i).getIdPoste();
                %>
                <div class="col-md-3 col-sm-6 mb-4 py-2" >
                    <div class="card shadow-sm h-100 nicolas-card-1" >
                <div class="card-body nicolas-card">
                    <div class="d-flex justify-content-between align-items-center top-card-nicolas">
                        <h4 class="card-title box_name mb-0" ><%= p.get(i).getEntrepriseNom()%></h4>
                        <h4 class="percent mb-0 nicolas-compatibilite"><a href="/compatibility-poste/<%= id %>" ><%= p.get(i).getPtsTotal() %>%</a></h4>
                    </div>
                    <div class="img_box flex-grow-1">
                        <img src="/public/img/products/4.jpg" class="img-fluid" alt="">
                    </div>
                    <h3 class="mt-3 nicolas-nom-travail"><%= p.get(i).getPosteTitre() %></h3>
                    <div class="d-flex justify-content-between align-items-center">
                        <p class="mb-2 nicolas-sous-titre"><%= p.get(i).getPosteSalaire()%> Ar</p>
                        <button class="btn-nicolas"><a href="/poste/details?idPoste=<%= id %>" >Visiter</a></button>
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
