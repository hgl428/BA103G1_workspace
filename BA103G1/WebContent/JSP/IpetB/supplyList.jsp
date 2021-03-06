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
				<th>動物名稱</th>
				<th>送養標題</th>
				<th>送養日期</th>
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



</body>
<script src="<%=request.getContextPath()%>/JSP/IpetB/js/adopt.js"></script>
</html>