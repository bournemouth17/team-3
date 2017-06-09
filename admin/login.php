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
