(function() {
    'use strict';

    angular
        .module('webappApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('generate', {
            parent: 'entity',
            url: '/generate',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'webappApp.generate.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/generate/generates.html',
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
        .state('generate-detail', {
            parent: 'entity',
            url: '/generate/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'webappApp.generate.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/generate/generate-detail.html',
                    controller: 'GenerateDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('generate');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Generate', function($stateParams, Generate) {
                    return Generate.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'generate',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('generate-detail.edit', {
            parent: 'generate-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generate/generate-dialog.html',
                    controller: 'GenerateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Generate', function(Generate) {
                            return Generate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('generate.new', {
            parent: 'generate',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generate/generate-dialog.html',
                    controller: 'GenerateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('generate', null, { reload: 'generate' });
                }, function() {
                    $state.go('generate');
                });
            }]
        })
        .state('generate.edit', {
            parent: 'generate',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generate/generate-dialog.html',
                    controller: 'GenerateDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Generate', function(Generate) {
                            return Generate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('generate', null, { reload: 'generate' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('generate.delete', {
            parent: 'generate',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generate/generate-delete-dialog.html',
                    controller: 'GenerateDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Generate', function(Generate) {
                            return Generate.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('generate', null, { reload: 'generate' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
