(function() {
    'use strict';
    angular
        .module('app.respService',[])
        .factory('RespService', Resp);

    Resp.$inject = ['$resource', 'DateUtils'];

    function Resp ($resource, DateUtils) {
        var resourceUrl =  'api/osi-responsibilities';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true },
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                    	console.log("***within get***");
                        data = angular.fromJson(data);
                        /*data.sdate = DateUtils.convertLocalDateFromServer(data.sdate);
                        data.edate = DateUtils.convertLocalDateFromServer(data.edate);*/
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                	console.log('in service PUT: ',JSON.stringify(data));
                    var copy = angular.copy(data);
                    copy.sdate = DateUtils.convertLocalDateToServer(copy.sdate);
                    copy.edate = DateUtils.convertLocalDateToServer(copy.edate);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                	console.log('in service POST: ',JSON.stringify(data));
                    var copy = angular.copy(data);
                    copy.sdate = DateUtils.convertLocalDateToServer(copy.sdate);
                    copy.edate = DateUtils.convertLocalDateToServer(copy.edate);
                    console.log(angular.toJson(copy));
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
