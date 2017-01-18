(function() {
    'use strict';

    angular
        .module('webappApp')
        .controller('GenerateController', GenerateController);

    GenerateController.$inject = ['$scope', '$state', '$http', 'Generate'];

    function GenerateController ($scope, $state, $http, Generate) {
        var vm = this;

        vm.generateRandom = generateRandom;

        vm.alerts = [];

        vm.videos = [];

        function generateRandom() {
            $http({
                method: 'GET',
                url: '/api/random'
            }).success(function(result) {
                console.log(result);
                vm.videos = [];

                result.forEach(function(element) {
                    console.log(element);
                    vm.videos.push({
                        sources: [{
                            type: 'video/mp4',
                            src:  element
                        }]
                    });
                });

                flowplayer('#jsplaylist', {
                   rtmp: "rtmp://s3b78u0kbtx79q.cloudfront.net/cfx/st",
                   playlist: vm.videos
                });

                console.log(vm.videos);
                console.log("generateRandom");

                vm.isGenerated = true;
            }).error(function(error) {
                console.log("error");
            });
       }
    }
})();
