(function() {
	'use strict';

	angular.module('app.userResponsibilityController', []).controller(
			'userResponsibilityController', userResponsibilityController);
	userResponsibilityController.$inject = [ '$timeout', '$location',
			'$window', 'AuthenticationService', 'ResponsibilityService',
			'RespService' ];
	function userResponsibilityController($timeout, $location, $window,
			AuthenticationService, ResponsibilityService, RespService) {

		var vm = this;
		vm.open = open;
		vm.eopen = eopen;
		vm.save = save;
		vm.addRow = addRow;
		vm.getResponsibilities = getResponsibilities;
		vm.deleteRow = deleteRow;
		vm.result = [];
		vm.osiUser={"id":21};
		/*vm.userResp = {
			"osiUser":{"id":15}
		};*/
		vm.userResp = [{}];

		vm.userRespDetails = [1,2];

		vm.opened = {};
		function open(index) {
			$timeout(function() {
				vm.opened[index] = true;
			});
		};

		vm.eopened = {};
		function eopen(index) {
			$timeout(function() {
				vm.eopened[index] = true;
			});
		};
		
		function deleteRow(rowNum){
			console.log("null row"+JSON.stringify(vm.userResp));
			if(vm.userResp.length <= 1){
				vm.userResp[0] = {};
			}
			else{
				vm.userResp.splice(rowNum,1);
			}
			console.log("Array is .."+JSON.stringify(vm.userResp));
		}
		
		function addRow(){
			vm.userResp.push({});
			console.log("Array is .."+JSON.stringify(vm.userResp));
		}

		vm.getResponsibilities();

		function getResponsibilities() {
			RespService.query(function(result) {
				vm.responsibilities = result;
				console.log("called getResponsibilities"
						+ JSON.stringify(vm.responsibilities));
			});
		}
		;

		function save() {
			for(var i=0;i<vm.userResp.length;i++){
				vm.userResp[i].osiUser = vm.osiUser;
				if(vm.userResp[i].defaultResp == null){
					vm.userResp[i].defaultResp = false;
				}
			}
			vm.result = ResponsibilityService.save(vm.userResp, onSaveSuccess, onSaveError);
		}
		
		function onSaveSuccess (result) {
			vm.userResp=[{}];
        	console.log('SUCCESS !');
        }

        function onSaveError () {
        	console.log('ERROR !!');
        }
	}
})();