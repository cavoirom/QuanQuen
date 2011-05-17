<%@page import="java.util.LinkedList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="quanquen.model.Place" %>
<%@page import="quanquen.model.Category" %>
<%@page import="quanquen.model.Article" %>
<%@page import="quanquen.model.Address" %>
<%@page import="quanquen.model.Member" %>
<%@page import="quanquen.model.Comment" %>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="quanquen.model.Image"%>
<%Place place = (Place)request.getAttribute("place");%>
<div id="content">
	<div class="information">
		<div>
			<a href="<%=place.getImages().iterator().next().getUrl()%>" rel="lightbox" title="<%=place.getImages().iterator().next().getDescription()%>"><img src="<%=place.getImages().iterator().next().getUrl()%>"/></a>
			<%if (place.getImages().size() > 0){%>
			
			<ul class="images">
				<li><a href="javascript:void()" class="back">Sau</a></li>
			<%
			LinkedList<Image> images = place.getImages();
			for (int i=0; i<images.size();i++){
				Image image = images.iterator().next();
			%>
				<li><a href="<%=image.getUrl()%>" rel="lightbox[roadtrip]"><img src="<%=image.getUrl()%>"/></a></li>
			<%}}%>
				<li><a href="javascript:void()" class="next">Kế</a></li>
			</ul>
			<ul class="category">
				<li>Chức năng: </li>
				<li><a href="#">Tải hình lên</a></li>
				<li><a href="#">Đăng ký quản lý</a></li>
				<li><a href="#">Tùy chỉnh</a></li>
			</ul>
		</div>
		<h3><%=place.getName()%></h3>
		<p>Số lần truy cập: <%=place.getNumberOfVisited()%></p>
		<p>Số bài viết: <%=place.getArticles().size()%></p>
		<ul class="category">
			<li>Thể loại: </li>
		<%LinkedHashSet<Category> categories = place.getCategories();
		for (int i=0; i<categories.size();i++){
			Category category = categories.iterator().next();
		%>
			<li><a href ="category?id=<%=category.getId()%>"><%=category.getTitle()%></a></li>
		<%}%>
		</ul>
		<p>Địa chỉ: <%=place.getAddress().toString()%></p>
		<p>Website: <%=place.getWebsite()%></p>
		<p>Điện thoại: <%=place.getTel()%></p>
		<p>Email: <%=place.getEmail()%></p>
		<p>Fax: <%=place.getFax()%></p>
		<p>Khoảng giá: <%=place.getPrice()%></p>
		<p >Phương thức thanh toán: <%=place.getCheckoutMethod()%></p>
		<ul class="category">
			<li>Quản lý bởi (<%=place.getManagers().size()%>):</li>
		<%LinkedHashSet<Member> members = place.getManagers();
		for (int i=0;i<members.size();i++){
			Member member = members.iterator().next();
		%>	
			<li><a href ="user?u=<%=member.getUsername()%>"><%=member.getUsername()%></a></li>
		<%}%>
		</ul>
		<p>Ngày đăng: <%=place.getPostedDateString()%></p>
		<p >Cập nhật lần cuối: <%=place.getLastUpdateString()%></p>
		<ul class="category">
			<li>Thành viên thích (<%=place.getMembersLikeThis().size()%>):</li>
		<%LinkedHashSet<Member> likes = place.getMembersLikeThis();
		for (int i=0;i<likes.size();i++){
			Member member = likes.iterator().next();
		%>	
			<li><a href ="user?u=<%=member.getUsername()%>"><%=member.getUsername()%></a></li>
		<%}%>		
		</ul>
		
	</div>
	<div class="clear"></div>
	<div class="articles">
	<%
		LinkedHashSet<Article> articles = place.getArticles();
		for (int i=0; i< articles.size(); i++){
			Article article = articles.iterator().next();
	%>
		<%@include file="include_article.jsp"%>
	<%}%>
	</div>
</div>    
