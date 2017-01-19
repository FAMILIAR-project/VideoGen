(function() {
    'use strict';

    angular
        .module('videoGenApp')
        .controller('VideoGenController', VideoGenController);

    VideoGenController.$inject = ['$scope','$state','$http'];

    function VideoGenController ($scope,$state,$http) {

        $scope.generate = function() {
            $http(
                {
                    method: 'GET',
                    url: '/api/videogen'
                }
            )
            .success(function(data) {
                $scope.m3u = data;

            })
            .error(function(data) {
                $scope.m3u = 'fail';
            });
        };
    }
})();
