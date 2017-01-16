(function() {
    'use strict';

    angular
        .module('webappApp')
        .controller('GenerateDialogController', GenerateDialogController);

    GenerateDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Generate'];

    function GenerateDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Generate) {
        var vm = this;

        vm.generate = entity;
        vm.clear = clear;
        vm.save = save;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.generate.id !== null) {
                Generate.update(vm.generate, onSaveSuccess, onSaveError);
            } else {
                Generate.save(vm.generate, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('webappApp:generateUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
