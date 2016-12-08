(function() {
    'use strict';
    angular
        .module('app.AdminMenuService',[])
        .factory('AdminMenuService', AdminMenuService);
    AdminMenuService.$inject = [ '$resource'];
    
    function AdminMenuService ($resource) {
     var resourceUrl =  'api/osi-menus';

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