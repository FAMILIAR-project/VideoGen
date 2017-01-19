(function() {
    'use strict';

    angular
        .module('videoGenWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('jhi-health', {
            parent: 'admin',
            url: '/health',
            data: {
                authorities: [],
                pageTitle: 'Health Checks'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/health/health.html',
                    controller: 'JhiHealthCheckController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
