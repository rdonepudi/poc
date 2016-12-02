(function () {
    'use strict';
 
    angular
        .module('app.adminFunctionController',[])
        .controller('adminFunctionController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminFunctionController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminFunction');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();