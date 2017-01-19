(function () {
	'use strict';
	angular.module('videoGenWebApp')
	.factory('VideoGenService', VideoGenService);
	
	VideoGenService.$inject = ['$resource'];
	
	function VideoGenService($resource) {
		var resourceUrl = 'api/video-gen';
		
		return $resource(resourceUrl, {}, {
			'getPlaylist' : {
				method: 'GET',
				transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
				}
			}
		
		})
	}
})();