(function() {
    'use strict';

    angular
        .module('videoGenWebApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('jhi-metrics', {
            parent: 'admin',
            url: '/metrics',
            data: {
                authorities: [],
                pageTitle: 'Application Metrics'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/metrics/metrics.html',
                    controller: 'JhiMetricsMonitoringController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
