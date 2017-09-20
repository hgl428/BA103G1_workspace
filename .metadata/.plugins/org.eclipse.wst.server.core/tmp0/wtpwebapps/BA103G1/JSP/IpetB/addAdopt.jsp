<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.PetBreed.model.*"%>
<%@ page import="com.PetSpecies.model.*"%>
<%@ page import="com.petInformation.model.*"%>
<%@ page import="java.util.*"%>

<%
	PetInformationVO petInfoVO = (PetInformationVO) request.getAttribute("PetInformationVO");
	PetBreedVO breedVO = (PetBreedVO) request.getAttribute("PetBreedVO");
	PetSpeciesVO speciesVO = (PetSpeciesVO) request.getAttribute("PetSpeciesVO");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVTvj_0kUlIT4NDFTo4AV0ZJbliitGrPQ"></script>

<script>
var position;
$(document).ready(function() {
	
                                                    
$('#postion').change(function(){  //當狀態改變時抓到縣市的值
	position = this.value;
	console.log(position);
});

$("#addr").change(function() {  //當狀態改變時抓到輸入地址的值
	var add = this.value;
	console.log(add);
	position = position + add;
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
			$("$lat").val(results[0].geometry.location.lat());
			$("$long").val(result[0]).geometry.location.lng();
		}
	});
}
}); 
</script>

<title>iPet愛動物</title>
</head>

<body>

	<!--第一區：nav區-->
	<div class="b_nav">
		<div class="container">

			<!--左欄：logo區-->
			<div class="col-xs-2 col-sm-2">
				<a class="logo" href="index.html"> <img
					src="images/Ipet_Logo .png">
				</a>
			</div>
			<!--左欄：logo區 end-->
			<!--手機版的漢堡選單開始-->
			<div class="burger-menu">
				<i class="fa fa-bars" aria-hidden="true"></i>
			</div>
			<!--手機版的漢堡選單結束-->

			<!--右欄：購物車等icon＋選單區-->
			<div class="col-xs-10 col-sm-10 rightbar text-right">

				<!--購物車、註冊、登入、會員專區（登入成功後，登入兩字變為會員專區）-->
				<div class="col-sm-12">
					<div class="row">

						<div class="icon shopping">
							<span> <a href="#"> <i class="fa fa-cart-plus"
									aria-hidden="true"></i> 購物車
							</a>
							</span>
						</div>
						<div class="icon member">
							<span> <a href="#"> <i class="fa fa-user-o"
									aria-hidden="true"></i> 加入會員
							</a>
							</span>
						</div>
						<div class="icon login">
							<span> <a href="#"> <i class="fa fa-user-circle"
									aria-hidden="true"></i> 登入
							</a>
							</span>
						</div>
					</div>
				</div>
				<!--購物車、註冊、登入、會員專區（登入成功後，登入兩字變為會員專區）end-->

				<!--選單區-->
				<div class="col-sm-12">
					<div class="row">
						<ul class="menu">
							<li><a href="adopt.html">我要認養</a>
								<ul class="sub-menu">
									<li><a href="#">自我評估</a></li>
									<li><a href="adopt.html">認養總覽</a></li>
								</ul></li>
							<li><a href="addadoption.html">我要送養</a>
								<ul class="sub-menu">
									<li><a href="#">送養須知</a></li>
									<li><a href="addadoption.html">新增送養</a></li>
								</ul></li>
							<li><a href="shopping.html">購物商城</a></li>
							<li><a href="#">討論區</a></li>
							<li><a href="#">寵物牆</a></li>
							<li><a href="#">活動專區</a>
								<ul class="sub-menu">
									<li><a href="#">本版活動</a></li>
									<li><a href="#">領養分享</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
				<!--選單區 end-->

			</div>
			<!--右欄：購物車等icon＋選單區 end-->

		</div>
	</div>
	<!--第一區：nav區 end-->



	<!--各頁主內容寫在這-->
	<div class="add-content">
		<div class="container">
			<div class="col-sm-6">
				<img src="images/cat25.jpg" alt="">
			</div>
			<div class="col-sm-6">
				<h3>
					<i class="fa fa-pencil-square-o" aria-hidden="true"></i> 填寫送養資料
				</h3>
				<form class="col-xs-12 col-sm-12" METHOD="post"
					ACTION="<%=request.getContextPath()%>/JSP/IpetB/addAdopt.do"
					name="add">
					<div class="form-group petName">
						*<label for="petName">動物姓名</label> <input type="text"
							class="form-control" name="petName" placeholder="請填入動物的名字或暱稱"
							value="${petInfoVO.petName}" /> <font color="red">${errorMsgs.petName}</font>
					</div>

					<div class="form-group petSex">
						*<label class="radio-inline">動物性別</label> <input type="radio"
							name="petSex" value="公"checked> 公 <input type="radio"
							name="petSex" value="母" > 母
					</div>

					<div class="form-group species">
						<span class="text-danger">*</span><label for="species">動物類型</label>
						<select class="form-control" name="speciesNo">
							<option value="">請選擇</option>
							<option value="10">狗</option>
							<option value="20">貓</option>
							<option value="30">水族</option>
							<option value="40">鳥</option>
							<option value="50">其他</option>
						</select>

					</div>

					<div class="form-group petColor">
						<span class="text-danger">*</span><label for="petColor">毛色</label>
						<select class="form-control" name="petColor">
							<option value="noChoose">請選擇</option>
							<option value="黑">黑</option>
							<option value="白">白</option>
							<option value="黑白">黑白</option>
							<option value="黃">黃</option>
							<option value="黃白">黃白</option>
							<option value="虎斑">虎斑</option>
							<option value="米克斯">米克斯</option>
							<option value="棕">棕</option>
							<option value="咖啡">咖啡</option>
							<option value="其他">其他</option>
						</select>
					</div>
					<jsp:useBean id="breedSvc" scope="page"
						class="com.PetBreed.model.PetBreedService" />
					<div class="form-group breed">
						<span class="text-danger">*</span><label for="petColor">動物品種</label>
						<select class="form-control" name="petBreed">

							<option value="">請選擇</option>
							<c:forEach var="breedVO" items="${breedSvc.all}">
								<option value="${breedVO.breedNo}">${breedVO.breedName}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group petAge">
						<span class="text-danger">*</span><label class="radio-inline">年齡</label>
						<input type="radio" name="petAge" value="成年"checked> 成年
						<input type="radio" name="petAge" value="幼年"> 幼年
					</div>

					<div class="form-group petSize">
						<span class="text-danger">*</span><label for="petSize">體型</label>
						<select class="form-control" name="petSize">
							<option value="">請選擇</option>
							<option value="大型">大型</option>
							<option value="中型">中型</option>
							<option value="小型">小型</option>
						</select>
					</div>

					<div class="form-group petPosition">
						<span class="text-danger">*</span><label for="petPosition">送養縣市</label>
						<select name="position" id="position">
							<option value="">選擇縣市</option>
							<option value="台北市">台北市</option>
							<option value="新北市">新北市</option>
							<option value="桃園市">桃園市</option>
							<option value="新竹市">新竹市</option>
							<option value="新竹縣">新竹縣</option>
							<option value="宜蘭縣">宜蘭縣</option>
							<option value="基隆市">基隆市</option>
							<option value="台中市">台中市</option>
							<option value="彰化縣">彰化縣</option>
							<option value="雲林縣">雲林縣</option>
							<option value="苗栗縣">苗栗縣</option>
							<option value="南投縣">南投縣</option>
							<option value="高雄市">高雄市</option>
							<option value="台南市">台南市</option>
							<option value="嘉義市">嘉義市</option>
							<option value="嘉義縣">嘉義縣</option>
							<option value="屏東縣">屏東縣</option>
							<option value="台東縣">台東縣</option>
							<option value="花蓮縣">花蓮縣</option>
							<option value="澎湖縣">澎湖縣</option>
							<option value="金門縣">金門縣</option>
							<option value="連江縣">連江縣</option>
						</select>
					</div>
					<div class="form-group">
						<span class="text-danger">*</span><label for="keyAddr">送養地址</label>
						<input type="text" class="form-control" id="addr" name="addr"
							placeholder="請填入寵物所在地址"
							value="<%=(petInfoVO == null) ? "" : petInfoVO.getPetPosition()%>">
						<font color="red">${errorMsgs.addr}</font>
					</div>


					<div class="form-group petIc">
						<label class="radio-inline">晶片</label> <input type="radio"
							name="petIc" value="有"> 有 <input type="radio"
							name="petIc" value="無"checked> 無
					</div>

					<div class="form-group tnr">
						<label class="radio-inline">絕育</label> <input type="radio"
							name="TNR" value="是"> 是 <input type="radio" name="TNR"
							value="否"checked> 否
					</div>

					<div class="form-group petTitle">
						<span class="text-danger">*</span><label for="petTitle">送養標題</label>
						<input type="text" class="form-control" name="petTitle"
							placeholder="請填入十個字內的送養標題"> <font color="red">${errorMsgs.petTitle}</font>
					</div>

					<div class="form-group petContent">
						<span class="text-danger">*</span><label for="petContent">動物現況</label>
						<textarea class="form-control" name="situation" rows="5"
							value="<%=(petInfoVO == null) ? "" : petInfoVO.getSituation()%>"></textarea>
						<font color="red">${errorMsgs.situation}</font>
					</div>

					<div class="form-group petTitle">
						<label for="petTitle">經度</label> <input type="text" name="long"
							id="long">
					</div>

					<div class="form-group petTitle">
						<label for="petTitle">緯度</label> <input type="text" name="lat"
							id="lat">
					</div>

					<div class="form-group col-sm-6">
						<label for="petImage"> 動物照片上傳 <span>（可傳十張）</span>
						</label> <input type="file" class="form-control-file" id="petImage"
							aria-describedby="fileHelp"> <small id="petImage"
							class="form-text text-muted"></small>
					</div>

					<div class="form-group col-sm-6">
						<label for="petFilm"> 動物影片上傳 <span>（限一部）</span>
						</label> <input type="file" class="form-control-file" name="petFilm"
							aria-describedby="fileHelp"> <small id="petFilm"
							class="form-text text-muted"></small>
					</div>

					<input type="hidden" name="action" value="insert">
					<button type="submit" class="btn btn-primary pull-right">確認送出</button>

				</form>

			</div>
		</div>
	</div>
	<!--各頁主內容寫在這 end-->

	<!--最後一區：footer-->
	<!-- <footer>
    <div class="container">
      
    </div>
  </footer> -->

	<!--最後一區：end-->

</body>

</html>