(function () {
    'use strict';
 
    angular
        .module('app.loginController',[])
        .controller('loginController', loginController);
 
    function loginController($scope, $window, $location, AuthenticationService, $rootScope, $localStorage, $timeout) {
        var vm = this;
        
        vm.login = login;
        function login() {
            vm.loading = true;
            AuthenticationService.Login(vm.username, vm.password, function (result) {
            	//console.log('-------'+result.firstName+'-------'+result.lastName+'-------'+result.userName+'-------'+result.id);
                if (result.httpStatus==null) {
                	AuthenticationService.SetToken(result);
                	delete $localStorage.error;
                	if(result.menuTree!=null){
                		$localStorage.menuTree=JSON.parse(result.menuTree);
                	}else{
                		$localStorage.menuTree = [];
                	}
                	$localStorage.menuTree.push({title: "Logout", functionId:'2323', url:"/logout"});
                  //  $location.path('/home');
                   // $window.location.reload(true);
                    $window.location.href='#/home';
                    $window.location.reload(true);
                } else {
                    vm.error = 'Username or password is incorrect';
					vm.password = "";
                    vm.loading = false;
                }
            });
        };
    };
})();