(function () {
    'use strict';
 
    angular
        .module('app.userController',[])
        .controller('userController', userController);
    userController.$inject = ['$timeout','$location', '$window', '$routeParams', 'AuthenticationService', 'User', 'SharedDataService'];
    function userController($timeout, $location, $window, $routeParams, AuthenticationService, User, SharedDataService) {
        var vm = this;
        var tab = 'info';
        var infoTab = SharedDataService.getTab(tab);
        initController();

        function initController() {
        	console.log('USER');
        	console.log('id : ', $routeParams);
        	
        	User.get({id : $routeParams.id}, function(result) {
                vm.user = result;
                SharedDataService.setData(vm.user);
            });
        }
    }
})();