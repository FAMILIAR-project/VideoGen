(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurDetailController', GenerateurDetailController);

    GenerateurDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Generateur'];

    function GenerateurDetailController($scope, $rootScope, $stateParams, previousState, entity, Generateur) {
        var vm = this;

        vm.generateur = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('videoGenApplicationApp:generateurUpdate', function(event, result) {
            vm.generateur = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
