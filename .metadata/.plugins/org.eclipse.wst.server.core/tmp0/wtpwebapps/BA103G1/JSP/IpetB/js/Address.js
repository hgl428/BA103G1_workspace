var content;
window.onload=init;

function init(){
	document.getElementById("position").onchange = trans;
	document.getElementById("addr").onfocusout = trans;
}

function trans(){
	content=$("#position").val()+$("#addr").val();
	delayLoop();
}

function delayLoop(){
	addressTolatlan(content);
	window.setTimeout(delayLoop,1500);
}

function addressTolatlan(addr){
	var geocoder = new google.maps.Geocoder();
	geocoder.geocode({"address":addr},function(results,status){
		if(status==google.maps.GeocoderStatus.OK){
			var lat = $("#lat").val();
			var long = $("#long").val();
			$("$lat").val(results[0].geometry.location.lat());
			$("$long").val(result[0]).geometry.location.long();
		}
	});
}