<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="quanquen.model.Place"%>
<%@ page import="quanquen.model.Category"%>
<%
List<Place> topPlaces = (List<Place>)session.getAttribute("topPlaces");
List<String> provinces = (List<String>)session.getAttribute("provinces");
List<Category> categories = (List<Category>)session.getAttribute("categories");
List<Place> newPlaces = (List<Place>)session.getAttribute("newPlaces");
String province = (String)session.getAttribute("province");
if (topPlaces == null){
	response.sendRedirect("loadtopplace");
	return;
}
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
%>
<div id="content">
	<div id="dottermainbox">
		<div id="titlemainbox"><p id="topmonth">Top của tháng</p></div>
		<div id="contentmainbox">
			<div id="numbermainbox">
				<input type="button" class="numberbox selectednumber" value="1" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="2" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="3" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="4" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="5" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="6" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="7" onClick="slideshowquanquen.change(this.value)"/>
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
	
	<div id="newplaces">
		<h2 class="mark">Quán mới cập nhật</h2>
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
						Iterator<Category> types = place.getCategories().iterator();
						while(types.hasNext()){
							Category category = types.next();
					%>
					<li><a href ="search?type=category&searchvalue=<%=category.getTitle()%>"><%=category.getTitle()%></a></li>
						<%}%>
				</ul>
				<p class="address">ĐC: <%=place.getAddress().toString()%></p>
			</div>
			<%}%>
		</div>
	
	<div id="quanquen">
		<form action="category" method="get" id="choosecategory">
			<fieldset>
				<label for="province">Tỉnh/Thành phố</label>
				<select id="province" name="province">
			<%
			for (int i=0; i< provinces.size(); i++){
				if(provinces.get(i).equals(province)){
			%>
					<option value="<%=i%>" selected="selected"><%=provinces.get(i).toString()%></option>
				<%}else{%>
					<option value="<%=i%>"><%=provinces.get(i).toString()%></option>
				<%}} %>
				</select>
				<label for="district">Quận/Huyện</label>
				<select id="district" name="district">
				</select>
				<label for="categories">Thể loại</label>
				<select id="categories" name="categories">
				</select>
				<input type="submit" value="Go"/>
			</fieldset>
		</form>
		<div id="places">
		</div>
	</div>
</div>