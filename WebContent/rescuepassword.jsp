<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quán quen | Khôi phục mật khẩu</title>
<link href="stylesheets/styles.css" rel="stylesheet" type="text/css">
<style type="text/css">
	form#rescuepassword{
		width: 500px;
		margin: auto;
		display: block;
	}
	
	form#rescuepassword fieldset{
		border: none;
		margin: 20px 0px 10px;
	}
	
	form#rescuepassword fieldset input{
		width: 200px;
	}
	
	h1#mark{
		text-align: center;
		margin-top: 20px;
	}
	
	form#rescuepassword #sendpassword{
		display: block;
		width: 90px;
		margin: 10px auto;
			
	}
		
</style>
</head>
<body>
<div id="wrapper">

	<%@include file="include_header.jsp" %>
	<h1 id="mark">Khôi phục mật khẩu</h1>
	<form id="rescuepassword">
		<fieldset>
			<label for="email">Email bạn đã đăng ký</label>
			<input id="email" name="email" type="text"/>
		</fieldset>
		
		<input type="button" value="Gửi mật khẩu" id="sendpassword"/>
	</form>
	<%@include file="include_footer.jsp" %>

</div><!--End wrapper-->
</body>
</html>