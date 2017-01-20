(function() {
    'use strict';

    angular
        .module('videoGenApp')
        .factory('VideogenService', VideogenService);

    VideogenService.$inject = ['$resource', '$q'];

    function VideogenService($resource, $q) {
        var service = {
            getVideogen: getVideogen,
            generatePlaylist: generatePlaylist,
            generatePlaylistFromUserChoices: generatePlaylistFromUserChoices,
            generateGif: generateGif
        };
        return service;

        function getVideogen() {
            var deferred = $q.defer();
            getVideos("getVideogen").get().$promise
                .then(function(data) {
                    deferred.resolve(data);
                })

            return deferred.promise;
        }

        function generatePlaylist(text, position, data) {
            console.log("text: " + text + " position: " + position + "data: " + data)
            var deferred = $q.defer();
            getVideos("generatePlaylist", text, position, data).get().$promise
                .then(function(data) {
                    deferred.resolve(data);
                })

            return deferred.promise;
        }

        function generatePlaylistFromUserChoices(data, text, position, data2) {
            var deferred = $q.defer();
            getUserPlaylist(data, text, position, data2).get().$promise
                .then(function(data) {
                    deferred.resolve(data);
                })

            return deferred.promise;
        }

        function generateGif(data) {
            var deferred = $q.defer();
            getGifGeneration(data).get().$promise
                .then(function(data) {
                    deferred.resolve(data);
                })

            return deferred.promise;
        }

        function getVideos(url, text, position, data) {
            var service = $resource('api/videogen/' + url, {}, {
                'get': {
                    method: 'GET',
                    params: {
                        "text": text,
                        "position": position,
                        "data": data
                    },
                    isArray: false,
                    interceptor: {
                        response: function(response) {
                            // expose response
                            console.log("re")
                            return response;
                        },
                        responseError: function(rejection) {
                            return $q.reject(rejection);
                        }
                    }
                }
            });

            return service;
        }

        function getGifGeneration(data) {
            var service = $resource('api/videogen/generateGif', {}, {
                'get': {
                    method: 'GET',
                    params: {
                        "data": data,
                    },
                    isArray: false,
                    interceptor: {
                        response: function(response) {
                            // expose response
                            console.log("re")
                            return response;
                        },
                        responseError: function(rejection) {
                            return $q.reject(rejection);
                        }
                    }
                }
            });

            return service;
        }

        function getUserPlaylist(data, text, position, data2) {
            var service = $resource('api/videogen/generatePlaylistFromUserChoices', {}, {
                'get': {
                    method: 'GET',
                    params: {
                        "data": data,
                        "text": text,
                        "position": position,
                        "data2": data2
                    },
                    isArray: false,
                    interceptor: {
                        response: function(response) {
                            // expose response
                            console.log("re")
                            return response;
                        },
                        responseError: function(rejection) {
                            return $q.reject(rejection);
                        }
                    }
                }
            });

            return service;
        }
    }
})();
