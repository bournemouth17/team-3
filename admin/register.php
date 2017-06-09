<?php
	ob_start();
	session_start();
	if (isset($_SESSION['user']) != "") {
		header("Location: home.php");
	}
	include_once 'dbconnect.php';

	$error = false;
	$nameError = ".";
	$passError = ".";

	if (isset($_POST['btn-signup'])) {
		$name = trim($_POST['name']);
		$name = strip_tags($name);
		$name = htmlspecialchars($name);

		$pass = trim($_POST['pass']);
		$pass = strip_tags($pass);
		$pass = htmlspecialchars($pass);

		if (empty($name)) {
			$error = true;
			$nameError = "Please enter your username.";
		} else if (strlen($name) < 3) {
			$error = true;
			$nameError = "Name must have at least 3 characters.";
		} else if (!preg_match("/^[a-zA-Z ]+$/", $name)) {
			$error = true;
			$nameError = "Name must contain alphabets only";
		}

		if (empty($pass)) {
			$error = true;
			$passError = "Please enter password.";
		} else if (strlen($pass) < 6) {
			$error = true;
			$passError = "Password must have at least 6 characters.";
		}

		$password = hash('sha256', $pass);

		if (!$error) {
			$query = "INSERT INTO Admin(Username, Password) VALUES ('$name', '$password')";
			$res = mysql_query($query);

			if ($res) {
				$errType = "success";
				$errMessage = "Successfully registered - you can log in now!";
				unset($name);
				unset($pass);
			} else {
				$errType = "danger";
				$errMessage = "Something went wrong, try again.";
			}
		}
	}
?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Rubicon - Register</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css"  />
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

<div class="container">

 <div id="login-form">
    <form method="post" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" autocomplete="off">

     <div class="col-md-12">

         <div class="form-group">
             <h2 class="">Sign Up</h2>
            </div>

         <div class="form-group">
             <hr />
            </div>

            <?php
   if ( isset($errMSG) ) {

    ?>
    <div class="form-group">
             <div class="alert alert-<?php echo ($errTyp=="success") ? "success" : $errTyp; ?>">
    <span class="glyphicon glyphicon-info-sign"></span> <?php echo $errMSG; ?>
                </div>
             </div>
                <?php
   }
   ?>

            <div class="form-group">
             <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
             <input type="text" name="name" class="form-control" placeholder="Enter Name" maxlength="50" value="<?php echo $name ?>" />
                </div>
                <span class="text-danger"><?php echo $nameError; ?></span>
            </div>

            <div class="form-group">
             <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
             <input type="password" name="pass" class="form-control" placeholder="Enter Password" maxlength="15" />
                </div>
                <span class="text-danger"><?php echo $passError; ?></span>
            </div>

            <div class="form-group">
             <hr />
            </div>

            <div class="form-group">
             <button type="submit" class="btn btn-block btn-primary" name="btn-signup">Sign Up</button>
            </div>

            <div class="form-group">
             <hr />
            </div>

            <div class="form-group">
             <a href="index.php">Sign in</a>
            </div>

        </div>

    </form>
    </div>

</div>

</body>
</html>
<?php ob_end_flush(); ?>
