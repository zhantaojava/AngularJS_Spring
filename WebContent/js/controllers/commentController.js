

app.controller('commentController',['$scope','suggestions','$routeParams', function ($scope, suggestions,$routeParams) {
    $scope.comments = suggestions.posts[$routeParams.postId].comments;

    $scope.comment=function () {
        //alert($scope.newSuggestion);

        suggestions.posts[$routeParams.postId].comments.push({
            suggestion:$scope.newSuggestion

        });
          $scope.newSuggestion='';
    };

}]);