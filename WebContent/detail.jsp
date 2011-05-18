<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("ul",request.getRequestURL());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quán Quen | Chi Tiết</title>
<link rel="stylesheet" href="stylesheets/lightbox.css" type="text/css" media="screen"/>
<link href="stylesheets/styles.css" rel="stylesheet" type="text/css"/>
<link href="stylesheets/detail.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="clientscripts/lightbox/prototype.js"></script>
<script type="text/javascript" src="clientscripts/lightbox/scriptaculous.js?load=effects,builder"></script>
<script type="text/javascript" src="clientscripts/lightbox/lightbox.js"></script>
</head>
<body>
<a href="images/place/default.jpg" rel="lightbox">testest</a>
<div id="wrapper">
	<%@include file="include_header.jsp" %>
	<%@include file="include_detail.jsp" %>
	<%@include file="include_footer.jsp" %>
</div><!--End wrapper-->
</body>
</html>