(function () {
    'use strict';
 
    angular
        .module('app.homeController',[])
        .controller('homeController', homeController);
    homeController.$inject = ['$location', '$window', 'AuthenticationService','$timeout', '$scope', '$localStorage'];
    function homeController($location, $window, AuthenticationService, $timeout, $scope, $localStorage) {
        var vm = this;
        initController();
        function initController() {
        }
    }
})();