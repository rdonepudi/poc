(function () {
    'use strict';
 
    angular
        .module('app.loginController',[])
        .controller('loginController', loginController);
 
    function loginController($window, $location, AuthenticationService) {
        var vm = this;
 
        vm.login = login;
 
        function login() {
            vm.loading = true;
            AuthenticationService.Login(vm.username, vm.password, function (result) {
                if (result.success == true) {
                	AuthenticationService.SetCredentials(vm.username, vm.password);
                    $location.path('/home');
                    $window.location.reload();
                } else {
                    vm.error = 'Username or password is incorrect';
                    AuthenticationService.ClearCredentials();
					vm.username = "";
					vm.password = "";
                    vm.loading = false;
                }
            });
        };
    };
})();