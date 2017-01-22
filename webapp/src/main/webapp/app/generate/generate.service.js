(function() {
    'use strict';
    angular
        .module('webappApp')
        .factory('Generate', Generate);

    Generate.$inject = ['$resource'];

    function Generate ($resource) {
        var resourceUrl =  'api/generates/:id';

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
