(function() {
    'use strict';
    angular
        .module('app.OperationExclusionService',[])
        .factory('OperationExclusionService', OperationExclusionService);
    OperationExclusionService.$inject = ['$resource'];
    
    function OperationExclusionService ($resource) {
     var resourceUrl =  'api/osi-operataions';
      
          return $resource(resourceUrl, {}, {
          'query': { method: 'GET', isArray: true},
              'get': {
                  method: 'GET',
                  transformResponse: function (data) {
                      return data;
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
