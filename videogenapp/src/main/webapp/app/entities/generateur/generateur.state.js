(function() {
    'use strict';

    angular
        .module('videoGenApplicationApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('generateur', {
            parent: 'entity',
            url: '/generateur',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'videoGenApplicationApp.generateur.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/generateur/generateurs.html',
                    controller: 'GenerateurController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('generateur');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('generateur-detail', {
            parent: 'entity',
            url: '/generateur/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'videoGenApplicationApp.generateur.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/generateur/generateur-detail.html',
                    controller: 'GenerateurDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('generateur');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Generateur', function($stateParams, Generateur) {
                    return Generateur.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'generateur',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('generateur-detail.edit', {
            parent: 'generateur-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generateur/generateur-dialog.html',
                    controller: 'GenerateurDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Generateur', function(Generateur) {
                            return Generateur.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('generateur.new', {
            parent: 'generateur',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generateur/generateur-dialog.html',
                    controller: 'GenerateurDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                test: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('generateur', null, { reload: 'generateur' });
                }, function() {
                    $state.go('generateur');
                });
            }]
        })
        .state('generateur.edit', {
            parent: 'generateur',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generateur/generateur-dialog.html',
                    controller: 'GenerateurDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Generateur', function(Generateur) {
                            return Generateur.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('generateur', null, { reload: 'generateur' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('generateur.delete', {
            parent: 'generateur',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/generateur/generateur-delete-dialog.html',
                    controller: 'GenerateurDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Generateur', function(Generateur) {
                            return Generateur.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('generateur', null, { reload: 'generateur' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
