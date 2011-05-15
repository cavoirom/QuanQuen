<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="quanquen.model.Place"%>
<%
List<Place> topPlaces = (List<Place>)session.getAttribute("topPlaces");
if (topPlaces == null){
	response.sendRedirect("loadtopplace");
	return;
}
%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
%>

<div id="content">
	<div id="quanquen_first">
		<div id="topplace">
			<div id="numbertopplacebox">
				<input type="button" class="numberbox selectednumber" value="1" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="2" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="3" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="4" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="5" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="6" onClick="slideshowquanquen.change(this.value)"/>
				<input type="button" class="numberbox" value="7" onClick="slideshowquanquen.change(this.value)"/>
			</div>

			<div class="gallery" id="gallerytopplace">
				<%
				for (int i=0; i < topPlaces.size(); i++){
					Place place = topPlaces.get(i);
				%>
					<a href="place?id=<%=place.getId()%>" class="show">
						<img src="<%=place.getImages().getFirst().getUrl()%>" width="410" height="360" rel="<a id='linkbox'><h3><%=place.getName()%></h3></a><p><%=place.getArticles().iterator().next().getContent()%></p>"/>
					</a>
				<%}%>
				<div id="boxtexttopplace" class="caption">
				</div>
			</div>
		</div><!-- End topplace -->
	
		<div id="ad"></div>
	</div> <!-- End quanquen_first -->
	
	<div id="quanquen_last">
		<form action="category" method="post" id="choosecategory">
			<fieldset>
				<label for="province">Tỉnh/Thành phố</label>
				<select id="province" name="province">
				<%
				List<String> provinces = (List<String>)session.getAttribute("provinces");
				String province = (String)session.getAttribute("province");
				for (int i=0; i<provinces.size(); i++){
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
				<input type="submit" value="Go"/>
			</fieldset>
		</form>
		<div id="quanquen">
			<div id="category">
				<ul>
					<li><a href="#">Giải trí đầu</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thời trang</a></li>
					<li><a href="#">Thực phẩm</a></li>
					<li><a href="#">Giải trí</a></li>
					<li><a href="#">Mua sắm</a></li>
					<li><a href="#">Thực phẩm cuối</a></li>
				</ul>
				<div style="clear:both"></div>
			</div>
		
			<div id="tabs">
				<div id="newplace">Địa điểm mới</div>
				<div id="newpost">Bài viết mới</div>
				<div id="newupdate">Bình luận mới</div>
			</div>
		</div>
	</div>
</div>