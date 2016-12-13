(function () {
    'use strict';
 
    angular
        .module('app.adminMenuController',[])
        .controller('adminMenuController', adminMenuController);
    adminMenuController.$inject = ['$location', '$window', 'AuthenticationService', '$scope', 'AdminMenuService'];
    function adminMenuController($location, $window, AuthenticationService, $scope, AdminMenuService) {
        var vm = this;
        vm.logout = logout;
        vm.save = save;
        vm.cancel = cancel;
        vm.getMenuById = getMenuById;
        
        initController();
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
        };
        
        
        function getMenuById(menuId) {
        	$scope.id = menuId;
        	console.log("$scope.id : "+$scope.id);
        	AdminMenuService.get({ id: $scope.id }, function(data) {
             	 vm.getMenu = data;
             	console.log(data);
              });
		};
        
		
        function cancel(){
        	//console.log("In Cancel function");
        	$location.path('/home');
        	$window.location.reload();
        };
        
        
        function initController() {
        	
        	//function loadAll() {
              	 AdminMenuService.query(function(result) {
                  	 
                  	 vm.allMenu = result;
                  	 //console.log(vm.allMenu);
                  	 for(var i=0; i< vm.allMenu.length; i++){
                  		// console.log("Menu Name: "+vm.allMenu[i].menuName);
                  	 }
                   });
               //};
        };
    }
})();