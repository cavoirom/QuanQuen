<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");
	Integer id = new Integer(code);
	String message = "";
	switch(id){
		case 0: message = "Không tìm thấy địa điểm này"; break;
		case 1: message = "Username hoặc mật khẩu bị sai. Vui lòng thử lại"; break;
		case 2: message = "Đăng ký không thành công. Vui lòng thử lại"; break;
		case 3: message = "Trang bạn yêu cầu không tồn tại"; break;
	}
%>
<div id="content">
	<h3 class="mark" style="padding: 10px 0px 200px 0px;"><%=message%></h3>
</div>