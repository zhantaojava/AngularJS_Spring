

app.controller('postController',['$scope','suggestions', function ($scope, suggestions) {
    $scope.posts = suggestions.posts;


    $scope.upVote=function(index){
        suggestions.posts[index].upvotes+=1
    };
}]);