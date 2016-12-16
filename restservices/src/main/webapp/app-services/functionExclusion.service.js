(function() {
    'use strict';
    angular
        .module('app.FunctionExclusionService',[])
        .factory('FunctionExclusionService', FunctionExclusionService);
    FunctionExclusionService.$inject = ['$resource'];
    
    function FunctionExclusionService ($resource) {
     var resourceUrl = 'api/osi-functions/:id';
      
          return $resource(resourceUrl, {}, {
          'query': { method: 'GET', isArray: true},
           
          'get': {
                  method: 'GET',
                  transformResponse: function (data) {
                  return angular.fromJson(data);
                  }
              },
          
           'save': {
        	   		method: 'POST',
        	   		transformRequest: function (data) {
        	   		return angular.toJson(data);
        	   		}
    
           	}
    
          });
    }
})();