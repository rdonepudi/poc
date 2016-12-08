(function () {
    'use strict';
 
    angular
        .module('app.infoController',[])
        .controller('infoController', infoController);
    infoController.$inject = ['$timeout','$location', '$window', 'AuthenticationService','Info'];
    function infoController($timeout, $location, $window, AuthenticationService, Info) {
        var inf = this;
        inf.user ={};
        //inf.user.info = {};
        inf.user.info = {"username":"pradeep","password":"123","confirm":"123","empNo":"NS1315","firstName":"Pradeep","lastName":"Rawate","mobileNumber":"8087810808","emailId":"prawate@osius.com","startDate":"2016-11-30T18:30:00.000Z","endDate":"2016-12-29T18:30:00.000Z"};
        initController();
        inf.clr = clr;
        inf.save = save;
        inf.datePickerOpenStatus = {};
        inf.openCalendar = openCalendar;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });
        
        function save() {
        	console.log('in save : ', JSON.stringify(inf.user.info));
        	inf.isSaving = true;
            Info.save(inf.user.info, onSaveSuccess, onSaveError);
        }
        
        function onSaveSuccess (result) {
            inf.isSaving = false;
        }

        function onSaveError () {
            inf.isSaving = false;
        }
        
        inf.datePickerOpenStatus.sdate = false;
        inf.datePickerOpenStatus.edate = false;

        function openCalendar (date) {
            inf.datePickerOpenStatus[date] = true;
        }
        
        function clr() {
        	console.log("infoController CANCEL");
        }
        
        function initController() {
        	console.log("infoController LOADED....");
        }
    }
})();