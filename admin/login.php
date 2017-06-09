<?php
	ob_start();
	session_start();
	require_once 'dbconnect.php';

	if (isset($_SESSION['user']) != "") {
		header("Location: home.php");
		exit;
	}

	$error = false;
	 if (isset($_POST['btn-login'])) {
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
			$passError = "Please enter your password";
		}

		if (!$error) {
			$password = hash('sha256', $pass);
			$res = mysql_query("SELECT ID, Password FROM Admin WHERE Username='$name'");
			$row = mysql_fetch_array($res);
			$count = mysql_num_rows($res);

			if ($count == 1 && $row['Password'] == $password) {
				$_SESSION['user'] = $row['ID'];
				header("Location: home.php");
			} else {
				$errorMessage = "Incorrect credentials!";
			}
		}
	 }
?>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Coding Cage - Login & Registration System</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css"  />
<link rel="stylesheet" href="style.css" type="text/css" />
</head>
<body>

<div class="container">

 <div id="login-form">
    <form method="post" action="<?php echo htmlspecialchars($_SERVER['PHP_SELF']); ?>" autocomplete="off">

     <div class="col-md-12">

         <div class="form-group">
             <h2 class="">Sign In.</h2>
            </div>

         <div class="form-group">
             <hr />
            </div>

            <?php
   if ( isset($errMSG) ) {

    ?>
    <div class="form-group">
             <div class="alert alert-danger">
    <span class="glyphicon glyphicon-info-sign"></span> <?php echo $errMSG; ?>
                </div>
             </div>
                <?php
   }
   ?>

            <div class="form-group">
             <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span></span>
             <input type="text" name="name" class="form-control" placeholder="Username: " value="<?php echo $name; ?>" maxlength="40" />
                </div>
                <span class="text-danger"><?php echo $emailError; ?></span>
            </div>

            <div class="form-group">
             <div class="input-group">
                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
             <input type="password" name="pass" class="form-control" placeholder="Password: " maxlength="15" />
                </div>
                <span class="text-danger"><?php echo $passError; ?></span>
            </div>

            <div class="form-group">
             <hr />
            </div>

            <div class="form-group">
             <button type="submit" class="btn btn-block btn-primary" name="btn-login">Sign In</button>
            </div>

            <div class="form-group">
             <hr />
            </div>

            <div class="form-group">
             <a href="register.php">Sign Up Here...</a>
            </div>

        </div>

    </form>
    </div>

</div>

</body>
</html>
<?php ob_end_flush(); ?>
