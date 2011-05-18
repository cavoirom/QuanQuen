<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%session.setAttribute("ul","index.jsp");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quán quen | Trang nhất</title>
<link href="stylesheets/styles.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="clientscripts/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="clientscripts/slideshow.js"></script>
<script type="text/javascript">

$(document).ready(function() {		
	slideshowmainbox = new SlideShow('#contentmainbox');
	slideshowsubbox = new SlideShow('#contentsubbox2');

});
</script>

</head>
<body id="homepage">
<div id="wrapper">

	<%@include file="include_header.jsp" %>
	<%@include file="include_index.jsp" %>
	<%@include file="include_footer.jsp" %>

</div><!--End wrapper-->
</body>
</html>