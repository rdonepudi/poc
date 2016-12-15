(function () {
    'use strict';
 
    angular
        .module('app.userController',[])
        .controller('userController', userController);
    userController.$inject = ['$timeout','$location', '$window', 'AuthenticationService'];
    function userController($timeout, $location, $window, AuthenticationService) {
        var vm = this;
        initController();
        vm.logout = logout;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        
        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });
        
        vm.datePickerOpenStatus.sdate = false;
        vm.datePickerOpenStatus.edate = false;

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
        
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