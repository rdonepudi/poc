(function () {
    'use strict';
 
    angular
        .module('app.homeController',[])
        .controller('homeController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('logout');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/login');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();