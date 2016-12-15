(function() {
    'use strict';
    angular
        .module('app.responsibilityService',[])
        .factory('ResponsibilityService', Responsibility);

    Responsibility.$inject = ['$resource', 'DateUtils'];

    function Responsibility ($resource, DateUtils) {
        var resourceUrl =  'api/osi-resp-users/:id';

        return $resource(resourceUrl, {}, {
            'save': {
                method: 'POST',
                isArray: true,
                transformRequest: function (data) {
                	console.log('in service POST: ',JSON.stringify(data));
                    var copy = angular.copy(data);
                    /*copy.sdate = DateUtils.convertLocalDateToServer(copy.sdate);
                    copy.edate = DateUtils.convertLocalDateToServer(copy.edate);*/
                    console.log(angular.toJson(copy));
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
