/**
 * Created by suzhantao on 8/18/16.
 */
app.factory('users', ['$http', function($http) {
    return $http.get('https://api.github.com/users/defunkt/followers')
        .success(function(data) {
            return data;
        });

}]);
