'use strict'

var module = angular.module('roverservice.controllers', []);
module.controller
("RoverController", 
	[ "$scope", "RoverService",
		function($scope, RoverService) {			
			RoverService.getRovers().then(function(value) 
			{
				console.log(value.data);
				$scope.allRovers= value.data.rovers;
			}, function(reason) 
			{
				console.log("error occured");
			}, function(value) 
			{
				console.log("no callback");
			}
			);

			$scope.displayRovers = function() {				
				RoverService.getRovers().then(function(value) {
					console.log("works");
					$scope.allRovers= value.data.rovers;							
				}, function(reason) {
					console.log("error occured");
				}, function(value) {
					console.log("no callback");
				}
				);
			}
					
		}
	]
);