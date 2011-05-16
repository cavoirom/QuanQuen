<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="quanquen.model.Place" %>
<%@page import="quanquen.model.Category" %>
<%@page import="quanquen.model.Article" %>
<%@page import="quanquen.model.Address" %>
<%@page import="quanquen.model.Member" %>
<%@page import="quanquen.model.Comment" %>    
<%Place place = (Place)request.getAttribute("place"); %>
<div id="content">
	<div class="information">
		<div>
			<a href="images/place/default.jpg" rel="lightbox" title="Tiêu đề"><img src="images/place/default.jpg"/></a>
			<ul class="images">
				<li><a href="javascript:void()" class="back">Sau</a></li>
				<li><a href="images/place/default.jpg" rel="lightbox[roadtrip]"><img src="images/place/default.jpg"/></a></li>
				<li><a href="images/place/default.jpg" rel="lightbox[roadtrip]"><img src="images/place/default.jpg"/></a></li>
				<li><a href="images/place/default.jpg" rel="lightbox[roadtrip]"><img src="images/place/default.jpg"/></a></li>
				<li><a href="images/place/default.jpg" rel="lightbox[roadtrip]"><img src="images/place/default.jpg"/></a></li>
				<li><a href="images/place/default.jpg" rel="lightbox[roadtrip]"><img src="images/place/default.jpg"/></a></li>
				<li><a href="javascript:void()" class="next">Kế</a></li>
			</ul>
			<ul class="category">
				<li>Chức năng: </li>
				<li><a href="#">Tải hình lên</a></li>
				<li><a href="#">Đăng ký quản lý</a></li>
				<li><a href="#">Tùy chỉnh</a></li>
			</ul>
		</div>
		<h3>Tên địa điểm</h3>
		<p>Số lần truy cập: 32432</p>
		<p>Số bài viết: 44</p>
		<ul class="category">
			<li>Thể loại: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>
		</ul>
		<p>Địa chỉ: Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		<p>Website: http://cafeviet.vn</p>
		<p>Điện thoại: 0902345789</p>
		<p>Email: info@cafeviet.vn</p>
		<p>Fax: (08)1235678</p>
		<p></p>
		<p></p>
		<p>Khoảng giá: <span>10-20k</span></p>
		<p >Phương thức thanh toán: <span>Tiền mặt</span></p>
		<ul class="category">
			<li>Quản lý bởi: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>
		</ul>
		<p>Ngày đăng: <span>11/01/2011</span></p>
		<p >Cập nhật lần cuối: <span>11/01/2011</span></p>
		<p>Đã xem: 100</p>
		<ul class="category">
			<li>Thành viên thích: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>		
		</ul>
		
	</div>
	<div class="clear"></div>
	<div class="articles">
		<%@include file="include_article.jsp"%>
		<%@include file="include_article.jsp"%>
	</div>
</div>    
