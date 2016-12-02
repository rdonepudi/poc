(function () {
    'use strict';
 
    angular
        .module('app.adminMenuController',[])
        .controller('adminMenuController', adminMenuController);
    adminMenuController.$inject = ['$location', '$window', 'AuthenticationService'];
    function adminMenuController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminMenuController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/administration');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();