<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="doPredict" method="post">





		<div class="section-title text-left">
			<h3>请输入你的手机号</h3>
			<!--<p class="white-text">Duis aute irure dolor in reprehenderit in voluptate</p>-->
		</div>


		<input type="text" class="form-control" placeholder="Your Phone *"
			id="phone" name="phone" required
			data-validation-required-message="Please enter your phone number.">
		<p class="help-block text-danger"></p>


		<div class="col-lg-12 text-left">
			<div id="success"></div>
			<input type="submit" class="btn btn-primary" value="  确         定  " />
		</div>


	</form>
</body>
</html>