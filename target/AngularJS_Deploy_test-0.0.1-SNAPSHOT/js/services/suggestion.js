app.factory('suggestions', [function(){
    var demoSuggestions = {
        posts: [
            {
                title: 'Lucky Food',
                upvotes: 15,
                comments: [
                    {suggestion:'hao chi'}
                    ],
            },
            {
                title: 'Tops Dinner',
                upvotes: 9,
                comments: [],
            },
            {
                title: 'China Town',
                upvotes: 7,
                comments: [],
            },
            {
                title: 'Burger King',
                upvotes: 3,
                comments: [],
            },
        ]
    };
    return demoSuggestions;



}]);


//
// app.factory('suggestions', ['$http', function($http) {
//     return $http.get('http://jsonplaceholder.typicode.com/users')
//         .success(function(data) {
//             return data;
//         })
//         .error(function(err) {
//             return err;
//         });
// }]);
