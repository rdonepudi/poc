(function () {
    'use strict';
 
    angular
        .module('app.adminMenuController',[])
        .controller('adminMenuController', adminMenuController);
    adminMenuController.$inject = ['$location', '$window', 'AuthenticationService', '$scope', 'AdminMenuService'];
    function adminMenuController($location, $window, AuthenticationService, $scope, AdminMenuService) {
        var vm = this;
        initController();
        vm.logout = logout;
        vm.save = save;
        vm.cancel = cancel;
        
        function logout() {
        	console.log('adminMenuController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/administration');
        	$window.location.reload();
        };
        
        function save(menu){
        	$scope.menu = menu;
        	//console.log("In Save function: "+JSON.stringify($scope.menu));
        	AdminMenuService.save(menu);
        }
        
        function cancel(){
        	//console.log("In Cancel function");
        	$location.path('/home');
        	$window.location.reload();
        }
        
        function initController() {
        }
    }
})();