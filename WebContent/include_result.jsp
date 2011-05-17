<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	function validateAdvanceSearch(){
		var formsearch = document.forms["advancesearch"];
		if (document.forms["advancesearch"].value.value == ""){
			document.forms["advancesearch"].value.focus();
			return false;
		}
	}
	function deleteText(){
		if (document.forms["advancesearch"].value.value=="Nội dung tìm kiếm..."){
			document.forms["advancesearch"].value.value = "";
		}
	}
</script>    
<%	
	request.setCharacterEncoding("utf-8");
	//String value = (String)session.getAttribute("searchvalue");
	String type = (String)session.getAttribute("type");
	type = (type == null)? "name" : type;
	String[] types = new String[]{"name","author","category"};
	String[] description = new String[]{"Tên địa điểm","Thành viên post","Thể loại"};
	String address = (String)session.getAttribute("address");
	address = (address == null)? "" : address;
%>    
<form id="advancesearch" action="search" method="get" onsubmit="return validateAdvanceSearch();" accept-charset="utf-8">
	<fieldset>
		<label for="type">Tìm theo</label>
		<select id="type" name="type">
			<%for (int i=0; i < types.length; i++) {
				if (types[i].equals(type)){
			%>
				<option value="<%=types[i]%>" selected="selected"><%=description[i]%></option>
				<%}else{ %>
				<option value="<%=types[i]%>"><%=description[i]%></option>
				<%}
			} %>
		</select>
		
		<label for="address">Khu vực:</label>
		<input type="text" id="address" name="address" value="<%=address%>"/><span>VD: Quận 1 hoặc Lê Văn Việt hoặc để trống</span>
	</fieldset>
	<fieldset>
		<label for="value">Giá trị tìm kiếm</label>
		<input type="text" id="value" name="searchvalue" onclick="deleteText()" value="<%=((session.getAttribute("searchvalue")==null)? "Nội dung tìm kiếm...":(String)session.getAttribute("searchvalue"))%>"/>
	</fieldset>
	<input type="submit" value="Tìm kiếm" id="buttonsearch" />
</form>
<div id="result">
	<%@include file="include_listplaces.jsp"%>
</div>