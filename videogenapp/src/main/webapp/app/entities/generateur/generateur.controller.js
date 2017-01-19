(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurController', GenerateurController);

    GenerateurController.$inject = ['$scope', '$state', 'Generateur'];

    function GenerateurController ($scope, $state, Generateur) {
        var vm = this;
        var hide = true
	$scope.hide = hide;
        $scope.loadAll = loadAll;
        $scope.save = save;

      //  loadAll();

        function loadAll() {
           console.log("click generate")
            Generateur.query(function(result) {
                vm.generateurs = result;
            });
          window.location.reload()
        }

	function save() {
           console.log("click save")
          $scope.hide = !$scope.hide
        }
    }
})();
