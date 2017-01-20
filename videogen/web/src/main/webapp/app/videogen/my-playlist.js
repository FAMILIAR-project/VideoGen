angular.module('videoGenApp')
    .directive('myPlaylist', function() {
        return {
            restrict: 'A',
            link: function(scope, el, attr) {
                //$(el).parsley();
                var myPlaylist = [];
                var set = false;
                console.log("binded")
                scope.$watch(attr.videos, function(data) {
                    if (!isEmpty(data)) {
                        var tmp = [];
                        angular.forEach(data, function(value) {
                            var path = "data/videos/" + value.substr(value.lastIndexOf('/') + 1)
                            this.push(path);
                        }, tmp)
                        myPlaylist = tmp;
                        console.log(myPlaylist);

                        flowplayer(function(api, root) {
                            api.on("error", function(e, api, err) {
                                if (err.code === 4) { // Video file not found
                                    // reset state
                                    api.error = api.loading = true;

                                    $(root).removeClass("is-error");

                                    // optional: change timeline color to alert user
                                    $(root).addClass("replacement");

                                    // load safe replacement video sources
                                    api.load({
                                        sources: myPlaylist
                                    }, function(e, api) {
                                        // optional: notify user
                                        api.message("Replacement video!");
                                    });

                                }
                            })

                        });
                        if (set) {
                            flowplayer(el).stop();
                            flowplayer(el).setPlaylist(myPlaylist);
                        } else {
                            flowplayer(el, {
                                playlist: myPlaylist
                            });
                        }
                        set = true;

                    }
                });
            }
        };

        function isEmpty(obj) {
            for (var prop in obj) {
                if (obj.hasOwnProperty(prop)) return false;
            }
            return true;
        }
    });
