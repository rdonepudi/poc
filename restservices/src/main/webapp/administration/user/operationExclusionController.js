(function () {
    'use strict';
 
    angular
        .module('app.operationExclusionController',[])
        .controller('operationExclusionController', operationExclusionController);
    operationExclusionController.$inject = ['$scope','$location', '$window', 'AuthenticationService','OperationExclusionService','FunctionExclusionService','FunctionGetById'];
    
    var $ = angular.element;
    function operationExclusionController($scope, $location, $window, AuthenticationService, OperationExclusionService, FunctionExclusionService, FunctionGetById) {
        var vm = this;
        vm.excludedOpts = [];
        vm.merged = [];
        vm.merge = [];
        vm.logout = logout;
       
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
        	FunctionExclusionService.query(function(result1){alert(result1);
        		console.log(result1);
        		//vm.demoFunc = result1;
        		$scope.demoFunc = result1;
        	});
        	OperationExclusionService.query(function(result){
        		console.log(result);
        		$scope.demoOpts = result;
        	});
        																
        };
        
        $scope.getOperations= function getOperations(functionId){
        	//alert(functionId);
        	$scope.fid = functionId;
        	console.log('$scope.fid ',$scope.fid );
        	FunctionExclusionService.get({ id: $scope.fid }, function(data) {
        		console.log(data);
                $scope.functionDetails = data;
                });
        	
        };       
        
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
	        	var index = vm.merged.indexOf(vm.merge[i]);alert("index  "+index);
	        	if (index > -1) {
	        		vm.merged.splice(index, 1);
	        	}
        	}
        	alert("arrayDeleted : " + vm.merged);
        }
    }
    
})();