<%@page import="quanquen.model.Article"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%Article article = null;%>
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
		<li><a href="share?article=<%=article.getId()%>">Chia sẻ qua facebook</a></li>
		<li><a href="send?article=<%=article.getId()%>">Gửi cho bạn bè</a></li>
		<li><a href="black?article=<%=article.getId()%>">Báo xấu</a></li>
		</ul>
	</div>
	<div class="clear"></div>
</div>