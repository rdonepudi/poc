(function () {
    'use strict';
 
    angular
        .module('app.adminResponsibilityController',[])
        .controller('adminResponsibilityController', adminResponsibilityController);
    adminResponsibilityController.$inject = ['$location', '$window', 'AuthenticationService'];
    function adminResponsibilityController($location, $window, AuthenticationService) {
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