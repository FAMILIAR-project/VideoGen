(function() {
    'use strict';

    angular
        .module('webappApp')
        .controller('GenerateController', GenerateController);

    GenerateController.$inject = ['$scope', '$http', '$state'];

    function GenerateController ($scope,$http, $state) {
        $scope.alerts = [];

        function generateRandom() {
            $http({
                method: 'GET',
                url: '/random'
            }).success(function(result){
                console.log("generateRandom");
                $scope.alerts.push({ type: 'success', msg: 'Your video has been processed !' });
            }).error(function(error) {
                console.log("error");
            });
       }
    }
})();
