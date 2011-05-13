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
		<img src="images/stones.jpg" alt="Stone" width="400" height="400"/>
		<div class="category">
			<h3>Tên địa điểm</h3>
			<span>Thể loai: </span><a href ="#">Category</a><a href ="#">Category</a><a href ="#">Category</a>
		</div>
		<p class="address">Địa chỉ: Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		<p class="price">Khoảng giá: <span>10-20k</span></p>
		<p class="checkoutmethod">Phương thức thanh toán: <span>Tiền mặt</span></p>
		<div class="manager">
			<span>Quản lý bởi: </span>
			<a href ="#">Username 1</a>
			<a href ="#">Username 2</a>
			<a href ="#">Username 3</a>
		</div>
		<p class="postedDate">Ngày post: <span>11/01/2011</span></p>
		<p class="number">Đã xem: <span>100</span></p>
		<div class="memberlike">
			<span>Thành viên thích: </span>
			<a href ="#">Member 1</a>
			<a href ="#">Member 2</a>
			<a href ="#">Member 3</a>		
		</div>
	</div>
	
	<div class="clear"></div>
	
	<div class="article">
		<div class="contentarticle">
			<img src="images/stones.jpg" alt="Stone" width="200" height="200"/>
		</div>
		<div class="tools"></div>
		<div class="comments">
			<dir class="comment"></dir>
			<dir class="comment"></dir>
			<dir class="comment"></dir>
			<dir class="comment"></dir>
		</div>
	</div>
</div>    
