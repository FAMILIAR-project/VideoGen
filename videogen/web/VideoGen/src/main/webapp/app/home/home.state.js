(function() {
    'use strict';

    angular
        .module('videoGenApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('home', {
            parent: 'app',
            url: '/',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/home/home.html',
                    controller: 'HomeController',
                    controllerAs: 'vm'
                }
            }
        });
        $stateProvider.state('videogen', {
            parent: 'app',
            url: '/videogen',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/videogen/videogen.html',
                    controller: 'VideoGenController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
