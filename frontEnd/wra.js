// TODO add click counter
// TODO random article
// TODO add styles


(function($) {
    const restURL = "http://localhost:8080/links/";



    $(document).ready(function() {
        var resultsContainer = $('#resultsContainer');
        var urlInput = $('#urlInput');
        var submitButton = $('#submitButton');
        console.log("in main function");

        // Prevent enter button from submitting form incorrectly
        $(window).keydown(function(event) {
            if (event.keyCode == 13) {
                event.preventDefault();
                $('#resultsContainer').empty();
                getResultsByUrl(urlInput.val());
            }
        });

        submitButton.click(function(e) {
            // Ajax call to the REST service goes here
            console.log(urlInput.val());
            $('#resultsContainer').empty();
            getResultsByUrl(urlInput.val());

        });


    });

    // Makes Ajax call to REST service and displays the results on the
    // web page.
    function getResultsByUrl(searchTerm) {
        var url = restURL + searchTerm;
        console.log(url);
        var list = $('<ul>');
        list.addClass("list-group");


        $.ajax({
            url: url,
            dataType: 'json',
            success: function(result) {
                for (var i = 0; i < result.links.length; i++) {
                    var aLink = $('<a>', {
                        text: result.links[i].title,
                        id: i,
                        class: 'link list-group-item col-xs-6',
                        href: '#'
                    });
                    aLink.data("url", result.links[i].url);
                    aLink.click(function() {
                        testFun(this);
                        getNewResults(this);
                    });
                    $('<li>').html(aLink).appendTo(list);

                }
            }

        });

        list.appendTo(resultsContainer);

    }

    // Function that is called when a link on the screen is pressed
    function getNewResults(clickedObject) {
        // Get url from clickedObject
        var url = $('#' + clickedObject.id).data("url");

        // get searchTerm from url by calling getSearchTermFromURL
        var searchTerm = getSearchTermFromURL(url);

        // Clear previous results
        $('#resultsContainer').empty();

        // put search term in the input box
        $('#urlInput').val(searchTerm);

        // get new links from new searchTerm from getResultsByUrl
        getResultsByUrl(searchTerm);
    }

    // Gets last part of the the Wikipedia URL.
    function getSearchTermFromURL(url) {
        return url.split('/').pop();
    }




    // Test functions
    function testFun(object) {
        // Gets url from link tag that was clicked.
        // TODO use URL to make new call and display results
        var objectId = object.id;
        $('#' + objectId);
        console.log($('#' + objectId).data("url"));
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
