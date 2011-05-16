<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("ul","contact.jsp");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quán quen | Liên hệ</title>
<link href="stylesheets/styles.css" rel="stylesheet" type="text/css">
</head>
<body id="contact">
<div id="wrapper">
	<%@include file="include_header.jsp" %>
	<div id="content">
		<p class="mark">Mọi chi tiết xin liên hệ quanquen.com</p>
		<p class="mark" style="padding-bottom: 300px;">Mọi đóng góp ý kiến xin gửi về admin@quanquen.com</p>
	</div>
	<%@include file="include_footer.jsp" %>
</div><!--End wrapper-->
</body>
</html>