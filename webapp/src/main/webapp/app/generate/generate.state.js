(function() {
    'use strict';

    angular
        .module('webappApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('generate', {
            parent: 'app',
            url: '/generate',
            data: {
                authorities: [],
                pageTitle: 'webappApp.generate.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/generate/generates.html',
                    controller: 'GenerateController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('generate');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        ;
    }

})();
