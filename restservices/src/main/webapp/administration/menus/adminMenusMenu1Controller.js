(function () {
    'use strict';
 
    angular
        .module('app.adminMenusMenu1Controller',[])
        .controller('adminMenusMenu1Controller', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminMenusMenu1Controller');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminMenusMenu1');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();