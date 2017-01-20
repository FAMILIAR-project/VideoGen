(function() {
    'use strict';

    angular
        .module('videoGenApp')
        .controller('VideogenController', VideogenController);

    VideogenController.$inject = ['$scope', 'Principal', 'LoginService', 'VideogenService', '$state'];

    function VideogenController($scope, Principal, LoginService, VideogenService, $state) {
        var vm = this;
        vm.getVideos = getVideos;
        vm.videos = {};
        vm.playlist = [];
        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.videos = null;
        vm.register = register;
        vm.generate = generate;
        vm.configVideoSelected = configVideoSelected;
        vm.mode = "random";
        vm.checkStart = checkStart;
        vm.generateGif = generateGif;
        vm.gifPath = '';
        vm.text = "";
        vm.textPosition = "bottom";
        vm.addText = addText;

        function getVideos() {
            VideogenService.getVideogen().then(function(data) {
                var tmp = {};
                angular.forEach(data.data, function(value, key) {
                    if (!(value in tmp)) {
                        tmp[value] = {};
                    }
                    tmp[value][key] = {}
                    if (checkStart("mandatory", value)) {
                        tmp[value][key]["selected"] = true;
                        tmp[value][key]["text"] = false;
                    } else {
                        tmp[value][key]["selected"] = false;
                        tmp[value][key]["text"] = false;
                    }
                });
                vm.videos = tmp
                console.log(vm.videos)
            });
        }

        function register() {
            $state.go('register');
        }

        function generate() {

            switch (vm.mode) {
                case 'random':
                    var tab = [];
                    if (vm.text != "") {
                        angular.forEach(vm.videos, function(value, key) {
                            angular.forEach(value, function(value2, key2) {
                                if (value2["text"]) this.push(key2);
                            }, tab);
                        });
                    }
                    if (tab.length == 0) tab.push("null")
                    VideogenService.generatePlaylist(vm.text, vm.textPosition, tab).then(function(data) {
                        var tmp = [];
                        angular.forEach(data.data, function(value) {
                            this.push(value)
                        }, tmp)
                        vm.playlist = tmp;
                        console.log(vm.playlist);
                        vm.test = "huyt";
                    })
                    break;
                case 'config':
                    var tab = [];
                    var tab2 = [];
                    angular.forEach(vm.videos, function(value, key) {
                        angular.forEach(value, function(value2, key2) {
                            if (value2["selected"]) this.push(key2);
                            if (value2["text"]) tab2.push(key2);
                        }, tab);
                    });
                    if (tab2.length == 0) tab2.push("null")
                    VideogenService.generatePlaylistFromUserChoices(tab, vm.text, vm.textPosition, tab2).then(function(data) {
                        var tmp = [];
                        angular.forEach(data.data, function(value) {
                            this.push(value)
                        }, tmp)
                        vm.playlist = tmp;
                        console.log(vm.playlist);
                    })

                    break;
            }

        }

        function configVideoSelected(type, val) {
            if (vm.mode == "config") {
                if (checkStart("alternative", type)) {
                    angular.forEach(vm.videos[type], function(value, key) {
                        if (key == val) {
                            vm.videos[type][val]["selected"] = !vm.videos[type][val]["selected"]
                        } else {
                            vm.videos[type][key]["selected"] = false;
                        }
                    });
                } else if (checkStart("optional", type)) {
                    vm.videos[type][val]["selected"] = !vm.videos[type][val]["selected"];
                }
            }
        }

        function addText(type, val) {
            vm.videos[type][val]["text"] = !vm.videos[type][val]["text"];
        }


        function generateGif() {
            VideogenService.generateGif(vm.playlist).then(function(data) {
                vm.gifPath = data.data['gifPath'];
                console.log("generate gif " + data.data)
            })
        }

        function checkStart(type, value) {
            var lowerStr = (value + "").toLowerCase();
            return lowerStr.indexOf(type.toLowerCase()) === 0;
        }
    }
})();
