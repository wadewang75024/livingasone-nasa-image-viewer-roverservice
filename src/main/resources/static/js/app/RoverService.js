'use strict'

angular.module('roverservice.services', []).factory('RoverService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};			
			service.getRovers = function() {
				return $http.get(CONSTANTS.getRovers);
			}
			return service;
		} 
		]
);