<%@ page contentType="text/html; charset=UTF-8"%>
<% // check authorization status
boolean isAdminAuthorized;
if (session.getAttribute("isAdminAuthorized") == null)
	isAdminAuthorized = false;
else
	isAdminAuthorized = (Boolean) session.getAttribute("isAdminAuthorized");
%>
<% if (isAdminAuthorized && request.getRequestURI().endsWith("home.jsp")) { %>
<div class="listLabel">Static</div>
<div class="listWrapper">
	<div class="itemWrapper"><span class="itemLabel">places:</span><span class="itemValue">1824</span></div>
	<div class="itemWrapper"><span class="itemLabel">users:</span><span class="itemValue">4283</span></div>
	<div class="itemWrapper"><span class="itemLabel">categories:</span><span class="itemValue">22</span></div>
	<div class="itemWrapper"><span class="itemLabel">articles:</span><span class="itemValue">1466</span></div>
	<div class="itemWrapper"><span class="itemLabel">comments:</span><span class="itemValue">2847</span></div>
</div>
<div class="listLabel">System</div>
<div class="listWrapper">
	<div class="itemWrapper"><span class="itemLabel">Title:</span><span class="itemValue">Quán Quen</span></div>
	<div class="itemWrapper"><span class="itemLabel">Tagline:</span><span class="itemValue">None</span></div>
</div>
<% } else { 
	String errorCode = "404";
	request.setAttribute("errorCode", errorCode); %>
<jsp:include page="include.error.jsp" flush="true"/>
<% } %>