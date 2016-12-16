(function () {
    'use strict';
 
    angular
        .module('app.userListController',[])
        .controller('userListController', userListController);
    userListController.$inject = ['$timeout','$location', '$window', '$routeParams', 'AuthenticationService', 'User'];
    function userListController($timeout, $location, $window, $routeParams, AuthenticationService, User) {
        var vm = this;
        var userUrl = '#/user/';
        vm.createUser = createUser;
        vm.editUser = editUser;
        initController();

        function initController() {
        	console.log('USERS');
        	angular.element($window).unbind();
        	User.query(function(result) {
                vm.users = result;
            });
        }
        
        function createUser() {
        	angular.element($window).unbind();
        	$window.location.href = userUrl + null;
        }
        
        function editUser(id) {
        	$window.location.href = userUrl + id;
        }
    }
})();