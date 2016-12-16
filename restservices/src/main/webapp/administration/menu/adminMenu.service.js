(function() {
    'use strict';
    angular
        .module('app.AdminMenuService',[])
        .factory('AdminMenuService', AdminMenuService);
    AdminMenuService.$inject = [ '$resource'];
    
    function AdminMenuService ($resource) {
    	
    	 var resourceUrl =  'api/osi-menus/:id';

         
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
