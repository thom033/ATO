let ReponseApp = angular.module("ReponseApp",[]);

ReponseApp.controller('tableController', function($scope, $http) {

    var buttonSubmit=document.getElementById("buttonSubmit");
    $http.get("/reponse/liste")
    .then(function(response) {
        $scope.questions = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.question.id=0;
        $scope.question.question="";
        $scope.question.reponse.reponse="";
        buttonSubmit.innerText="Ajouter"
    }

    $scope.modify = function(idQuestion){
        $http.get("/reponse/information?idQuestion="+idQuestion)
        .then(function(response) {
            $scope.question = response.data;
            buttonSubmit.innerText="Modifier"
            console.log($scope.reponse);
        });
    }

    $scope.delete = function(idReponse){
        $http.get("/reponse/delete?idQuestion="+idReponse)
        .then(function(response) {
            $scope.questions = response.data;
        });
    }

    $scope.submitForm = function() {
        if(buttonSubmit.innerText=="Modifier"){
            $scope.updateForm();
        }
        else{
            $scope.insertForm();
        }
    };

    $scope.insertForm=function(){
        console.log("Sending data:", JSON.stringify($scope.question)); // Afficher le JSON dans la console
        $http.post('/reponse/insert', $scope.question)
        .then(function(response) {
            $scope.questions = response.data;
            console.log($scope.questions);
            $scope.initialize();
            document.getElementById("formulaire").setAttribute("ng-submit", "submitForm()");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    }

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.question)); // Afficher le JSON dans la console
        $http.post('/reponse/update', $scope.question)
        .then(function(response) {
            $scope.questions = response.data;
            console.log($scope.questions);
            $scope.initialize();
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.filterReponse = function(question) {
        var search = $scope.search;
        if (!search || (!search.question && !search.reponse)) {
          return true; // Afficher toutes les personnes si rien n'est saisi
        }
        // Filtrer par nom et prénom
        var matchQuestion = !search.question || question.question.toLowerCase().includes(search.question.toLowerCase());
        var matchReponse = !search.reponse || question.reponse.reponse.toLowerCase().includes(search.reponse.toLowerCase());
        return matchQuestion && matchReponse;
      };
});