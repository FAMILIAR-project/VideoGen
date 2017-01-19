(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurController', GenerateurController);

    GenerateurController.$inject = ['$scope', '$state', 'Generateur'];

    function GenerateurController ($scope, $state, Generateur) {
        var vm = this;
        
        $scope.loadAll = loadAll;

      //  loadAll();

        function loadAll() {
           console.log("click generate")
            Generateur.query(function(result) {
                vm.generateurs = result;
            });
          window.location.reload()
        }
    }
})();
