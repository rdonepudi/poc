(function() {
	'use strict';
	angular.module('app.SharedDataService', []).service('SharedDataService',
			SharedDataService);
	SharedDataService.$inject = [ '$resource' ];

	function SharedDataService($resource) {
		var data;
		var key;
		var value;
		var tab = {key : value};

		return {
			setData : function(body) {
				data = body;
			},
			getData : function() {
				return data;
			},
			
			setTab : function(key, value) {
				tab.key = tab.value;
			},
			getTab : function(key) {
				return tab[key];
			}
		};
	}
})();