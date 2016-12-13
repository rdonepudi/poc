(function () {
    'use strict';
 
    angular
        .module('app.menuEntriesController',[])
        .controller('menuEntriesController', menuEntriesController);
    menuEntriesController.$inject = ['$location', '$window', 'AuthenticationService','AdminMenuService','menuEntriesService'];
    function menuEntriesController($location, $window, AuthenticationService,AdminMenuService,menuEntriesService) {
        var vm = this;
        vm.selectAttr="asfds";
        vm.types=[{type:"F"},{type:"M"}];
        vm.selectText="select menu";
        vm.menus=[];
        vm.subMenus=[{menuName:"Select Menu"}];
        vm.rows=1;
        vm.menuObj={};
       // vm.menuObj.type=vm.selectedType;
        vm.menuObj.seq=vm.sequence;
        vm.menuObj.prompt=vm.prompt;
        
        /************************************************************/
        vm.menuEntries
        
        AdminMenuService.query(function(result){
        	vm.menus=result;
        	console.log(vm.menus);
        });
        //=[{title:'Menu1'},{title:'Menu2'},{title:'Menu3'},{title:'Menu4'},{title:'Menu5'}];
        vm.menuCount=vm.menus.length;
        
        
        initController();
        
        function initController() {
        	console.log("COntroller Initiateed");
        }
        
        vm.save=function(){
            vm.menuObj.seq=vm.sequence;
            vm.menuObj.menuPrompt=vm.prompt;
            vm.menuObj.osiMenusByMenuId=vm.menus[0];
            vm.menuObj.osiMenusBySubMenuId=vm.menus[2];
            savedMenu=menuEntriesService.save(vm.menuObj);
        	console.log("Saved: "+JSON.stringify(savedMenu));
        }
    }
})();



