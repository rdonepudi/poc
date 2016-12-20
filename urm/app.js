/// <reference path="angular.min.js" />
/// <reference path="angular-route.min.js" />
 
var osi = angular
        .module('app', ['ngRoute', 'ngCookies', 'ngMessages','TreeWidget',
                        'app.homeController',
                        'app.loginController',
                        'app.AuthenticationService',
                        'app.commonController',
                        'app.errorController',
                        'app.authController',
                        'app.httpErrorResponseInterceptor',
                        'ngStorage'])
        .config(config)
        .run(run);
	function config($routeProvider, $httpProvider) {
		$httpProvider.interceptors.push('httpErrorResponseInterceptor');
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
	       controller: 'authController',
	       controllerAs: 'vm'
	   })
	   .when('/error', {
        templateUrl: 'error/error.html',
        controller: 'errorController',
	    controllerAs: 'vm'
      })
	   .when('/commonUrl1', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl2', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl3', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	      .when('/commonUrl4', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl5', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl6', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	      .when('/commonUrl7', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl8', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl9', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	      .when('/commonUrl10', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl11', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl12', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })  .when('/commonUrl9', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	      .when('/commonUrl13', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl14', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl15', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	    .when('/commonUrl16', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })
	   .when('/commonUrl17', {
	       templateUrl: 'common/common.html', 
	       controller: 'commonController',
	       controllerAs: 'vm'
	   })	}
	
	run.$inject = ['$rootScope', '$location', '$cookieStore', '$http', 'AuthenticationService','$window'];
	function run($rootScope, $location, $cookieStore, $http, AuthenticationService, $window) {
	    // keep user logged in after page refresh
	    $rootScope.globals = $cookieStore.get('globals') || {};
	
	    $rootScope.$on('$locationChangeStart', function (event, next, current) {
	        // redirect to login page if not logged in and trying to access a restricted page
	    	if ($rootScope.globals.userDTO) {
		        $http.defaults.headers.common['Auth_Token'] = $rootScope.globals.userDTO.token; // jshint ignore:line
		    }
	    	console.log($.inArray($location.path(), ['/error'])+'----'+loggedIn);
	       var restrictedPage = $.inArray($location.path(), ['/login', '/error']) === -1;
	        var loggedIn = $rootScope.globals.userDTO;
	        if (restrictedPage && !loggedIn) {
	            $location.path('/login');
	        }/*else if($.inArray($location.path(), ['/error'])===-1){
	        	AuthenticationService.ClearToken();
	        	//$window.location.reload(true);
	        }*/
	    });
	}