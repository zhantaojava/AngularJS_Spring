var app = angular.module('SuggestionBox', ['ngRoute','ngResource']);



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
         .when('/followers', {
             controller: 'usersController',
             templateUrl: 'views/users.html'
         })
         .when('/followers/:userId', {
             controller: 'followersController',
             templateUrl: 'views/followers.html'
         })
         .when('/menu',{
             controller:'menuController',
             templateUrl: 'views/menu.html'
         })

         .otherwise({
             redirectTo: '/'
         });
 });