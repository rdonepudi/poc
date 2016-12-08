(function () {
    'use strict';
 
    angular
        .module('app.userController',[])
        .controller('userController', userController);
    userController.$inject = ['$timeout','$location', '$window', 'AuthenticationService'];
    function userController($timeout, $location, $window, AuthenticationService) {
        var vm = this;
        initController();

        function initController() {
        }
    }
})();