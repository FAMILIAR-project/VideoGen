(function() {
    'use strict';

    angular
        .module('webappApp')
        .controller('GenerateDetailController', GenerateDetailController);

    GenerateDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Generate'];

    function GenerateDetailController($scope, $rootScope, $stateParams, previousState, entity, Generate) {
        var vm = this;

        vm.generate = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('webappApp:generateUpdate', function(event, result) {
            vm.generate = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
