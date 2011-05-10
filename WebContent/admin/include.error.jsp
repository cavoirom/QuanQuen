<%@page pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% // Error type
String c700 = "Permission Denined.<br/>Plz <a href=\"index.jsp\">login</a> to view this page.";
String c404 = "Page not found!";
String errorMessage;
int errorCode;
String tmp1 = (String) request.getAttribute("errorCode");

if (tmp1 == null) {
	errorCode = 404;
}
else {
	errorCode = Integer.parseInt(tmp1);
}
if (errorCode == 404) {
	errorMessage = c404;
}
else if (errorCode == 700) {
	errorMessage = c700;
}
else {
	errorMessage = c404;
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="vi">

<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta name="lang" content="vi"/>
	<title><%= errorCode %> - Quán Quen</title>
	<link rel="shortcut icon" href="../favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="layout.css"/>
</head>

<body>
	<div id="ErrorContainer">
		<div id="Error">
			<div class="errorName">Warning!</div>
			<div class="errorContent"><%= errorMessage %></div>
		</div>
		<div id="Copyright">2011 &copy; Quán Quen</div>
		<div id="ContactInfo">Liên lạc</div>
	</div>
</body>

</html>