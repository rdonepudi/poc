(function () {
    'use strict';
 
    angular
        .module('app.adminResponsibilityController',[])
        .controller('adminResponsibilityController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminResponsibilityController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminResponsibility');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();