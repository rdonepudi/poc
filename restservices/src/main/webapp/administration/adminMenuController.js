(function () {
    'use strict';
 
    angular
        .module('app.adminMenuController',[])
        .controller('adminMenuController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
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