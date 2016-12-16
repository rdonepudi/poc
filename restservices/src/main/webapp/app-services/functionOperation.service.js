(function() {
    'use strict';
    angular
        .module('app.FunctionOperationService',[])
        .factory('FunctionOperationService', FunctionOperationService);
    FunctionOperationService.$inject = ['$resource'];
    
    function FunctionOperationService ($resource) {
     var resourceUrl =  'api/osi-functions-operations/:id';
      
          return $resource(resourceUrl, {}, {
          
              'get': {
                  method: 'GET', isArray: true,
                  transformResponse: function (data) {
                	  return angular.fromJson(data);
                	  //return data;
                  }
              }
    
          });
    }
})();