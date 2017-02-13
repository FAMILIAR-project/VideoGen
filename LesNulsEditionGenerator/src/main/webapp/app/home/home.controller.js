(function() {
    'use strict';

    angular
        .module('lesNulsEditionGeneratorApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal', 'LoginService', '$state', '$http'];

    function HomeController ($scope, Principal, LoginService, $state, $http) {
        var vm = this;
        $scope.thumbsPath = "../content/images/thumbs/";
        $http.get('http://localhost:8080/api/videogen/thumbnails').
        then(function(response) {
            $scope.showThumbs = true;
            $scope.showVideo = false;
            $scope.thumbs = response.data;
        });

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        $scope.generateVideo = function() {
            $http.get('http://localhost:8080/api/videogen/generateVideo').
            then(function(response) {
                $scope.thumbs = response.data;
                $scope.showThumbs = false;
                $scope.showVideo = true;
                $scope.videoUrl = response.data.video;
            });
        };

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
