app.controller('commentController2',['$scope','menu','$routeParams', function ($scope, menu,$routeParams) {
    //$scope.comments = suggestions.posts[$routeParams.postId].comments;

    menu.query(function(data) {
        $scope.comments = data[$routeParams.sugId].comments;
    });

}]);