(function($) {

  $(document).ready(function() {
      var urlInput = $('#urlInput');
      var submitButton = $('#submitButton');
      console.log("in main function");

      submitButton.click(function() {
          // Ajax call to the REST service goes here
          testAjaxCall();

      });
  })



  function testAjaxCall() {
      console.log("in test call");

      $.ajax({url: "http://localhost:8080/links/hitler", success: function(result){
            console.log(result);
        },
        crossDomain: true,
    });

  }
})(jQuery)
