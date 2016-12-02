(function () {
    'use strict';
 
    angular
        .module('app.adminUserController',[])
        .controller('adminUserController', adminUserController);
    adminUserController.$inject = ['$location', '$window', 'AuthenticationService'];
    function adminUserController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('adminUserController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminUser');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();