app.controller('usersController',['$scope','users','$http','$routeParams',function ($scope, users,$http) {

    users.success(function(data){
        $scope.users=data;

    });


    $scope.count = function(url,index){

        $scope.showCnt = {};
        $http.get(url).success(function(followers){

            $scope.length=followers.length;
        });
        $scope.showCnt[index] = true;
    };




}]);