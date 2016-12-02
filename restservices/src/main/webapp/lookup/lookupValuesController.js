(function () {
    'use strict';
 
    angular
        .module('app.lookupValuesController',[])
        .controller('lookupValuesController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService'];
    function homeController($location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        function logout() {
        	console.log('lookupValuesController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/lookupValues');
        	$window.location.reload();
        };
        function initController() {
        }
    }
})();