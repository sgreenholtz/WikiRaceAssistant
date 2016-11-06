(function($) {
        const restURL = "http://localhost:8080/links/";

        $(document).ready(function() {
            var urlInput = $('#urlInput');
            var submitButton = $('#submitButton');
            console.log("in main function");

            submitButton.click(function() {
                // Ajax call to the REST service goes here
                console.log(urlInput.val());
                getResultsByUrl(urlInput.val());

            });
        });

        function getResultsByUrl(searchTerm) {
            var resultsContainer = $('#resultsContainer');
            var url = restURL + searchTerm;
            console.log(url);
            var list = $('<ul>');


            $.ajax({
                    url: url,
                    dataType: 'json',
                    success: function(result) {
                        for (var i = 0; i < result.links.length; i++) {
                            var aLink = $('<a>', {
                                text: result.links[i].title,
                                href: result.links[i].url
                            });
                            $('<li>').html(aLink).appendTo(list);

                        }
                    }

                });

                list.appendTo(resultsContainer);


            }

            function testAjaxCall() {
                console.log("in test call");

                $.ajax({
                    url: "http://localhost:8080/links/Aeba_Koson",
                    dataType: 'json',
                    success: function(result) {
                            console.log(result.links);
                            console.log(result.links[0].title);
                            console.log(result.links[0].url);
                            console.log("Number of links: " + result.links.length);
                            for (var i = 0; i < result.links.length; i++) {
                                console.log(result.links[i].title);
                                console.log(result.links[i].url);
                            }
                        }
                        // crossDomain: true,
                });

            }
        })(jQuery);
