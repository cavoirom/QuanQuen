<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
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
				
				<a href="http://wwww.google.com.vn1" class="show">
					<img src="images/flowing-rock.jpg" alt="Flowing Rock" width="410" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 1</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>
	
				<a href="http://wwww.google.com.vn2">
					<img src="images/grass-blades.jpg" alt="Grass Blades" width="410" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 2</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>
	
				<a href="http://wwww.google.com.vn3">
					<img src="images/ladybug.jpg" alt="Ladybug" width="410" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 3</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>

				<a href="4">
					<img src="images/lightning.jpg" alt="Lightning" width="410" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 4</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>
	
				<a href="5">
					<img src="images/lotus.jpg" alt="Lotus" width="410" height="360" title="" alt="" rel="<h3><a id='linkbox'>Nội dung 5</a></h3><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>
	
				<a href="6">
					<img src="images/mojave.jpg" alt="Mojave" width="410" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 6</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>
				
				<a href="7">
					<img src="images/stones.jpg" alt="Stone" width="580" height="360" title="" alt="" rel="<a id='linkbox'><h3>Nội dung 7</h3></a><p>You're not connected to online Help, which shows you our latest content. Check your Internet connection, and then try to connect to online Help again. If you still see this message, the online Help service might be temporarily unavailable.</p>"/>
				</a>

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