app.controller('menuController',['$scope','menu','$http','$routeParams',function ($scope, menu,$http) {

    // menu.success(function(data){
    //     $scope.menus=data;
    //
    // });




    menu.query(function(data) {
        $scope.menus = data;
    });






}]);