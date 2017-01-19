(function () {
	'use strict';
	angular.module('videoGenWebApp')
	  .service('VideoGenConfiguratorService',['$http', function ($http) {

  this.addNew = function (data) {

    $http({
          url: 'api/video-gen/configurateur',
          method: 'GET',
          data: data, // your $scope.name
          headers: {'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'}
      })
      .success(function (response) {
        console.log('good');
      })
      .error(function (response) {
        console.log('error');
      });

  };
}])
});