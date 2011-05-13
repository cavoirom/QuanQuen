<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="quanquen.model.Place"%> 
<%@ page import="quanquen.model.Category"%>  
<%
	List<Place> places = (List<Place>) request.getAttribute("places");
	if (places != null){
	for (int i=0; i<places.size(); i++){
		Place place = places.get(i);
%>
		<div class="places">
			<img src="<%=place.getImages().getFirst().getUrl()%>" alt="" width="120" height="120"/>
			<h3><a href="place?<%=place.getId()%>"><%=place.getName()%></a></h3>
			<ul>
				<%for (int j=0; j<place.getCategories().size(); j++){
					Category category = place.getCategories().iterator().next();
				%>
					<li><a href="category?<%=category.getId()%>"><%=category.getTitle()%></a></li>
				<%}%>
			</ul>
			<p class="address"><%=place.getAddress().toString()%></p>
		</div>
<%}}%>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>
		<div class="places">
			<img src="images/stones.jpg" alt="Stone" width="120" height="120"/>
			<h3><a href="#">Tên của địa điểm</a></h3>
			<ul>
				<li><a href="#">Thể loại 1</a></li>
				<li><a href="#">Thể loại 2</a></li>
				<li><a href="#">Thể loại 3</a></li>
				<li><a href="#">Thể loại 4</a></li>
			</ul>
			<p class="address">Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		</div>