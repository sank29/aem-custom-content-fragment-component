function myButtonFunction() {`
	const servletResource = $(".my-button-component").data(
    "current-resource"
  );
      var settings = {
        url: servletResource + ".buttoncomponent.html",
        method: "POST",
      };
      $.ajax(settings)
        .done(function (response) {
          console.log("Success")
        })
        .fail((response) => {
          console.log("Failure")
        });
}
