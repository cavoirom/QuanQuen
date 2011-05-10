<%@ page contentType="text/html; charset=UTF-8"%>
<% String cat = request.getParameter("cat");
if (cat == null) cat = "";

// check authorization status
boolean isAdminAuthorized;
if (session.getAttribute("isAdminAuthorized") == null)
	isAdminAuthorized = false;
else
	isAdminAuthorized = (Boolean) session.getAttribute("isAdminAuthorized");
%>
<% if (isAdminAuthorized && request.getRequestURI().endsWith("home.jsp")) { %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr" lang="vi">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<meta name="lang" content="vi"/>
	<title>Quán Quen - Trang quản lý</title>
	<link rel="shortcut icon" href="../favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="layout.css"/>
</head>

<body>
	<div id="HeaderBar"></div>
	<div id="PageContainer">
		<div id="HeaderContainer">
			<div id="LogoContainer"><div class="pageLogo">Quán Quen</div></div>
			<div id="TitleContainer">
				<span class="menuTitle">
					<% if ((cat.equals("") || cat.equals("gen"))
						&& isAdminAuthorized) { %>
					Thông tin tổng quan
					<% } else if (cat.equals("mem") && isAdminAuthorized) { %>
					Thông tin thành viên
					<% } else { %>
					Blank
					<% } %>
				</span>
			</div>
			
		</div>
		<div id="MainContainer">
			<div id="SideContainer">
				<ul>
					<li class="generalButton <% if(cat.equals("gen") || cat.equals("")) { %>selected<% } %>">
						<a href="home.jsp?cat=gen">Tổng quan</a>
					</li>
					<li class="separator"></li>
					<li class="articleButton <% if(cat.equals("art")) { %>selected<% } %>">
						<a href="home.jsp?cat=art">Bài viết</a>
					</li>
					<li class="categoryButton <% if(cat.equals("cat")) { %>selected<% } %>">
						<a href="home.jsp?cat=cat">Chuyên mục</a>
					</li>
					<li class="commentButton <% if(cat.equals("cmt")) { %>selected<% } %>">
						<a href="home.jsp?cat=cmt">Bình luận</a>
					</li>
					<li class="placeButton <% if(cat.equals("plc")) { %>selected<% } %>">
						<a href="home.jsp?cat=plc">Địa điểm</a>
					</li>
					<li class="systemButton <% if(cat.equals("sýs")) { %>selected<% } %>">
						<a href="home.jsp?cat=sys">Hệ thống</a>
					</li>
					<li class="userButton <% if(cat.equals("mem")) { %>selected<% } %>">
						<a href="home.jsp?cat=mem">Thành viên</a>
					</li>
					<li class="separator"></li>
					<li class="logoutButton"><a href="logout.jsp">Thoát</a></li>
					<li class="separator"></li>
				</ul>
			</div>
			<div id="ContentContainer">
				<div id="MainContent">
					<% if ((cat.equals("") || cat.equals("gen"))
						&& isAdminAuthorized) { %>
					<jsp:include page="include.general.jsp" flush="true"/>
					<% } else if (cat.equals("mem") && isAdminAuthorized) { %>
					<jsp:include page="include.member.detail.jsp" flush="true"/>
					<% } else { %>
					<h1>Blank</h1>
					<% } %>
				</div>
			</div>
		<div id="FooterContainer">
			<div id="Copyright">2011 &copy; Quán Quen</div>
			<div id="ContactInfo">Liên Lạc</div>
		</div>
	</div>
	</div>
</body>
</html>
<% } else { 
	String errorCode = "404";
	request.setAttribute("errorCode", errorCode); %>
<jsp:include page="include.error.jsp" flush="true"/>
<% } %>