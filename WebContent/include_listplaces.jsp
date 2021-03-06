<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="quanquen.model.Place"%> 
<%@ page import="quanquen.model.Category"%>
<%@ page import="quanquen.model.Member"%>  
<%
	List<Place> places = (List<Place>) request.getAttribute("places");
	if (places != null && places.size() > 0){
	for (int i=0; i<places.size(); i++){
		Place place = places.get(i);
%>
		<div class="places">
			<a href="#"><img src="<%=place.getImages().getFirst().getUrl()%>" alt="" width="120" height="120"/></a>
			<h3><a href="place?id=<%=place.getId()%>"><%=place.getName()%></a></h3>
			<ul class="category">
				<li>Thể loai: </li>
				<%
				Iterator<Category> categories = place.getCategories().iterator();
				while (categories.hasNext()){
					Category category = categories.next();
				%>
					<li><a href="search?type=category&searchvalue=<%=category.getTitle()%>"><%=category.getTitle()%></a></li>
				<%}%>
			</ul>
			<p class="address">Địa chỉ: <%=place.getAddress().toString()%></p>
			<ul class="category">
				<li>Người quản lý: </li>
				<%
				Iterator<Member> managers = place.getManagers().iterator();
				while (managers.hasNext()){
					Member member = managers.next();
				%>
					<li><a href="search?type=author&searchvalue=<%=member.getUsername()%>"><%=member.getUsername()%></a></li>
				<%}%>
			</ul>
			<div class="statistics">
				<p class="numberarticle">Số bài viết: <span><%=place.getArticles().size()%></span></p>
				<p class="numberclicked">Số lần truy cập: <span><%=place.getNumberOfVisited()%></span></p>
			</div>
		</div>
<%}}else{%>
<h3 class="mark">Không tìm thấy</h3>
<%}%>	