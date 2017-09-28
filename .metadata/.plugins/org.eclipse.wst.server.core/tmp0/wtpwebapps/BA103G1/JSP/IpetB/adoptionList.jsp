<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.PetBreed.model.*"%>
<%@ page import="com.PetSpecies.model.*"%>
<%@ page import="com.petInformation.model.*"%>
<%@ page import="com.PetImage.model.*"%>
<%@ page import="java.util.*"%>

<%
	// 	PetInformationVO petInfoVO = (PetInformationVO) request.getAttribute("PetInformationVO"); //記憶動物table寫錯資料時，其他正確的內容
	// 	PetBreedVO breedVOe = (PetBreedVO) request.getAttribute("PetBreedVO"); //記憶使用者輸入品種的選項，
	// 	PetSpeciesVO speciesVO = (PetSpeciesVO) request.getAttribute("PetSpeciesVO"); //記憶使用者輸入種類的選項
	// 	PetImageVO imageVO = (PetImageVO) request.getAttribute("PetImageVO"); //記憶使用者輸入的照片和標題
	
%>




<!DOCTYPE html>
<html>
<head>
<title>會員頁用</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="js/main.js"></script> -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCVTvj_0kUlIT4NDFTo4AV0ZJbliitGrPQ"></script>
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/Address.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/JSP/IpetB/css/adopt.css">


</head>
<body>
<jsp:useBean id="infoSvc" scope="page" class="com.petInformation.model.PetInformationService" />

	<table class="table table-hover">
		<thead>
			<tr>
				<th>寵物編號</th>
				<th>送養標題</th>
				<th>送養日期</th>
				<th>送養人</th>
				<th>狀態</th>
			</tr>
		</thead>
		<c:forEach var="infoList" items="${infoSvc.getSupplyPet(123456)}"> 
<!-- 		接session傳來的會員編號 -->
			<tbody>
				<!-- 標題區，點擊後會打開更多內容區 -->
				<tr class="pet-title ">
					<td>${infoList.petNo}</td>
					<td>${infoList.petName}</td>
					<td>${infoList.petTitle}</td>
					<td>${infoList.petDate}</td>
					<td>${infoList.status}</td>
					<td><button class="pet-edit pull-right btn btn-primary ">修改</button></td> 
					<td>
					<FORM METHOD="post"	ACTION="<%=request.getContextPath()%>/JSP/IpetB/addAdopt.do">
						<button class="pet-edit pull-right btn btn-primary"> 修改</button>
						<input type="hidden" name="petNo" value="${infoList.petNo}"> 
<%-- 						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"> --%>
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action" value="get_one_pet">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/JSP/IpetB/addAdopt.do">
						<button class="pet-edit pull-right btn btn-primary">刪除</button>
						<input type="hidden" name="empno" value="${empVO.empno}"> 
<%-- 						<input type="hidden" name="requestURL" value="<%=request.getServletPath()%>"> --%>
						<!--送出本網頁的路徑給Controller-->
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


<!-- 	<tr class="pet-title"> -->
<!-- 		<td>1234567</td> -->
<!-- 		<td>可愛小橘球找家人</td> -->
<!-- 		<td>2017/10/10</td> -->
<!-- 		<td>壞心人</td> -->
<!-- 		<td>已送養</td> -->
<!-- 		<td><button class="pet-edit pull-right btn btn-primary">修改</button></td> -->
<!-- 	</tr> -->

	<!-- 標題區，點擊後會打開更多內容區 -->

<!-- 	<tr class="pet-adopt"> -->
<!-- 		<td>11111111</td> -->
<!-- 		<td>我好想認養你</td> -->
<!-- 		<td>2017/10/10</td> -->
<!-- 		<td>金正恩</td> -->
<!-- 		<td>想領養</td> -->

<!-- 	</tr> -->


	<!-- 更多內容區 -->
	<tr class="pet-content">
		<td colspan="5">
			<!-- 功能按鈕區 -->
			<div class="btn-area col-sm-12">

				<!-- 						<button class="pet-save pull-right btn btn-primary">儲存</button> -->
				<button class="pet-cancel  pull-right btn  btn-primary">取消</button>
			</div> <!-- 功能按鈕區 --> <!-- 可編輯的input 所有inpt請包在label標籤內-->

			<div class="add-content">
				<div class="container">

					<div class="col-sm-6 pull-left">
						<h3>
							<i class="fa fa-pencil-square-o" aria-hidden="true"></i>填寫送養資料
						</h3>

						<form class="col-xs-12 col-sm-12" METHOD="post"
							enctype="multipart/form-data"
							ACTION="<%=request.getContextPath()%>/JSP/IpetB/addAdopt.do"
							name="add">
							<div class="form-group petName">
								<span class="text-danger">*</span><label for="petName">動物姓名</label>
								<input type="text" class="form-control" name="petName"
									placeholder="請填入動物的名字或暱稱" value="${param.petName}" /> <font
									color="red">${errorMsgs.petName}</font>
							</div>

							<div class="form-group petSex">
								*<label class="radio-inline">動物性別</label> 
								<input type="radio"	name="petSex" value="公" checked> 公 
								<input type="radio"	name="petSex" value="母"> 母
							</div>
							<jsp:useBean id="speciesSvc" scope="page"
								class="com.PetSpecies.model.PetSpeciesService" />
							<div class="form-group species">
								<span class="text-danger">*</span><label for="species">動物類型</label>
								<select class="form-control" name="speciesNo">
									<option value="${param.speciesNo}">請選擇</option>
									<c:forEach var="speciesVO" items="${speciesSvc.all}">
										<option value="${speciesVO.speciesNo}"
											${(PetSpeciesVO.speciesNo==speciesVO.speciesNo)? 'selected':'' }>${speciesVO.speciesName}</option>
									</c:forEach>
								</select> <font color="red">${errorMsgs.speciesNo}</font>
							</div>
							
							<div class="form-group petColor">
								<span class="text-danger">*</span><label for="petColor">動物毛色</label>
								<input type="text" class="form-control" name="petColor"
									placeholder="請填入動物的毛色" value="${param.petColor}" /> <font
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
											${(PetBreedVO.breedNo==breedVO.breedNo)? 'selected':'' }>${breedVO.breedName}</option>
									</c:forEach>
								</select> <font color="red">${errorMsgs.petBreed}</font>
							</div>

							<div class="form-group petAge">
								<span class="text-danger">*</span><label class="radio-inline">年齡</label>
								<input type="radio" name="petAge" value="成年" checked> 成年
								<input type="radio" name="petAge" value="幼年"> 幼年
							</div>

							<div class="form-group petSize">
								<span class="text-danger">*</span><label for="petSize">體型</label>
								<select class="form-control" name="petSize">
									<option value="">請選擇</option>
									<option value="大型">大型</option>
									<option value="中型">中型</option>
									<option value="小型">小型</option>
								</select> <font color="red">${errorMsgs.petSize}</font>
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
								</select> <font color="red">${errorMsgs.position}</font>
							</div>
							<div class="form-group">
								<span class="text-danger">*</span><label for="keyAddr">送養地址</label>
								<input type="text" class="form-control" id="addr" name="addr"
									placeholder="請填入寵物所在地址" value="${param.addr}"> <font
									color="red">${errorMsgs.addr}</font>
							</div>


							<div class="form-group petIc">
								<label class="radio-inline">晶片</label> <input type="radio"
									name="petIc" value="有"> 有 <input type="radio"
									name="petIc" value="無" checked> 無
							</div>

							<div class="form-group tnr">
								<label class="radio-inline">絕育</label> <input type="radio"
									name="TNR" value="是"> 是 <input type="radio" name="TNR"
									value="否" checked> 否
							</div>

							<div class="form-group petTitle">
								<span class="text-danger">*</span><label for="petTitle">送養標題</label>
								<input type="text" class="form-control" name="petTitle"
									value="${param.petTitle}" placeholder="請填入十個字內的送養標題"> <font
									color="red">${errorMsgs.petTitle}</font>
							</div>

							<div class="form-group petContent">
								<span class="text-danger">*</span><label for="petContent">動物現況</label>
								<textarea class="form-control" id="situation" name="situation"
									rows="5">${PetInformationVO.situation}</textarea>

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
								<label for="petImage"> 動物照片上傳 </label> <input type="file"
									class="form-control-file" name="petImage1" value=""
									aria-describedby="fileHelp"> <small name="igname"
									class="form-text text-muted"></small> <span class="text-danger">*</span><label
									for="image">照片名稱</label> <input type="text"
									class="form-control" id="picName1" name="picName1"
									placeholder="請填入照片名稱" value="${param.picName}"> <font
									color="red">${errorMsgs.picName1}</font>

							</div>

							<div class="form-group col-sm-6">
								<label for="petFilm"> 動物影片上傳 <span>（限一部）</span>
								</label> <input type="file" class="form-control-file" name="petFilm"
									aria-describedby="fileHelp"> <small id="petFilm"
									class="form-text text-muted"></small>
							</div>

							<input type="hidden" name="action" value="update">
							<button type="submit" class="pet-save btn btn-primary pull-right">確認送出</button>

						</form>

					</div>
				</div>
			</div>






		</td>
	</tr>
	<!-- 更多內容區 -->


</body>
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/adopt.js"></script>
</html>