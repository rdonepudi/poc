(function () {
    'use strict';
 
    angular
        .module('app.operationExclusionController',[])
        .controller('operationExclusionController', operationExclusionController);
    operationExclusionController.$inject = ['$scope','$location', '$window', 'AuthenticationService','OperationExclusionService','FunctionExclusionService','FunctionOperationService'];
    
    var $ = angular.element;
    function operationExclusionController($scope, $location, $window, AuthenticationService, OperationExclusionService, FunctionExclusionService, FunctionOperationService) {
        var vm = this;
        vm.excludedOpts = [];
        vm.merged = [];
        vm.merge = [];
        vm.logout = logout;
        $scope.funcOp = [];
        $scope.availableFunc = [];
        $scope.excludedFunc = [];
        initController();
        //vm.demoFunc = {};
        /*vm.loadAll= loadAll;        
        function loadAll(){
        	OperationExclusionService.query(function(result){
        		console.log(result);
        		$scope.demoOpts = result;
        	});
        }*/
        function logout() {
        	console.log('operationExclusionController');
            // reset login status
        	AuthenticationService.Logout();
        	$location.path('/user');
        	$window.location.reload();
        };
        
        function initController() {
        	$scope.demoOptions = ["Item 1","Item 2","Item 3","Item 4","Item 5"];
        	FunctionExclusionService.query(function(result1){
        		console.log(result1);
        		//vm.demoFunc = result1;
        		$scope.demoFunc = result1;
        	});
        	OperationExclusionService.query(function(result){
        		console.log(result);
        		$scope.demoOpts = result;
        	});
        																
        };
        $scope.operations = [{ "name" : "Find", "id" : 1 },
                             { "name" : "View", "id" : 2 },
                             { "name" : "Create", "id" : 3 },
                             { "name" : "Edit", "id" : 4 },
                             { "name" : "Delete", "id" : 5 }];
        $scope.getOperations = function(functionId){
        	$scope.availableFunc = [];
            $scope.excludedFunc = [];
            $scope.funcOp = [];
        	$scope.fid = functionId;
        	FunctionOperationService.get({ id: $scope.fid }, function(data) {
        		console.log(data);
                $scope.functionDetails = data;
                angular.forEach($scope.functionDetails, function(value, key){
                    $scope.funcOp.push(value.opId);
                    if(value.opId==1) {
                    	var s = {name:"Find",id:"1"};
                    	$scope.availableFunc.push(s);                    	
                    }	
                    if(value.opId==2) {
                    	var s = {name:"View",id:"2"};
                    	$scope.availableFunc.push(s);
                    }
                    if(value.opId==3)
                    	$scope.availableFunc.push("Create");
                    if(value.opId==4)
                    	$scope.availableFunc.push("Edit");
                    if(value.opId==5)
                    	$scope.availableFunc.push("Delete");
                    
                });
                console.log($scope.availableFunc);
                $scope.findExclOperations($scope.funcOp);
        	});    
        };       
        Array.prototype.diff = function(a) {
            return this.filter(function(i) {return a.indexOf(i) < 0;});
        };
        $scope.findExclOperations = function(funcOp){
        	$scope.diff = [1,2,3,4,5].diff(funcOp);
        	console.log($scope.diff);
        	angular.forEach($scope.diff, function(value, key){
        		if(value==1) {
                	var s = {name:"Find",id:"1"};
                	$scope.excludedFunc.push(s);                    	
                }	
                if(value==2) {
                	var s = {name:"View",id:"2"};
                	$scope.excludedFunc.push(s);
                }
                if(value==3) {
                	var s = {name:"Create",id:"3"};
                	$scope.excludedFunc.push(s);                    	
                }	
                if(value==4) {
                	var s = {name:"Edit",id:"4"};
                	$scope.excludedFunc.push(s);
                }
                if(value==5) {
                	var s = {name:"Delete",id:"5"};
                	$scope.excludedFunc.push(s);
                }
        	});
        }
        
        $scope.addExcludedOptions = function(availableOptions){
        	vm.excludedOpts.push(availableOptions);
        	//alert("array of arrays : " + vm.excludedOpts);
        	vm.merged = [].concat.apply([], vm.excludedOpts);
        	//alert("array : "+merged);
        };
        
        $scope.removeExcludedOptions = function(excludedOptions){
        	vm.merge = [].concat.apply([], excludedOptions);
        	alert("merged : "+vm.merged+" merge : "+vm.merge);
        	for(var i = 0; i < vm.merge.length; i++) {
	        	var index = vm.merged.indexOf(vm.merge[i]);
	        	if (index > -1) {
	        		vm.merged.splice(index, 1);
	        	}
        	}
        	alert("arrayDeleted : " + vm.merged);
        }
    }
    
})();