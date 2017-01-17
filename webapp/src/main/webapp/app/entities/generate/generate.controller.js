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
                vm.videos = result;
                console.log("generateRandom");

                vm.isGenerated = true;
            }).error(function(error) {
                console.log("error");
            });
       }
    }
})();
