(function() {
    'use strict';

    angular
        .module('webappApp')
        .controller('GenerateDeleteController',GenerateDeleteController);

    GenerateDeleteController.$inject = ['$uibModalInstance', 'entity', 'Generate'];

    function GenerateDeleteController($uibModalInstance, entity, Generate) {
        var vm = this;

        vm.generate = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        
        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Generate.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
