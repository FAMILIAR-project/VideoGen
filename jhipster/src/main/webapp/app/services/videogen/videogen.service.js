(function() {
    'use strict';

    angular
        .module('videogenApp')
        .factory('VideoGen', VideoGen);

    VideoGen.$inject = ['$resource'];

    function VideoGen ($resource) {
        var service = $resource('api/videogen/:action',{},{
            'regenerate': { method: 'POST', params:{action:"regenerate"}, isArray:false }
        });

        return service;
    }
})();
