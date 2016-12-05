/// <reference path="angular.min.js" />
/// <reference path="angular-route.min.js" />
 
var osi = angular
        .module('app', ['ngRoute', 'ngCookies', 'ngMessages','TreeWidget',
                        'app.homeController',
                        'app.adminMenuController',
                        'app.adminResponsibilityController',
                        'app.adminFunctionController',
                        'app.userController',
                        'app.adminMenusMenu1Controller',
                        'app.loginController',
                        'app.AuthenticationService',
                        'ngStorage'])
        .config(config)
        .run(run);
	function config($routeProvider) {
	    $routeProvider.
	       when('/home', {
	       templateUrl: 'home/home.html', 
	       controller: 'homeController',
	       controllerAs: 'vm'
	   })
	   .when('/login', {
	       templateUrl: 'login/login.html', 
	       controller: 'loginController',
	       controllerAs: 'vm'
	   })
	.when('/logout', {
	       templateUrl: 'login/login.html', 
	       controller: 'homeController',
	       controllerAs: 'vm'
	   })
	   .when('/adminMenu', {
	       templateUrl: 'administration/adminMenu.html', 
	       controller: 'adminMenuController',
	       controllerAs: 'vm'
	   })
	   .when('/adminFunction', {
	       templateUrl: 'administration/adminFunction.html', 
	       controller: 'adminFunctionController',
	       controllerAs: 'vm'
	   })
	    .when('/adminResponsibility', {
	       templateUrl: 'administration/adminResponsibility.html', 
	       controller: 'adminResponsibilityController',
	       controllerAs: 'vm'
	   })
	   .when('/user', {
	       templateUrl: 'administration/user/user.html', 
	       controller: 'userController',
	       controllerAs: 'vm'
	   })
	   .when('/adminMenusMenu1', {
	       templateUrl: 'administration/menus/adminMenusMenu1.html', 
	       controller: 'adminMenusMenu1Controller',
	       controllerAs: 'vm'
	   })
	   .when('/adminMenusMenu2', {
	       templateUrl: 'administration/menus/adminMenusMenu2.html', 
	       controller: 'adminMenusMenu2Controller',
	       controllerAs: 'vm'
	   })
	   .when('/lookup', {
	       templateUrl: 'lookup/lookup.html', 
	       controller: 'lookupController',
	       controllerAs: 'vm'
	   })
	   .when('/lookupValues', {
	       templateUrl: 'lookup/lookupValues.html', 
	       controller: 'lookupValuesController',
	       controllerAs: 'vm'
	   })	}
	osi.controller('authController', function ($location, $rootScope, $scope) {

	    $scope.loggedIn = $rootScope.globals.currentUser;
	    $scope.basicTree=[
	    	{name: "Home", nodeId:119, url:"home"},
	        {name: "Administration", nodeId:100,
	    		children: [
	    			{name: "Menu", nodeId:141, url:"adminMenu"},
		            {name: "Function", nodeId:142, url:"adminFunction"},
		            {name: "Responsibility", nodeId:143, url:"adminResponsibility"},
		            {name: "User", nodeId:140, url:"user"},
		            {name: "Menus", nodeId:141,
		            	children:[
		            		{name:"Menu1",nodeId:112, url:"adminMenusMenu1"},
		            		{name: "Menu2",nodeId:131, url:"adminMenusMenu2"}
		            		]
		            }
		        ]
	    	},
	    	{
	        name: "Lookup", nodeId:101,
	        	children: [
	        		{name: "Lookup", nodeId:109, url:"lookup"},
	        		{name: "Lookup Values",nodeId:110, url:"lookupValues"}
	        		]
	    },
	    {name: "Logout", nodeId:120, url:"logout"
	}];
	    $scope.basicOptions = {
	    	    showIcon: true,
	    	    onSelectNode : function (node) {
	    	    	console.log(node);
	    	    	 $location.path(node.url);
	    	      //  $scope.selectedNode = node;
	    	    },
	    	    onExpandNode : function (node) {
	    	        console.log(node);
	    	        $scope.expandedNode = node;
	    	    }
	    	}
	})
	
	run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
	function run($rootScope, $location, $cookieStore, $http) {
	    // keep user logged in after page refresh
	    $rootScope.globals = $cookieStore.get('globals') || {};
	    if ($rootScope.globals.currentUser) {
	        $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
	    }
	
	    $rootScope.$on('$locationChangeStart', function (event, next, current) {
	        // redirect to login page if not logged in and trying to access a restricted page
	       var restrictedPage = $.inArray($location.path(), ['/login']) === -1;
	        var loggedIn = $rootScope.globals.currentUser;
	        if (restrictedPage && !loggedIn) {
	            $location.path('/login');
	        }
	    });
	}