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

        function generateRandom() {
            $http({
                method: 'GET',
                url: '/api/random'
            }).success(function(result){
                console.log("generateRandom");
                vm.alerts.push({ type: 'success', msg: 'Your video has been processed !' });
            }).error(function(error) {
                console.log("error");
            });
       }
    }
})();
