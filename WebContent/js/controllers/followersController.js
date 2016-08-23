app.controller('followersController',['$scope','users','$routeParams', function ($scope, users,$routeParams) {

    users.success(function(data){
        $scope.followers=data[$routeParams.userId];


    });






}]);