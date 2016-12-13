(function () {
    'use strict';
 
    angular
        .module('app.adminResponsibilityController',[])
        .controller('adminResponsibilityController', adminResponsibilityController);
    adminResponsibilityController.$inject = ['$location', '$window', 'AuthenticationService','adminResponsibilityService','AdminMenuService'];
    function adminResponsibilityController($location, $window, AuthenticationService,adminResponsibilityService,AdminMenuService) {
        var vm = this;
        initController();
        vm.logout = logout;
        vm.clear = clear;
        vm.save = save;
        vm.openCalendar = openCalendar;
        vm.datePickerOpenStatus = {};
    	vm.datePickerOpenStatus.sdate = false;
    	vm.datePickerOpenStatus.edate = false;
    	 vm.loadAll = loadAll;

         loadAll();

         function loadAll() {
        	 AdminMenuService.query(function(result) {
            	 vm.allMenu= result;
             });
         }
        function logout() {
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
        	$location.path('/home');
        	$window.location.reload();
        }
        function save () {
            vm.isSaving = true;
          //  console.log(JSON.stringify(vm.responsibility));
            adminResponsibilityService.save((vm.responsibility), function(result){
            	alert("Responsibility added success");
            	$location.path('/home');
            	$window.location.reload();
            });
        }
        
   

    }
})();