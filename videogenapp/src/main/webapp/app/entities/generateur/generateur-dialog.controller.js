(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .controller('GenerateurDialogController', GenerateurDialogController);

    GenerateurDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'entity', 'Generateur'];

    function GenerateurDialogController ($timeout, $scope, $stateParams, $uibModalInstance, entity, Generateur) {
        var vm = this;

        vm.generateur = entity;
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
            if (vm.generateur.id !== null) {
                Generateur.update(vm.generateur, onSaveSuccess, onSaveError);
            } else {
                Generateur.save(vm.generateur, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('videoGenApplicationApp:generateurUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }


    }
})();
