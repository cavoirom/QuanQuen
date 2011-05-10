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
<% if (isAdminAuthorized) { %>
<jsp:include page="include.cpanel.jsp" flush="true"/>
<% } else {
String errorCode = "700";
request.setAttribute("errorCode", errorCode); %>
<jsp:include page="include.error.jsp" flush="true"/>
<% } %>