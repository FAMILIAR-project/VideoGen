(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurDeleteController',GenerateurDeleteController);

    GenerateurDeleteController.$inject = ['$uibModalInstance', 'entity', 'Generateur'];

    function GenerateurDeleteController($uibModalInstance, entity, Generateur) {
        var vm = this;

        vm.generateur = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        
        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Generateur.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
