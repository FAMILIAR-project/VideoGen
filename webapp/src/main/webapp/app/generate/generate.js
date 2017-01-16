(function() {
    'use strict';

    angular
        .module('webappApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('generate', {
            parent: 'app',
            url: '/generate',
            data: {
                authorities: [],
                pageTitle: 'generate.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/generate/generate.html',
                    controller: 'GenerateController'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
