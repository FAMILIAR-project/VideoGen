(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurController', GenerateurController);

    GenerateurController.$inject = ['$scope', '$state', 'Generateur'];

    function GenerateurController ($scope, $state, Generateur) {
        var vm = this;
        
        vm.generateurs = [];

        loadAll();

        function loadAll() {
            Generateur.query(function(result) {
                vm.generateurs = result;
            });
        }
    }
})();
