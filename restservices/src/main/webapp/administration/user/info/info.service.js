(function() {
    'use strict';
    angular
        .module('app.infoService',[])
        .factory('Info', Info);

    Info.$inject = ['$resource', 'DateUtils'];

    function Info ($resource, DateUtils) {
        var resourceUrl =  'api/osi-users/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.sdate = DateUtils.convertLocalDateFromServer(data.sdate);
                        data.edate = DateUtils.convertLocalDateFromServer(data.edate);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.sdate = DateUtils.convertLocalDateToServer(copy.sdate);
                    copy.edate = DateUtils.convertLocalDateToServer(copy.edate);
                    return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
                    copy.sdate = DateUtils.convertLocalDateToServer(copy.sdate);
                    copy.edate = DateUtils.convertLocalDateToServer(copy.edate);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();
