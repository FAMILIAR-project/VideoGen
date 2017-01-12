(function () {
    'use strict';

    angular
        .module('videoGenWebSiteApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
