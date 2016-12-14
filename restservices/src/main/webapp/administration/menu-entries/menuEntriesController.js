(function () {
    'use strict';
 
    angular
        .module('app.menuEntriesController',[])
        .controller('menuEntriesController', menuEntriesController);
    menuEntriesController.$inject = ['$location', '$window', 'AuthenticationService','AdminMenuService','menuEntriesService'];
    function menuEntriesController($location, $window, AuthenticationService,AdminMenuService,menuEntriesService) {
        var vm = this;
        vm.types=[{type:"F"},{type:"M"}];
        vm.menus=[];
       // vm.selectText="select menu";
        
        //vm.subMenus=[{menuName:"Select Menu"}];
        //vm.rows=1;
        vm.menuObj={};
       // vm.menuObj.type=vm.selectedType;
        //vm.menuObj.seq=vm.sequence;
        //vm.menuObj.prompt=vm.prompt;
        
        /************************************************************/
        /*vm.tmpMenu.menuEntries={menus:[]};
        vm.tmpMenu.selectedType='';
        vm.tmpMenu.sequence=0;
        vm.tmpMenu.prompt='';
        vm.tmpMenu.selectedSubmenu={};*/
        
        vm.headerMenu='';
        vm.menuEntries = {
        	headerMenu: '',
            subMenus:[{selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:''}]
          };
        
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
        
        vm.addMenu=function(){
        	vm.menuEntries.subMenus.push({ selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:''});
        	console.log("add menu called");
        };
        
        vm.save=function(entries){
        	//vm.headermenu=JSON.stringify(entries.headerMenu).replace(/\\/g, "");
        	//console.log("str:"+vm.headermenu);
        	//console.log(JSON.stringify(vm.menus[2]));
        	//console.log(JSON.stringify(angular.fromJson(entries.headerMenu)));
        	//console.log("headerMenu:",JSON.stringify(entries.headerMenu).toJSON());
        	
        	angular.forEach(entries.subMenus, function(value, key){
        		
        		 vm.menuObj={};
        		 vm.menuObj.seq=value.seq;
                 vm.menuObj.menuPrompt=value.menuPrompt;
                 vm.menuObj.osiMenusByMenuId=angular.fromJson(entries.headerMenu);
                 vm.menuObj.osiMenusBySubMenuId=angular.fromJson(value.osiMenusBySubMenuId);
                // console.log("Saving: "+JSON.stringify(vm.menuObj));
                 vm.savedMenu=menuEntriesService.save(vm.menuObj);
                 console.log("Saved: "+JSON.stringify(vm.savedMenu));
                 
                /* vm.menuObj.seq=2;
                 vm.menuObj.menuPrompt='heolo prompt';
                 vm.menuObj.osiMenusByMenuId=vm.menus[0];
                 vm.menuObj.osiMenusBySubMenuId=vm.menus[2];*/
                // vm.savedMenu=menuEntriesService.save(vm.menuObj);
             	//console.log("Hardcoded: "+JSON.stringify(vm.menuObj));
        	});
        	
        	
            /*vm.menuObj.seq=2;
            vm.menuObj.menuPrompt='heolo prompt';
            vm.menuObj.osiMenusByMenuId=vm.menus[0];
            vm.menuObj.osiMenusBySubMenuId=vm.menus[2];
            vm.savedMenu=menuEntriesService.save(vm.menuObj);
        	console.log("Saved: "+JSON.stringify(vm.savedMenu));*/
        }
    }
})();



