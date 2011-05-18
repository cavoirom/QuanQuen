<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@page import="quanquen.model.Image"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page import="quanquen.model.Place"%>
<%@ page import="quanquen.model.Article"%>
<%@ page import="quanquen.model.Category"%>
<%
List<Place> topPlaces = (List<Place>)session.getAttribute("topPlaces");
List<Place> newPlaces = (List<Place>)session.getAttribute("newPlaces");
List<Place> placesWithNewArticle = (List<Place>)session.getAttribute("placesWithNewArticle");
if(topPlaces == null || newPlaces == null || placesWithNewArticle == null){
	response.sendRedirect("loadtopplace");
	return;
}
%>
<div id="content">
	<div id="dottermainbox">
		<div id="titlemainbox"><p id="topmonth">Top của tháng</p></div>
		<div id="contentmainbox">
			<div id="numbermainbox">
				<input type="button" class="numberbox selectednumber" value="1" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="2" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="3" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="4" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="5" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="6" onClick="slideshowmainbox.change(this.value)"/>
				<input type="button" class="numberbox" value="7" onClick="slideshowmainbox.change(this.value)"/>
			</div>

			<div class="gallery" id="gallerymainbox">
				<%
				for (int i=0; i < topPlaces.size(); i++){
					Place place = topPlaces.get(i);
				%>
					<a href="place?id=<%=place.getId()%>">
						<img src="<%=place.getImages().get(0).getUrl()%>" width="410" height="360" rel="<h3><a id='linkbox'><%=place.getName()%></a></h3><p><%=place.getArticles().iterator().next().getContent().replaceAll("\n","")%></p>"/>
					</a>
				<%}%>
				<div id="boxtextmainbox" class="caption"></div>
			</div>
		</div>
	</div>

	<div class="dottersubbox" id="dottersubbox1">
		<div class="titlesubbox"><p>Mới cập nhật</p></div>
		<div id="contentsubbox1" class="contentsubbox">
			<%
			for (int i=0; i<newPlaces.size(); i++){
				Place place = newPlaces.get(i);
			%>
			<div class="newplace">
				<a href="place?id=<%=place.getId()%>"><img alt="" src="<%=place.getImages().iterator().next().getUrl()%>" width="60" height="60"/></a>
				<a href="place?id=<%=place.getId()%>"><%=place.getName()%></a>
				<ul class="category">
					<li>Thể loai: </li>
					<%
						Iterator<Category> categories = place.getCategories().iterator();
						while(categories.hasNext()){
							Category category = categories.next();
					%>
					<li><a href ="search?type=category&searchvalue=<%=category.getTitle()%>"><%=category.getTitle()%></a></li>
						<%}%>
				</ul>
				<p class="address">ĐC: <%=place.getAddress().toString()%></p>
			</div>
			<%}%>
		</div>
	</div>

	<div class="dottersubbox" id="dottersubbox2">
		<div class="titlesubbox"><p>Bình luận mới</p></div>
		<div id="contentsubbox2" class="contentsubbox">
			<div id="numbersubbox">
				<input type="button" class="numberbox selectednumber" value="1" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="2" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="3" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="4" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="5" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="6" onClick="slideshowsubbox.change(this.value)"/>
				<input type="button" class="numberbox" value="7" onClick="slideshowsubbox.change(this.value)"/>
			</div>

			<div class="gallery" id="gallerysubbox2">
				<%
				for (int i=0; i < placesWithNewArticle.size(); i++){
					Place place = placesWithNewArticle.get(i);
					LinkedHashSet<Article> articles = (LinkedHashSet<Article>)place.getArticles();
					int index = articles.size() - 1;
					Article[] arrArticle = articles.toArray(new Article[index+1]);	
				%>
					<a href="place?id=<%=place.getId()%>">
						<img src="<%=place.getImages().get(0).getUrl()%>" rel="<h3><a id='linkbox'><%=place.getName()%></a></h3><p><%=arrArticle[index].getContent().replaceAll("\n","")%></p>"/>
					</a>
				<%}%>
				<div id="boxtextsubbox" class="caption"></div>
			</div>
		</div><!-- End contentsubbox2 -->
	</div><!-- End dottersubbox2 -->

</div><!--End content-->