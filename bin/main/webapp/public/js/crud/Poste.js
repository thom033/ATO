let PosteApp = angular.module("PosteApp",[]);

PosteApp.controller('tableController', function($scope, $http) {

    $http.get("/entreprise/liste")
    .then(function(response) {
        $scope.entreprises = response.data;
        console.log($scope);
    });

    $http.get("/diplome/liste")
    .then(function(response) {
        $scope.diplomes = response.data;
        console.log($scope);
    });

    $scope.initialize=function(){
        $scope.poste.titre="";
        $scope.poste.description="";
        $scope.poste.salaire="";
        $scope.poste.anneeExperience="";
        $scope.poste.anneeFormation="";
        $scope.poste.ageMin="";
        $scope.poste.ageMax="";
        $scope.poste.cout="";
        $scope.poste.diplome="";
        $scope.poste.entreprise="";
    }

    $scope.selectedOption = '';
    $scope.hiddenValue = '';
    $scope.updateHiddenValue = function() {
        const selectedOption = $scope.diplomes.find(diplome => diplome.id === $scope.poste.diplome);
        $scope.hiddenValue = selectedOption ? selectedOption.value : '';
    };

    $scope.submitForm = function() {
        for(let i=0;i<$scope.diplomes.length;i++){
            console.log($scope.poste.diplome+" "+$scope.diplomes[i].diplome);
            if($scope.poste.diplome==$scope.diplomes[i].diplome){
                $scope.poste.diplome=$scope.diplomes[i];
                break;
            }
            if(i==$scope.diplomes.length-1){
                alert("Diplomes non existantes");
                return;
            }
        }
        for(let i=0;i<$scope.entreprises.length;i++){
            if($scope.poste.entreprise==$scope.entreprises[i].entreprise){
                $scope.poste.entreprise=$scope.entreprises[i];
                break;
            }
            if(i==$scope.entreprises.length-1){
                alert("Entreprises non existantes");
                return;
            }
        }
        console.log("Sending data:", JSON.stringify($scope.poste)); // Afficher le JSON dans la console
        $http.post('/poste/insert', $scope.poste)
        .then(function(response) {
            $scope.initialize();
            alert("Inserted");
        }, function(error) {
            console.log(error);
            $scope.initialize();
        });
    };
});