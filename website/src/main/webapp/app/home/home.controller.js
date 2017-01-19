(function() {
    'use strict';

    angular
        .module('videoGenWebApp')
        .controller('HomeController', HomeController);

    HomeController.$inject = ['$scope', 'Principal','LoginService','$state', 'VideoGenService', '$http', '$sce'];

    function HomeController ($scope, Principal, LoginService, $state, VideoGenService, $http, $sce) {
        var vm = this;

        $http.get("api/video-gen/configurateur")
        .then(function(response){ vm.configurateur=$sce.trustAsHtml(response.data); });
        vm.account = null;
        vm.isAuthenticated = null;
        vm.playlist = null;
        vm.videoslist = null;
        vm.login = LoginService.open;
        vm.register = register;
        vm.generate=generate;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function generate() {
        	vm.playlist = VideoGenService.getPlaylist();
        	vm.videoslist = VideoGenService.getPlaylist().videos;
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
