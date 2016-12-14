(function () {
    'use strict';
 
    angular
        .module('app.infoController',[])
        .controller('infoController', infoController);
    infoController.$inject = ['$timeout','$location', '$window', 'AuthenticationService','Info', 'SharedDataService'];
    function infoController($timeout, $location, $window, AuthenticationService, Info, SharedDataService) {
        var inf = this;
        inf.user ={};
        inf.user.info = {};
        initController();
        inf.save = save;
        inf.datePickerOpenStatus = {};
        inf.openCalendar = openCalendar;

        function save() {
        	inf.isSaving = true;
            Info.save(inf.user.info, onSaveSuccess, onSaveError);
        }
        
        function onSaveSuccess (result) {
        	console.log('SUCCESS !');
            inf.isSaving = false;
        }

        function onSaveError () {
        	console.log('ERROR !!');
            inf.isSaving = false;
        }
        
        inf.datePickerOpenStatus.sdate = false;
        inf.datePickerOpenStatus.edate = false;

        function openCalendar (date) {
            inf.datePickerOpenStatus[date] = true;
        }
        
        function initController() {
        	console.log('INFO');
        	inf.user.info = SharedDataService.getData();
        }
    }
})();