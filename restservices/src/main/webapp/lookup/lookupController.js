(function () {
    'use strict';
 
    angular
        .module('app.lookupController',[])
        .controller('lookupController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('lookupController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/lookup');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();