(function() {
    'use strict';

    angular
        .module('videoGenApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('videogen', {
            parent: 'app',
            url: '/videogen',
            data: {
                authorities: []
            },
            views: {
                'content@': {
                    templateUrl: 'app/videogen/videogen.html',
                    controller: 'VideogenController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                mainTranslatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate,$translatePartialLoader) {
                    $translatePartialLoader.addPart('videogen');
                    return $translate.refresh();
                }]
            }
        });
    }
})();
