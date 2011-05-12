<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function validateLogin(){
		var formlogin = document.forms["formlogin"];
		if(formlogin.accountbox.value == ""){
			formlogin.accountbox.focus();
			return false;
		}
		if(formlogin.passwordbox.value == ""){
			formlogin.passwordbox.focus();
			return false;
		}
		return true;
	}
	
	function validateSearch(){
		if(document.forms["formsearch"].searchbox.value == "" || document.forms["formsearch"].searchbox.value == "Nội dung tìm kiếm..."){
			document.forms["formsearch"].searchbox.value = "";
			document.forms["formsearch"].searchbox.focus();
			return false;
		}
		return true;
	}
</script>


<%request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");%>


<div id="header">

	<div id="dotter">
		<ul id="nav">
			<li><a href="index.jsp" id="homepage"><span>Trang nhất</span></a></li>
			<li><a href="category" id="quanquen"><span>Quán quen</span></a></li>
			<li><a href="about.jsp" id="about"><span>Giới thiệu</span></a></li>
			<li><a href="contact.jsp" id="contact"><span>Liên hệ</span></a></li>
			<li id="search">
				<form action="search" method="post" id="formsearch" onsubmit="return validateSearch();">
				<input type="text" value="<%=((session.getAttribute("searchvalue")==null)? "Nội dung tìm kiếm...":(String)session.getAttribute("searchvalue"))%>" id="searchbox" size="20" name="searchvalue"/>
				<input type="submit" value="Tìm" id="buttonsearch"/>
				</form>
			</li>
		</ul>
	</div>
	
	<div id="dotterbanner">
		<div id="banner">
			<a href="register.jsp" id="buttonregister">Đăng ký</a>
			<form action="" method="post" id="formlogin" onsubmit="return validateLogin();">

				<div id="part1">
				<p id="accoount">Tài khoản</p>
				<input type="text" class="inputbox" id="accountbox" name="account"></input>
				<input type="checkbox" name="savepassword" id="savepassword"></input>
				<label for="savepassword">Nhớ mật khẩu</label>
				</div>
				
				<div id="part2">
				<p id="password">Mật khẩu</p>
				<input type="password" class="inputbox" id="passwordbox" name="password"></input>
				<a href="rescuepassword.jsp" id="rescuepassword">Khôi phục mật khẩu</a>
				</div>
				<input type="submit" value="Đăng nhập" id="buttonlogin"></input>
			</form>
		</div>
	</div>

</div><!--End Header-->