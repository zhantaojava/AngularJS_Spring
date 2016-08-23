app.factory('suggestions', [function(){
    var demoSuggestions = {
        posts: [
            {
                title: 'Lucky Food',
                upvotes: 0,
                comments: [
                    {suggestion:'not bad'}
                    ],
            },
            {
                title: 'Hunan Taste',
                upvotes: 2,
                comments: [],
            },
            {
                title: 'Taipei Noodle House',
                upvotes: 7,
                comments: [],
            },
            {
                title: 'V-YAN',
                upvotes: 66,
                comments: [],
            },
        ]
    };
    return demoSuggestions;
}]);