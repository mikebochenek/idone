<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>Hello World!</title>
	<meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" />
	<link rel="stylesheet" type="text/css" href="consumer-servlet.css" />
	<script type="text/javascript">
	<!--
	function changeAll(v) {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].value == v) {
				inputs[i].checked = true;
			}
		}
	}
	//-->
	</script>
</head>
<body>
	<div>
			<h3>Sample 1:</h3>
			<form action="consumer" method="post">
				<div>
					<input type="text" name="openid_identifier" />
				</div>
				<div>
					<button type="submit" name="login">Login</button>
				</div>
			</form>
	</div>
</body>
</html>