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
		<h3>Tên địa điểm</h3>
		<ul class="category">
			<li>Thể loại: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>
		</ul>
		<p class="address">Địa chỉ: Đường Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, Thành Phố Hồ Chí Minh</p>
		<p class="price">Khoảng giá: <span>10-20k</span></p>
		<p class="checkoutmethod">Phương thức thanh toán: <span>Tiền mặt</span></p>
		<ul class="category">
			<li>Quản lý bởi: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>
		</ul>
		<p class="postedDate">Ngày post: <span>11/01/2011</span></p>
		<p class="number">Đã xem: <span>100</span></p>
		<ul class="category">
			<li>Thành viên thích: </li>
			<li><a href ="#">Username 1</a></li>
			<li><a href ="#">Username 2</a></li>
			<li><a href ="#">Username 3</a></li>		
		</ul>
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
