(function() {
    'use strict';
    angular
        .module('app.AdminFunctionService',[])
        .factory('AdminFunctionService', AdminFunctionService);
    AdminFunctionService.$inject = [ '$resource'];
    
    function AdminFunctionService ($resource) {
   
    var resourceUrl =  'api/osi-functions/:id';

         
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