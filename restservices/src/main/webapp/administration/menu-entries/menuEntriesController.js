(function () {
    'use strict';
 
    angular
        .module('app.menuEntriesController',[])
        .controller('menuEntriesController', menuEntriesController);
    menuEntriesController.$inject = ['$location', '$window', 'AuthenticationService','AdminMenuService'];
    function menuEntriesController($location, $window, AuthenticationService,AdminMenuService) {
        var vm = this;
        vm.selectAttr="asfds";
        vm.types=[{type:"F"},{type:"M"}];
        vm.selectText="select menu";
        vm.menus=[];
        vm.subMenus=[{menuName:"Select Menu"}];
        AdminMenuService.query(function(result){
        	vm.menus=result;
        	console.log("Menu :",result);
        });
        //=[{title:'Menu1'},{title:'Menu2'},{title:'Menu3'},{title:'Menu4'},{title:'Menu5'}];
        vm.menuCount=vm.menus.length;
        
        
        initController();
        
        function initController() {
        	console.log("COntroller Initiateed");
        }
        
        vm.save=function(){
        	
        }
    }
})();



