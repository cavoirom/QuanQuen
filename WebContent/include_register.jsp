<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	//$("#register").corner("10px");
	function validateRegister(){
		alert("Test");
		return false;
	}
</script>
   
<h1 class="mark">Đăng ký tài khoản</h1>
<form id="register" action="" method="post" onsubmit="return validateRegister();">
	<fieldset>
		<label for="username">Tên tài khoản</label>
		<input type="text" name="username" id="username"/>
	</fieldset>
	
	<fieldset>
		<label for="password">Mật khẩu</label>
		<input type="password" name="password" id="password"/>
	</fieldset>
	
	<fieldset>
		<label for="repassword">Xác nhận mật khẩu</label>
		<input type="password" name="repassword" id="repassword"/>
	</fieldset>
	
	<fieldset>
		<label for="email">Email</label>
		<input type="text" name="email" id="email"/>
	</fieldset>
	
	<input type="submit" value="Đăng ký" id="buttonregister">
</form>
