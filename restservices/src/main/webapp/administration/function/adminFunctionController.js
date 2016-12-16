(function () {
    'use strict';
 
    angular
        .module('app.adminFunctionController',[])
        .controller('adminFunctionController', adminFunctionController);
    adminFunctionController.$inject = ['$location', '$window', 'AuthenticationService','$scope', 'AdminFunctionService'];
    function adminFunctionController($location, $window, AuthenticationService,$scope, AdminFunctionService) {
        var vm = this;
        vm.logout = logout;
       //vm.datePickerOpenStatus.sdate = false;
       // vm.datePickerOpenStatus.edate = false;
        initController();
        
        function logout() {
        	console.log('adminFunctionController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminFunction');
        	$window.location.reload();
        };
        
      /*  vm.openCalendar = function(date) {
            vm.datePickerOpenStatus[date] = true;
        };*/

        
        function initController() {
        };
        
        vm.saveFunction = function(functionDetails){
        	console.log("In Save function");
        	console.log(functionDetails);
        	AdminFunctionService.save(functionDetails);
        };
    }
})();