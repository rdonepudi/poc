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

