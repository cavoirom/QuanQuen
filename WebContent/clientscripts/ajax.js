var XMLHttpRequestObject = false;
	if (window.XMLHttpRequest) {
		XMLHttpRequestObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		XMLHttpRequestObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	function loadDistrict(province) {
		url = "loadDistricts?province=" + province + "Cộng hòa";
		obj = document.getElementById("district");
		if (XMLHttpRequestObject) {
			XMLHttpRequestObject.open("GET", url, true);
			XMLHttpRequestObject.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');
			//XMLHttpRequestObject.setRequestHeader("provinces","Cộng hòa");
			XMLHttpRequestObject.onreadystatechange = function() {
				if (XMLHttpRequestObject.readyState == 4
						&& XMLHttpRequestObject.status == 200) {
					var text = XMLHttpRequestObject.responseText;
					obj.innerHTML = text;
				}
			}
			
			XMLHttpRequestObject.send();
		}
	}