

app.controller('postController',['$scope','suggestions', function ($scope, suggestions) {
    $scope.posts = suggestions.posts;

    // suggestions.success(function(data){
    //     $scope.posts=data;
    //
    // });


    $scope.upVote=function(index){
        suggestions.posts[index].upvotes+=1
    };
}]);