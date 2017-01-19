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
        vm.mandatory=[];
        vm.optional=[];
        vm.multiple=[];
        vm.doRegeneration=false;

        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        vm.addMandatory=function(){
          vm.mandatory.push("New mandatory");
        }
        vm.addOptional=function(){
          vm.optional.push("New Optional");
        }

        vm.showGeneration=function(){
          return (!(vm.doRegeneration) && vm.isAuthenticated());
        }

        vm.showGenerated=function(){
          return ((!vm.showGeneration()) && vm.isAuthenticated());
        }



        vm.addMultiple=function(){
          vm.multiple.push({title:"New Multiple",subTitles:[]});
        }
        vm.addSubElement=function(opt){
          opt.subTitles.push("New Sub Element");

        }


        vm.regenerate=function(){
          VideoGen.regenerate().$promise.then(function(response){
            vm.playlist=response.playlist;
          });
        }
        vm.regenerate();

        vm.generate=function(){
          vm.doRegeneration=true;
          VideoGen.generate({mandatory:vm.mandatory, optional:vm.optional, multiple:vm.multiple});
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
