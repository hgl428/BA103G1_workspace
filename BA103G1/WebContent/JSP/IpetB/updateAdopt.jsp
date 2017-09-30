<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.PetBreed.model.*"%>
<%@ page import="com.PetSpecies.model.*"%>
<%@ page import="com.petInformation.model.*"%>
<%@ page import="com.PetImage.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.PetView.model.*" %>
<%
// 	PetInformationVO petInfoVO = (PetInformationVO) request.getAttribute("PetInformationVO"); //記憶動物table寫錯資料時，其他正確的內容
// 	PetBreedVO breedVOe = (PetBreedVO) request.getAttribute("PetBreedVO"); //記憶使用者輸入品種的選項，
// 	PetSpeciesVO speciesVO = (PetSpeciesVO) request.getAttribute("PetSpeciesVO"); //記憶使用者輸入種類的選項
// 	PetImageVO imageVO = (PetImageVO) request.getAttribute("PetImageVO"); //記憶使用者輸入的照片和標題



PetViewVO petViewVO = (PetViewVO) request.getAttribute("PetViewVO");


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


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="js/main.js"></script> -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVTvj_0kUlIT4NDFTo4AV0ZJbliitGrPQ"></script>
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/Address.js"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/JSP/IpetB/css/main.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/JSP/IpetB/css/nav.css">
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/main.js"></script>
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/Address.js"></script>

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
			<div class="col-sm-6 add-img">
				<img src="images/cat.png" alt="">
			</div>
			<div class="col-sm-6 pull-right">
				<h3>
					<i class="fa fa-pencil-square-o" aria-hidden="true"></i>修改送養資料
				</h3>

				<form class="col-xs-12 col-sm-12" METHOD="post"
					enctype="multipart/form-data"
					ACTION="<%=request.getContextPath()%>/JSP/IpetB/addAdopt.do"
					name="add">
					<div class="form-group petName">
						<span class="text-danger">*</span><label for="petName">動物姓名</label>
						<input type="text" class="form-control" name="petName"
							placeholder="請填入動物的名字或暱稱" value="${PetViewVO.petName}" /> 
							<font color="red">${errorMsgs.petName}</font>
					</div>

					<div class="form-group petSex">
						*<label class="radio-inline">動物性別</label> 
						<input type="radio"	name="petSex" value="公" <%=(petViewVO.getPetSex().equals("公"))? "checked" : "" %>> 公 
						<input type="radio"	name="petSex" value="母" <%=(petViewVO.getPetSex().equals("母"))? "checked" : "" %>> 母
					</div>
					
					
					<jsp:useBean id="speciesSvc" scope="page"
						class="com.PetSpecies.model.PetSpeciesService" />
					<div class="form-group species">
						<span class="text-danger">*</span><label for="species">動物類型</label>
						<select class="form-control" name="speciesNo">
							<option value="${param.speciesNo}">請選擇</option>
							<c:forEach var="speciesVO" items="${speciesSvc.all}">
								<option value="${speciesVO.speciesNo}"
									${(speciesVO.speciesNo == PetViewVO.speciesNo)? 'selected': "" }>${speciesVO.speciesName}</option>
							</c:forEach>
						</select> <font color="red">${errorMsgs.speciesNo}</font>
					</div>
				
					<div class="form-group petColor">
						<span class="text-danger">*</span><label for="petColor">動物毛色</label>
						<input type="text" class="form-control" name="petColor"
							placeholder="請填入動物的毛色" value="${PetViewVO.petColor}" /> <font
							color="red">${errorMsgs.petColor}</font>
					</div>

					<jsp:useBean id="breedSvc" scope="page"
						class="com.PetBreed.model.PetBreedService" />
					<div class="form-group breed">
						<span class="text-danger">*</span><label for="petColor">動物品種</label>
						<select class="form-control" name="petBreed">

							<option value="${param.petBreed}">請選擇</option>
							<c:forEach var="breedVO" items="${breedSvc.all}">
								<option value="${breedVO.breedNo}"
									${(breedVO.breedNo==PetViewVO.breedNo)? 'selected':'' }>${breedVO.breedName}</option>
							</c:forEach>
						</select> <font color="red">${errorMsgs.petBreed}</font>
					</div>

					<div class="form-group petAge">
						<span class="text-danger">*</span><label class="radio-inline">年齡</label>
						<input type="radio" name="petAge" value="成年" <%=(petViewVO.getPetAge().equals("成年"))? "checked" : "" %>> 成年 
						<input type="radio" name="petAge" value="幼年" <%=(petViewVO.getPetAge().equals("幼年"))? "checked" : "" %>> 幼年
					</div>

					<div class="form-group petSize">
						<span class="text-danger">*</span><label for="petSize">體型</label>
						<select class="form-control" name="petSize">
							<option value="${PetViewVO.petSize}">請選擇</option>
							<option value="大型" <%=petViewVO.getPetSize().equals("大型") ? "selected" :"" %>>大型</option>
							<option value="中型" <%=petViewVO.getPetSize().equals("中型") ? "selected" :"" %>>中型</option>
							<option value="小型" <%=petViewVO.getPetSize().equals("小型") ? "selected" :"" %>>小型</option>
						</select> <font color="red">${errorMsgs.petSize}</font>
					</div>
					
<!-- 因為資料庫沒有縣市這個欄位，只能用subString(起始位置,結束位置)去切 -->
					<div class="form-group petPosition">
						<span class="text-danger">*</span><label for="petPosition">送養縣市</label>
						<select name="position" id="position">
						
							<option value="">選擇縣市</option>     
							<option value="台北市" <%=petViewVO.getPetPosition().substring(0,3).equals("台北市") ? "selected" :"" %>>台北市</option>
							<option value="新北市" <%=petViewVO.getPetPosition().substring(0,3).equals("新北市") ? "selected" :"" %>>新北市</option>
							<option value="桃園市" <%=petViewVO.getPetPosition().substring(0,3).equals("桃園市") ? "selected" :"" %>>桃園市</option>
							<option value="新竹市" <%=petViewVO.getPetPosition().substring(0,3).equals("新竹市") ? "selected" :"" %>>新竹市</option>
							<option value="新竹縣" <%=petViewVO.getPetPosition().substring(0,3).equals("新竹縣") ? "selected" :"" %>>新竹縣</option>
							<option value="宜蘭縣" <%=petViewVO.getPetPosition().substring(0,3).equals("宜蘭縣") ? "selected" :"" %>>宜蘭縣</option>
							<option value="基隆市" <%=petViewVO.getPetPosition().substring(0,3).equals("基隆市") ? "selected" :"" %>>基隆市</option>
							<option value="台中市" <%=petViewVO.getPetPosition().substring(0,3).equals("台中市") ? "selected" :"" %>>台中市</option>
							<option value="彰化縣" <%=petViewVO.getPetPosition().substring(0,3).equals("彰化縣") ? "selected" :"" %>>彰化縣</option>
							<option value="雲林縣" <%=petViewVO.getPetPosition().substring(0,3).equals("雲林縣") ? "selected" :"" %>>雲林縣</option>
							<option value="苗栗縣" <%=petViewVO.getPetPosition().substring(0,3).equals("苗集縣") ? "selected" :"" %>>苗栗縣</option>
							<option value="南投縣" <%=petViewVO.getPetPosition().substring(0,3).equals("南投縣") ? "selected" :"" %>>南投縣</option>
							<option value="高雄市" <%=petViewVO.getPetPosition().substring(0,3).equals("高雄市") ? "selected" :"" %>>高雄市</option>
							<option value="台南市" <%=petViewVO.getPetPosition().substring(0,3).equals("台南市") ? "selected" :"" %>>台南市</option>
							<option value="嘉義市" <%=petViewVO.getPetPosition().substring(0,3).equals("嘉義市") ? "selected" :"" %>>嘉義市</option>
							<option value="嘉義縣" <%=petViewVO.getPetPosition().substring(0,3).equals("嘉義縣") ? "selected" :"" %>>嘉義縣</option>
							<option value="屏東縣" <%=petViewVO.getPetPosition().substring(0,3).equals("屏東縣") ? "selected" :"" %>>屏東縣</option>
							<option value="台東縣" <%=petViewVO.getPetPosition().substring(0,3).equals("台東縣") ? "selected" :"" %>>台東縣</option>
							<option value="花蓮縣" <%=petViewVO.getPetPosition().substring(0,3).equals("花蓮縣") ? "selected" :"" %>>花蓮縣</option>
							<option value="澎湖縣" <%=petViewVO.getPetPosition().substring(0,3).equals("澎湖縣") ? "selected" :"" %>>澎湖縣</option>
							<option value="金門縣" <%=petViewVO.getPetPosition().substring(0,3).equals("金門縣") ? "selected" :"" %>>金門縣</option>
							<option value="連江縣" <%=petViewVO.getPetPosition().substring(0,3).equals("連江縣") ? "selected" :"" %>>連江縣</option>
						</select> <font color="red">${errorMsgs.position}</font>
					</div>
					
					<div class="form-group">
						<span class="text-danger">*</span><label for="keyAddr">送養地址</label>
						<input type="text" class="form-control" id="addr" name="addr"
							placeholder="請填入寵物所在地址" value="${PetViewVO.getPetPosition().substring(3)}"> <font
							color="red">${errorMsgs.addr}</font>
					</div>


					<div class="form-group petIc">
						<label class="radio-inline">晶片</label> 
						<input type="radio"	name="petIc" value="有" <%=(petViewVO.getPetIc().equals("有"))? "checked" : "" %>> 有
						<input type="radio"	name="petIc" value="無" <%=(petViewVO.getPetIc().equals("無"))? "checked" : "" %>> 無
					</div>

					<div class="form-group tnr">
						<label class="radio-inline">絕育</label> 
						<input type="radio"	name="TNR" value="是" <%=(petViewVO.getTNR().equals("是"))? "checked" : "" %>> 是 
						<input type="radio" name="TNR" value="否" <%=(petViewVO.getTNR().equals("否"))? "checked" : "" %>> 否
					</div>

					<div class="form-group petTitle">
						<span class="text-danger">*</span><label for="petTitle">送養標題</label>
						<input type="text" class="form-control" name="petTitle"
							value="${PetViewVO.petTitle}" placeholder="請填入十個字內的送養標題"> <font
							color="red">${errorMsgs.petTitle}</font>
					</div>

					<div class="form-group petContent">
						<span class="text-danger">*</span><label for="petContent">動物現況</label>
						<textarea class="form-control" id="situation" name="situation"
							rows="5">${PetViewVO.situation}</textarea>
						
						<font color="red">${errorMsgs.situation}</font>
					</div>

					<div class="form-group petTitle">
						<label for="long">經度</label> <input type="text" name="long"
							id="long" value="${PetViewVO.petLongitude}">
					</div>

					<div class="form-group petTitle">
						<label for="lat">緯度</label> <input type="text" name="lat"
							id="lat" value="${PetViewVO.petLatitude}">
					</div>

<!-- 					<div class="form-group col-sm-6"> -->
<!-- 						<label for="petImage"> 動物照片上傳 </label> <input type="file" -->
<!-- 							class="form-control-file" name="petImage1" value="" -->
<!-- 							aria-describedby="fileHelp"> <small name="igname" -->
<!-- 							class="form-text text-muted"></small> <span class="text-danger">*</span><label -->
<!-- 							for="image">照片名稱</label> <input type="text" class="form-control" -->
<!-- 							id="picName1" name="picName1" placeholder="請填入照片名稱" -->
<%-- 							value="${param.picName}"> <font color="red">${errorMsgs.picName1}</font> --%>

<!-- 					</div> -->

<!-- 					<div class="form-group col-sm-6"> -->
<!-- 						<label for="petFilm"> 動物影片上傳 <span>（限一部）</span> -->
<!-- 						</label> <input type="file" class="form-control-file" name="petFilm" -->
<!-- 							aria-describedby="fileHelp"> <small id="petFilm" -->
<!-- 							class="form-text text-muted"></small> -->
<!-- 					</div> -->
					<input type="hidden" name="petNo" value="${PetViewVO.petNo }">
					<input type="hidden" name="action" value="update">
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