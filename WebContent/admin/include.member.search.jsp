<%@ page contentType="text/html; charset=UTF-8"%>
<%
	import quanquen.model.*;

	// check authorization status
	boolean isAdminAuthorized;
	if (session.getAttribute("isAdminAuthorized") == null)
		isAdminAuthorized = false;
	else
		isAdminAuthorized = (Boolean) session
				.getAttribute("isAdminAuthorized");
	List<Member> result = (List<Member>) session.getAttribute("searchMemberResult");
	if (result == null) {
		result = new List<Member>();
	}
%>
<%
	if (isAdminAuthorized
			&& request.getRequestURI().endsWith("home.jsp")) {
%>
<div class="listLabel">Tìm kiếm thành viên</div>
<form action="searchmember.jsp" method="post">
	<div class="listWrapper">
		<div class="itemWrapper">
			<span class="itemLabel"><label for="Username">Tên tài khoản:</label></span>
			<span class="itemValue"><input type="text" size="20" id="Username" name="keyword" /></span>
		</div>
		<div class="itemWrapper">
			<span class="itemLabel"></span>
			<span class="itemValue"><input type="submit" value="Tìm kiếm" /></span>
		</div>
	</div>
</form>
<% 

%>
<%
	} else {
		String errorCode = "404";
		request.setAttribute("errorCode", errorCode);
%>
<jsp:include page="include.error.jsp" flush="true" />
<%
	}
%>