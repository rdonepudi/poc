(function () {
    'use strict';
 
    angular
        .module('app.userController',[])
        .controller('userController', userController);
    userController.$inject = ['$location', '$window', 'AuthenticationService'];
    function userController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('userController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/user');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();