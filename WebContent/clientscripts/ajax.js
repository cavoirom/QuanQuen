var XMLHttpRequestObject = false;
	if (window.XMLHttpRequest) {
		XMLHttpRequestObject = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		XMLHttpRequestObject = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	function loadDistrict(province) {
		url = "loaddistricts?province=" + province;
		obj = document.getElementById("district");
		if (XMLHttpRequestObject) {
			XMLHttpRequestObject.open("GET", url, true);
			XMLHttpRequestObject.onreadystatechange = function() {
				if (XMLHttpRequestObject.readyState == 4
						&& XMLHttpRequestObject.status == 200) {
					var text = XMLHttpRequestObject.responseText;
					obj.innerHTML = text;
				}
			};
			
			XMLHttpRequestObject.send();
		}
	}