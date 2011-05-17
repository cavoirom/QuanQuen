<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%session.setAttribute("ul",request.getRequestURI());%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quán Quen | Thể Loại</title>
<link href="stylesheets/styles.css" rel="stylesheet" type="text/css">
<link href="stylesheets/quanquen.css" rel="stylesheet" type="text/css">
<link href="stylesheets/places.css" rel="stylesheet" type="text/css">
<link href="stylesheets/place.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="clientscripts/slideshow.js"></script>
<script type="text/javascript" src="clientscripts/jquery-1.5.1.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {		
		slideshowcategory = new SlideShow("#topplace");
	});
</script>
</head>
<body>
<div id="wrapper">

	<%@include file="include_header.jsp"%>
	<%@include file="include_places.jsp"%>
	<%@include file="include_footer.jsp"%>

</div><!--End wrapper-->
</body>
</html>