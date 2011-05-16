<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ul = (String)session.getAttribute("ul");
	String code = request.getParameter("code");
	Integer id = new Integer(code);
	String message = "";
	switch(id){
		case 0: message = "Không tìm thấy địa điểm này"; break;
		case 1: message = "Tài khoản hoặc mật khẩu bị sai. Vui lòng thử lại"; break;
		case 2: message = "Đăng ký không thành công. Vui lòng thử lại"; break;
		case 3: message = "Trang bạn yêu cầu không tồn tại"; break;
		case 4: message = "Đăng ký thành công";break;
		case 5: message = "Đăng nhập thành công";break;
	}
	out.print(ul + "ádfasdf");
%>
<div id="content">
	<h3 class="mark"><%=message%></h3>
	<%if(ul != null){%>
		<p class="mark" style="padding: 10px 0px 200px 0px;">Chuyển tới trang <a href="<%=session.getAttribute("ul")%>"><%=session.getAttribute("ul")%></a></p>
	<%}else{%>
		<p class="mark" style="padding: 10px 0px 200px 0px;">Chuyển tới <a href="index.jsp">Trang nhất</a></p>
	<%}%>
</div>