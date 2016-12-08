(function () {
    'use strict';
 
    angular
        .module('app.adminResponsibilityController',[])
        .controller('adminResponsibilityController', adminResponsibilityController);
    adminResponsibilityController.$inject = ['$location', '$window', 'AuthenticationService','adminResponsibilityService'];
    function adminResponsibilityController($location, $window, AuthenticationService,adminResponsibilityService) {
        var vm = this;
        initController();
        vm.logout = logout;
        vm.clear = clear;
        vm.save = save;
        vm.openCalendar = openCalendar;
        vm.datePickerOpenStatus = {};
    	vm.datePickerOpenStatus.sdate = false;
    	vm.datePickerOpenStatus.edate = false;

        function logout() {
        	console.log('adminResponsibilityController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/adminResponsibility');
        	$window.location.reload();
        };
        function initController() {
        }
        
        
        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
        
        
        function clear () {
        	console.log("call");
        	
//            $uibModalInstance.dismiss('cancel');
        }
        function save () {
            vm.isSaving = true;
            console.log(vm.responsibility);
            adminResponsibilityService.save(vm.responsibility);
        }
        
   

    }
})();