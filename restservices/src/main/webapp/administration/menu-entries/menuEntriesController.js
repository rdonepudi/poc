(function () {
    'use strict';
 
    angular
        .module('app.menuEntriesController',[])
        .controller('menuEntriesController', menuEntriesController);
    menuEntriesController.$inject = ['$location', '$window', 'AuthenticationService'];
    function menuEntriesController($location, $window, AuthenticationService) {
        var vm = this;
        vm.menus=[{title:'Menu1'},{title:'Menu2'},{title:'Menu3'},{title:'Menu4'},{title:'Menu5'}];
        vm.menuCount=vm.menus.length;
        console.log("Menu length:",vm.menuCount);
        
        initController();
        
        function initController() {
        	console.log("COntroller Initiateed");
        }
        
        vm.save=function(){
        }
    }
})();



