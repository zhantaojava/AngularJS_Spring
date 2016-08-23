var app = angular.module('SuggestionBox', ['ngRoute']);



app.config(function ($routeProvider) {
     $routeProvider
         .when('/', {
             controller: 'postController',
             templateUrl: 'views/home.html'
         })
         .when('/suggestion/:postId', {
             controller: 'commentController',
             templateUrl: 'views/comment.html'
         })

         .otherwise({
             redirectTo: '/'
         });
 });