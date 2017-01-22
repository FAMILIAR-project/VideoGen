(function() {
    'use strict';
    angular
        .module('videoGenApplicationApp')
        .factory('Generateur', Generateur);

    Generateur.$inject = ['$resource'];

    function Generateur ($resource) {
        var resourceUrl =  'api/generateurs/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
