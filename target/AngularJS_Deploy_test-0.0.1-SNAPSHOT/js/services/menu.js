
app.factory('menu', ['$http','$resource', function($http,$resource) {
    $http.defaults.useXDomain = true;

    // return $http.get('http://dinnermenu.us-east-1.elasticbeanstalk.com/app/listSugggestion')
    //     .success(function(data) {
    //         return data;
    //     });



    return $resource("http://dinnermenu.us-east-1.elasticbeanstalk.com/app/listSugggestion");

}]);


