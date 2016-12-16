(function () {
    'use strict';
 
    angular
        .module('app.adminMenusMenu2Controller',[])
        .controller('adminMenusMenu2Controller', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminMenusMenu2Controller');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminMenusMenu2');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();