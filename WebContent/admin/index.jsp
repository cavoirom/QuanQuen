<%@page pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
//Setup variable for session. Note: Session was created automatic.
String username = (String) session.getAttribute("username");
if (username == null) username = "";

// check authorization status
boolean isAdminAuthorized;
if (session.getAttribute("isAdminAuthorized") == null)
	isAdminAuthorized = false;
else
	isAdminAuthorized = (Boolean) session.getAttribute("isAdminAuthorized");

// error message
String errorMessage="";
String loginStatus = request.getParameter("status");
if (loginStatus == null)
	loginStatus = "";
if (loginStatus.equals("false")) {
	errorMessage="Thông tin đăng nhập chưa chính xác.";
}
%>

<% if (isAdminAuthorized) {
	response.sendRedirect("home.jsp");
} else { %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="vi">
<!--
Author:		cavoirom
Email:		cavoirom@yahoo.com
Created:		2th April, 2011
***************************************************
Please don't delete this infomation.
***************************************************
This file display login form of admin panel.
-->
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta name="lang" content="vi"/>
	<title>Trang quản lý - Quán Quen</title>
	<link rel="shortcut icon" href="../favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="layout.css"/>
	<script language="javascript" src="webtoolkit.info.md5.js"></script>
</head>

<body>
	<div id="LoginFormContainer">
	<form method="post" action="login.jsp">
		<div id="LoginForm">
			<div class="formTitle">Quán Quen - Trang quản lý</div>
			<div class="floatLeft wrapper">
				<label for="Username" class="inputLabel">Tài khoản</label><br/>
				<input type="text" size="20" id="Username" name="username" value="<%= username %>"/>
			</div>
			<div class="floatRight wrapper">
				<label for="Password" class="inputLabel">Mật khẩu</label><br/>
				<input type="password" size="20" id="Password" name="password"/>
			</div>
			<div class="floatLeft wrapper">
				<input type="checkbox" id="RememberPassword" name="rememberPassword"/><label for="RememberPassword" class="rmbLabel">Nhớ mật khẩu.</label>
			</div>
			<div class="floatRight wrapper">
				<input type="submit" value="Đăng nhập" class="smButton" onclick="this.form.password.value = MD5(this.form.password.value)"/>
			</div>
			<div class="clear"></div>
			<div class="errorMessage"><%= errorMessage %></div>
		</div>
	</form>
		<div id="Copyright">2011 &copy; Quán Quen</div>
		<div id="ContactInfo">Liên lạc</div>
	</div>
</body>

</html>
<% } %>