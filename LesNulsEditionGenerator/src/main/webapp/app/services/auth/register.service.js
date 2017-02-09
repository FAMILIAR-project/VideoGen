(function () {
    'use strict';

    angular
        .module('lesNulsEditionGeneratorApp')
        .factory('Register', Register);

    Register.$inject = ['$resource'];

    function Register ($resource) {
        return $resource('api/register', {}, {});
    }
})();
