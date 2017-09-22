var position;

$(document).ready(function() {

                                                    

	$('#position').change(function(){  //當狀態改變時抓到縣市的值

		position = this.value;

		console.log(position);

		addressTolatlan(position);

	});

	

	$("#addr").change(function() {  //當狀態改變時抓到輸入地址的值

		var add = this.value;

		console.log(add);

		position = position + add;

		addressTolatlan(position);

	});

	

	function delayLoop(){

		addressTolatlan(position);

		window.setTimeout(delayLoop,1500);

	}

	

	function addressTolatlan(addr){

		var geocoder = new google.maps.Geocoder();

		geocoder.geocode({"address":addr},function(results,status){

			if(status==google.maps.GeocoderStatus.OK){

				var lat = $("#lat").val();

				var lng = $("#long").val();

				$("#lat").val(results[0].geometry.location.lat());

				$("#long").val(results[0].geometry.location.lng());

			}

		});

	}

}); 