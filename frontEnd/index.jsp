<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Wiki Race Assistant</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7" crossorigin="anonymous"></script>
    <script src="wra.js" charset="utf-8"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/css/bootstrap.min.css" integrity="sha384-AysaV+vQoT3kOAXZkl02PThvDr8HYKPZhNT5h/CXfBThSRXQ6jW5DO2ekP5ViFdi" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="styles.css">
</head>

<body>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-3">Welcome to the Wiki Race Assistant!</h1>
            <p class="lead">To get started, enter the last part of your Wikipedia url below.</p>
        </div>
    </div>

    <div class="container">
        <div id="errorContainer" class="row hidden">
            <div class="col-xs-12">
                <div class="alert alert-danger" role="alert">
                    <strong>Oh no!</strong> The url you entered is invalid.
                </div>
            </div>
        </div>

        <form>
            <div class="form-group row">
                <label for="urlInput" class="col-xs-3 col-form-label text-right">Enter URL term:</label>
                <div class="col-xs-5">
                    <input class="form-control" type="text" id="urlInput" />
                </div>
                <div class="col-xs-2">
                    <button type="button" class="btn btn-primary" id="submitButton">Submit</button>
                </div>
            </div>
        </form>

    </div>

    <div class="container">
        <div id="resultsContainer">

        </div>
    </div>



    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
</body>

</html>
