(function () {
    'use strict';
 
    angular
    .module('app.menuEntriesController',[])
    .controller('menuEntriesController', menuEntriesController);
    menuEntriesController.$inject = ['$location', '$window', 'AuthenticationService','AdminMenuService','menuEntriesService','AdminFunctionService'];
    function menuEntriesController($location, $window, AuthenticationService,AdminMenuService,menuEntriesService,AdminFunctionService)
    {
    	var vm = this;
    	vm.types=[{type:"F"},{type:"M"}];
    	vm.menus=[];
    	vm.functions=[];
    	vm.menuObj={};
    	vm.menuEntries = {
    			headerMenu: '',
    			subMenus:[{selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:'',osiFunctions:''}]
    	};

    	AdminMenuService.query(function(result){
    		vm.menus=result;
    		//console.log("Menus:",JSON.stringify(vm.menus));
    	});

    	AdminFunctionService.query(function (result){
    		vm.functions=result;
    		//console.log("Functions:",JSON.stringify(vm.functions));
    	});

    	vm.initController=function () {
    		vm.menuEntries = {
        			headerMenu: '',
        			subMenus:[{selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:'',osiFunctions:''}]
        	};
    	}

    	vm.addMenu=function(subMenu){
    		if(subMenu.selectedType!='' && subMenu.seq!='' &&  subMenu.osiMenusByMenuId!='' && subMenu.menuPrompt!='')
    		{
    			vm.menuEntries.subMenus.push({ selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:'',osiFunctions:''});
    		}
    		else
    		{
    			alert("Please fill all necessary fields.");
    		}

    	};
    	vm.removeMenu=function(submenu)
    	{
    		if(vm.menuEntries.subMenus.length>1)
			{
    			vm.menuEntries.subMenus.splice(vm.menuEntries.subMenus.indexOf(submenu),1);
			}
    		else
			{
				vm.menuEntries.subMenus=[{selectedType: '', seq: '', osiMenusBySubMenuId: '',menuPrompt:'',osiFunctions:''}];
			}
    			
    	};



    	vm.save=function(entries){
    		console.log('Entries:',JSON.stringify(entries));
    		if(entries.headerMenu!='')
    		{
    			angular.forEach(entries.subMenus, function(value, key){

        			vm.menuObj={};
        			vm.menuObj.seq=value.seq;
        			vm.menuObj.menuPrompt=value.menuPrompt;
        			vm.menuObj.osiMenusByMenuId=angular.fromJson(entries.headerMenu);
        			if(value.osiFunctions!='')
    				{
        				vm.menuObj.osiFunctions=angular.fromJson(value.osiFunctions);
    				}
        			else
    				{
    					vm.menuObj.osiMenusBySubMenuId=angular.fromJson(value.osiMenusBySubMenuId);
    				}
        			console.log("Saving: "+JSON.stringify(vm.menuObj));
        			vm.savedMenu=menuEntriesService.save(vm.menuObj);
        			console.log("Saved: "+JSON.stringify(vm.savedMenu));
        			vm.initController();

        		});

    			
    		}
    		else{
    			alert("please select header menu.")
    		}
    		

    		/*vm.menuObj.seq=2;
            vm.menuObj.menuPrompt='heolo prompt';
            vm.menuObj.osiMenusByMenuId=vm.menus[0];
            vm.menuObj.osiMenusBySubMenuId=vm.menus[2];
            vm.savedMenu=menuEntriesService.save(vm.menuObj);
        	console.log("Saved: "+JSON.stringify(vm.savedMenu));*/
    	}
    }
})();



