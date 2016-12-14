(function () {
    'use strict';
 
    angular
        .module('app.userListController',[])
        .controller('userListController', userListController);
    userListController.$inject = ['$timeout','$location', '$window', '$routeParams', 'AuthenticationService', 'User'];
    function userListController($timeout, $location, $window, $routeParams, AuthenticationService, User) {
        var vm = this;
        initController();

        function initController() {
        	console.log('USERS');
        	User.query(function(result) {
                vm.users = result;
                console.log(JSON.stringify(result));
            });
        }
    }
})();