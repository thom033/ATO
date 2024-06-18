let DiplomeUtilisateurApp = angular.module("DiplomeUtilisateurApp",[]);

DiplomeUtilisateurApp.controller('tableController', function($scope, $http) {

    $scope.utilisateur={};
    $scope.diplomes=[];
    $scope.utilisateur.diplomes=[];
    $scope.recherche="";
    $http.get("/diplomeUtilisateur/liste")
    .then(function(response) {
        $scope.diplomes = response.data;
        $scope.retirerDoublon();
    });

    $http.get("/utilisateur/connected")
    .then(function(response) {
        $scope.utilisateur = response.data;
        $scope.retirerDoublon();
    },function(error){
        console.log("Erreur sur l'utilisateur");
    });

    $scope.initialize=function(){
        $scope.diplomeUtilisateur.diplome.diplome="";
        $scope.diplomeUtilisateur.diplome.niveau=0;
    }

    $scope.submitForm = function() {
        $scope.updateForm();
    };

    $scope.updateForm = function() {
        console.log("Sending data:", JSON.stringify($scope.utilisateur)); // Afficher le JSON dans la console
        $http.post('/utilisateur/update', $scope.utilisateur)
        .then(function(response) {
            console.log("updated");
        }, function(error) {
            $scope.error = error.error || "Une erreur est survenue.";
        });
    };

    $scope.getNiveau=function(number){
        if(number==1){
            return "";
        }
        if(number==2){
            return "Licence";
        }
        if(number==3){
            return "Master";
        }
        else{
            return "Doctorat"
        }
    }

    $scope.ajouter=function(diplome){
        console.log(diplome.id);
        $scope.diplomes = $scope.diplomes.filter(obj => obj.id !== diplome.id);
        $scope.utilisateur.diplomes.push(diplome);
    }

    $scope.retirer=function(diplome){
        $scope.utilisateur.diplomes = $scope.utilisateur.diplomes.filter(obj => obj.id !== diplome.id);
        $scope.diplomes.push(diplome);
    }

    $scope.delete=function(array,objs){
        array = array.filter(obj => obj.id !== objs.id);
    }

    $scope.retirerDoublon=function(){
        for(let i=0;i<$scope.utilisateur.diplomes.length;i++){
            for(let e=0;e<$scope.diplomes.length;e++){
                if($scope.utilisateur.diplomes[i].id==$scope.diplomes[e].id){
                    $scope.diplomes = $scope.diplomes.filter(obj => obj.id !== $scope.utilisateur.diplomes[i].id);
                }
            }
        }
    }
});