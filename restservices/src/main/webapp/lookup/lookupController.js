(function () {
    'use strict';
 
    angular
        .module('app.lookupController',[])
        .controller('lookupController', lookupController);
    lookupController.$inject = ['$location', '$window', 'AuthenticationService'];
    function lookupController($location, $window, AuthenticationService) {
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