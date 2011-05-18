<%@page import="java.util.Iterator"%>
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
			Iterator<Image> images = place.getImages().iterator();
			while(images.hasNext()){
				Image image = images.next();
			%>
				<li><a href="<%=image.getUrl()%>" rel="lightbox[roadtrip]"><img src="<%=image.getUrl()%>"/></a></li>
			<%}}%>
				<li><a href="javascript:void()" class="next">Kế</a></li>
			</ul>
			<ul class="category">
				<li></li>
				<li><a href="#">Tải hình lên</a></li>
			</ul>
		</div>
		<h3><%=place.getName()%></h3>
		<p>Số lần truy cập: <%=place.getNumberOfVisited()%></p>
		<p>Số bài viết: <%=place.getArticles().size()%></p>
		<ul class="category">
			<li>Thể loại: </li>
		<%Iterator<Category> categories = place.getCategories().iterator();
		while(categories.hasNext()){
			Category category = categories.next();
		%>
			<li><a href ="search?type=category&searchvalue=<%=category.getTitle()%>"><%=category.getTitle()%></a></li>
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
		<%Iterator<Member> members = place.getManagers().iterator();
		while (members.hasNext()){
			Member member = members.next();
		%>	
			<li><a href ="user?u=<%=member.getUsername()%>"><%=member.getUsername()%></a></li>
		<%}%>
		</ul>
		<p>Ngày đăng: <%=place.getPostedDateString()%></p>
		<p >Cập nhật lần cuối: <%=place.getLastUpdateString()%></p>
		<ul class="category">
			<li>Thành viên thích (<%=place.getMembersLikeThis().size()%>):</li>
		<%Iterator<Member> likes = place.getMembersLikeThis().iterator();
		while(likes.hasNext()){
			Member member = likes.next();
		%>	
			<li><a href ="user?u=<%=member.getUsername()%>"><%=member.getUsername()%></a></li>
		<%}%>		
		</ul>
		<ul class="category" id="placetools">
			<li></li>
			<li><a href="javascript:void()">Thích</a></li>
			<li><a href="#">Đăng ký quản lý</a></li>
			<li><a href="#">Đăng bài</a></li>
			<li><a href="#">Chia sẻ</a></li>
			<li><a href="#">Tùy chỉnh</a></li>
			<li><a href="#">Báo xấu</a></li>
		</ul>
	</div>
	<div class="clear"></div>
	<div class="articles">
	<%
		Iterator<Article> articles = place.getArticles().iterator();
		while(articles.hasNext()){
			Article article = articles.next();
	%>
		<div class="article">
	<div class="infoauthor">
		<img alt="" src="<%=article.getAuthor().getAvatar().getUrl()%>"/>
		<p class="mark"><%=article.getAuthor().getUsername()%></p>
		<p class="mark">Offline/Online</p>
		<p class="mark"><a href="articles?u=<%=article.getAuthor().getUsername()%>">Số bài viết (<%=article.getAuthor().getArticles().size()%>)</a></p>
		<p class="mark">Ngày tham gia: <%=article.getAuthor().getJoinedDateString()%></p>
		<p class="mark"><a href="addfriend?u=<%=article.getAuthor().getUsername()%>">Kết bạn</a></p>
	</div>
	<p class="contentarticle"><%=article.getContent()%></p>
	<div class="sendcomment">
			<form action="postcomment">
				<textarea rows="2" cols="20" title="Gửi phản hồi"></textarea>
				<input type="button" value="Gửi"/>
			</form>
		</div>
	<div class="tools">
		<ul class="category">
		<li></li>
		<li><a href="viewcomment?article=<%=article.getId()%>">(<%=article.getComments().size()%>) Phản hồi</a></li>
		<li><a href="like?article=<%=article.getId()%>">(<%=article.getMembersLikeThis().size()%>) Thích</a></li>
		<li><a href="send?article=<%=article.getId()%>">Gửi cho bạn bè</a></li>
		<li><a href="black?article=<%=article.getId()%>">Báo xấu</a></li>
		</ul>
	</div>
	<div class="clear"></div>
</div>
	<%}%>
	</div>
</div>    
