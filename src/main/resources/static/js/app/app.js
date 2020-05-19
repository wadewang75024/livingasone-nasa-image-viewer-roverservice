'use strict'

var roverserviceApp = angular.module(
		  'nasa.roverservice', 
		[ 'ui.bootstrap', 
		  'roverservice.controllers',
		  'roverservice.services' ]);

roverserviceApp.constant("CONSTANTS", {
	getRovers : "/api/v1/rovers"
});