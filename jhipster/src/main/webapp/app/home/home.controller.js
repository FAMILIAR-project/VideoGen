(function() {
    'use strict';

    angular
        .module('videogenApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state','VideoGen'];

    function HomeController ($scope, Principal, LoginService, $state, VideoGen) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        vm.playlist=null;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();


        vm.regenerate=function(){
          VideoGen.regenerate().$promise.then(function(response){
            vm.playlist=response.playlist;
          });
        }

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }
        function register () {
            $state.go('register');
        }
    }
})();
