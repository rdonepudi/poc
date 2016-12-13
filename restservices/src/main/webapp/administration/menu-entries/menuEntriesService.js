(function() {
    'use strict';
    angular
        .module('app.menuEntriesService',[])
        .factory('menuEntriesService', menuEntriesService);
    menuEntriesService.$inject = [ '$resource'];
    
    function menuEntriesService ($resource) {
     var resourceUrl =  'api/osi-menu';

          return $resource(resourceUrl, {}, {
    'save': {
             method: 'GET',
             transformRequest: function (data) {
                 return angular.toJson(data);
             }
    
    		}
    
          });
    }
})();