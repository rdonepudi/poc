(function() {
    'use strict';
    angular
        .module('app.adminResponsibilityService',[])
        .factory('adminResponsibilityService', adminResponsibilityService);
    adminResponsibilityService.$inject = ['$http', '$resource'];
    
    function adminResponsibilityService ($http,$resource) {
    	  var resourceUrl =  'api/osi-responsibilities/:id';

          return $resource(resourceUrl, {}, {
    	 'save': {
             method: 'POST',
             transformRequest: function (data) {
                 return angular.toJson(data);
             	}
    	
    	 	}
    
          });
    }
})();


//angular.module('app.adminResponsibilityService',[]).service('adminResponsibilityService',['$http',adminResponsibilityService]);
//function  adminResponsibilityService($http){
//	return{
//		save:save
//	}
//	
//	function save(responsibility){
//		console.log("----------------");
//		return $http.post("api/osi-responsibilities",responsibility);
//	}
//	
//	        
//		
//	     
//	
//}