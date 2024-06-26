<%@ page contentType='text/html;charset=UTF-8' language='java' %>
<%@ page import="itu.utilisateur.Utilisateur"%>
<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
%>
<link rel="stylesheet" href="/public/css/faq.css">
<div class="container mt-4">
<div class="row" ng-app="frontApp" ng-controller="faqController">
    <div class="col-md-6">
        <div class="profile">
            <img src="/public/img/avatars/<%= utilisateur.getPhoto() %>" alt="Avatar">
            <div class="partie">
                <h5 class="name"><%= utilisateur.getNom() %> <%= utilisateur.getPrenom() %></h5>
                <a href="" class="dots"><span ><svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-three-dots" viewBox="0 0 16 16">
                    <path d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3m5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3"/>
                    </svg></span></a>
            </div>
        </div>
        <div class="questions" >
            <div class="icon-text">
                <span class="icon-text mark">
                    <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-patch-question" viewBox="0 0 16 16">
                        <path d="M8.05 9.6c.336 0 .504-.24.554-.627.04-.534.198-.815.847-1.26.673-.475 1.049-1.09 1.049-1.986 0-1.325-.92-2.227-2.262-2.227-1.02 0-1.792.492-2.1 1.29A1.7 1.7 0 0 0 6 5.48c0 .393.203.64.545.64.272 0 .455-.147.564-.51.158-.592.525-.915 1.074-.915.61 0 1.03.446 1.03 1.084 0 .563-.208.885-.822 1.325-.619.433-.926.914-.926 1.64v.111c0 .428.208.745.585.745"/>
                        <path d="m10.273 2.513-.921-.944.715-.698.622.637.89-.011a2.89 2.89 0 0 1 2.924 2.924l-.01.89.636.622a2.89 2.89 0 0 1 0 4.134l-.637.622.011.89a2.89 2.89 0 0 1-2.924 2.924l-.89-.01-.622.636a2.89 2.89 0 0 1-4.134 0l-.622-.637-.89.011a2.89 2.89 0 0 1-2.924-2.924l.01-.89-.636-.622a2.89 2.89 0 0 1 0-4.134l.637-.622-.011-.89a2.89 2.89 0 0 1 2.924-2.924l.89.01.622-.636a2.89 2.89 0 0 1 4.134 0l-.715.698a1.89 1.89 0 0 0-2.704 0l-.92.944-1.32-.016a1.89 1.89 0 0 0-1.911 1.912l.016 1.318-.944.921a1.89 1.89 0 0 0 0 2.704l.944.92-.016 1.32a1.89 1.89 0 0 0 1.912 1.911l1.318-.016.921.944a1.89 1.89 0 0 0 2.704 0l.92-.944 1.32.016a1.89 1.89 0 0 0 1.911-1.912l-.016-1.318.944-.921a1.89 1.89 0 0 0 0-2.704l-.944-.92.016-1.32a1.89 1.89 0 0 0-1.912-1.911z"/>
                        <path d="M7.001 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0"/>
                    </svg>
                </span>
                <h2 ><strong>Questions</strong>
                <br>
                <p class="sous-section">Veuillez choisir parmi les questions disponibles</p>
                </h2>
                <br>
                <span class="icon-text bulb">
                <svg xmlns="http://www.w3.org/2000/svg" width="50" height="50" fill="currentColor" class="bi bi-lightbulb" viewBox="0 0 16 16">
                    <path d="M2 6a6 6 0 1 1 10.174 4.31c-.203.196-.359.4-.453.619l-.762 1.769A.5.5 0 0 1 10.5 13a.5.5 0 0 1 0 1 .5.5 0 0 1 0 1l-.224.447a1 1 0 0 1-.894.553H6.618a1 1 0 0 1-.894-.553L5.5 15a.5.5 0 0 1 0-1 .5.5 0 0 1 0-1 .5.5 0 0 1-.46-.302l-.761-1.77a2 2 0 0 0-.453-.618A5.98 5.98 0 0 1 2 6m6-5a5 5 0 0 0-3.479 8.592c.263.254.514.564.676.941L5.83 12h4.342l.632-1.467c.162-.377.413-.687.676-.941A5 5 0 0 0 8 1"/>
                </svg>
                </span>
            </div>  

            <div class="questions-container">
                <button ng-repeat="fanontaniana in questions" ng-click="poserQuestion(fanontaniana.id)" class="btn btn-light btn-question">
                    {{ fanontaniana.question }}
                </button>
            </div>
                    
            <button class="btn btn-light btn-custom">
                <span class="bi-people" style="display: none">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" class="bi bi-people" viewBox="0 0 16 16">
                        <path d="M15 14s1 0 1-1-1-4-5-4-5 3-5 4 1 1 1 1zm-7.978-1L7 12.996c.001-.264.167-1.03.76-1.72C8.312 10.629 9.282 10 11 10c1.717 0 2.687.63 3.24 1.276.593.69.758 1.457.76 1.72l-.008.002-.014.002zM11 7a2 2 0 1 0 0-4 2 2 0 0 0 0 4m3-2a3 3 0 1 1-6 0 3 3 0 0 1 6 0M6.936 9.28a6 6 0 0 0-1.23-.247A7 7 0 0 0 5 9c-4 0-5 3-5 4q0 1 1 1h4.216A2.24 2.24 0 0 1 5 13c0-1.01.377-2.042 1.09-2.904.243-.294.526-.569.846-.816M4.92 10A5.5 5.5 0 0 0 4 13H1c0-.26.164-1.03.76-1.724.545-.636 1.492-1.256 3.16-1.275ZM1.5 5.5a3 3 0 1 1 6 0 3 3 0 0 1-6 0m3-2a2 2 0 1 0 0 4 2 2 0 0 0 0-4"/>
                    </svg>
                </span>
                <div>
                    <strong style="display: none">Aucune question ne vous correspond ?</strong><br>
                    <p style="display: none" >Discuter avec notre staff</p>
                </div>
            </button>
        </div>
    </div>
    <div class="col-md-6">
        <div class="container d-flex justify-content-center align-items-center chatbox-container">
            <div class="chat-container">
                <div class="chat-header">
                    <div class="d-flex align-items-center justify-content-start">
                        <span class="icon-albert">   
                            <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="30" height="30"><path d="m21,23c0,.553-.448,1-1,1s-1-.447-1-1c0-2.206-1.794-4-4-4h-6c-2.206,0-4,1.794-4,4,0,.553-.448,1-1,1s-1-.447-1-1c0-3.309,2.691-6,6-6h6c3.309,0,6,2.691,6,6Zm1-15.5v2c0,.827-.673,1.5-1.5,1.5h-.5c0,2.206-1.794,4-4,4h-8c-2.206,0-4-1.794-4-4h-.5c-.827,0-1.5-.673-1.5-1.5v-2c0-.827.673-1.5,1.5-1.5h.5c0-2.206,1.794-4,4-4h3v-1c0-.553.448-1,1-1s1,.447,1,1v1h3c2.206,0,4,1.794,4,4h.5c.827,0,1.5.673,1.5,1.5Zm-4-1.5c0-1.103-.897-2-2-2h-8c-1.103,0-2,.897-2,2v5c0,1.103.897,2,2,2h8c1.103,0,2-.897,2-2v-5Zm-8.5,1c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Zm5,0c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Z"/></svg>
                        </span>
                        <div>
                            <strong>Albert</strong>
                            <p>Chat Automatique</p>
                        </div>
                    </div>
                </div>
                                        
                <div class="chat-body">
                    <div class="chat-message albert">
                        <div class="d-flex align-items-center justify-content-start">
                            <span class="icon-albert-message">   
                                <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="20" height="20">
                                    <path d="m21,23c0,.553-.448,1-1,1s-1-.447-1-1c0-2.206-1.794-4-4-4h-6c-2.206,0-4,1.794-4,4,0,.553-.448,1-1,1s-1-.447-1-1c0-3.309,2.691-6,6-6h6c3.309,0,6,2.691,6,6Zm1-15.5v2c0,.827-.673,1.5-1.5,1.5h-.5c0,2.206-1.794,4-4,4h-8c-2.206,0-4-1.794-4-4h-.5c-.827,0-1.5-.673-1.5-1.5v-2c0-.827.673-1.5,1.5-1.5h.5c0-2.206,1.794-4,4-4h3v-1c0-.553.448-1,1-1s1,.447,1,1v1h3c2.206,0,4,1.794,4,4h.5c.827,0,1.5.673,1.5,1.5Zm-4-1.5c0-1.103-.897-2-2-2h-8c-1.103,0-2,.897-2,2v5c0,1.103.897,2,2,2h8c1.103,0,2-.897,2-2v-5Zm-8.5,1c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Zm5,0c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Z"/>
                                </svg>
                            </span>
                            <div class="message-content">
                                <p>Albert</p>
                                <h4>Bienvenu sur l'agence de recrutement ATO, n'hésitez pas à me poser des questions.</h4>
                            </div>
                        </div>
                    </div>   
                    
                    <div ng-repeat="fanontaniana in historiqueQuestions" id="question-{{fanontaniana.id}}">
                        <div class="chat-message client">
                            <div class="d-flex align-items-center justify-content-start">
                                <span class="icon-client-message">
                                    <img src="/public/img/avatars/{{ fanontaniana.utilisateur.photo }}" alt="Avatar">
                                </span>
                                <div class="message-content">
                                    <p>{{ fanontaniana.utilisateur.nom }} {{ fanontaniana.utilisateur.prenom }} </p>
                                    <h4>{{ fanontaniana.question.question }}</h4>
                                </div>
                            </div>
                        </div>
                        <div class="chat-message albert">
                            <div class="d-flex align-items-center justify-content-start">
                                <span class="icon-albert-message">   
                                    <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="20" height="20">
                                        <path d="m21,23c0,.553-.448,1-1,1s-1-.447-1-1c0-2.206-1.794-4-4-4h-6c-2.206,0-4,1.794-4,4,0,.553-.448,1-1,1s-1-.447-1-1c0-3.309,2.691-6,6-6h6c3.309,0,6,2.691,6,6Zm1-15.5v2c0,.827-.673,1.5-1.5,1.5h-.5c0,2.206-1.794,4-4,4h-8c-2.206,0-4-1.794-4-4h-.5c-.827,0-1.5-.673-1.5-1.5v-2c0-.827.673-1.5,1.5-1.5h.5c0-2.206,1.794-4,4-4h3v-1c0-.553.448-1,1-1s1,.447,1,1v1h3c2.206,0,4,1.794,4,4h.5c.827,0,1.5.673,1.5,1.5Zm-4-1.5c0-1.103-.897-2-2-2h-8c-1.103,0-2,.897-2,2v5c0,1.103.897,2,2,2h8c1.103,0,2-.897,2-2v-5Zm-8.5,1c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Zm5,0c-.828,0-1.5.672-1.5,1.5s.672,1.5,1.5,1.5,1.5-.672,1.5-1.5-.672-1.5-1.5-1.5Z"/>
                                    </svg>
                                </span>
                                <div class="message-content">
                                    <p>Albert</p>
                                    <h4>{{ fanontaniana.question.reponse.reponse }}</h4>
                                </div>
                            </div>
                        </div>
                    </div>    
                </div>
                <div class="chat-footer d-flex align-items-center">
                    <input type="text" placeholder="Écrivez un message ..." style="display: none">
                    <button >
                        <svg style="color: #f1f1f1" xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                            <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576zm6.787-8.201L1.591 6.602l4.339 2.76z"/>
                            </svg>
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script src="/public/js/angular.min.js"></script>
<script src="/public/js/client/frontApp.js"></script>