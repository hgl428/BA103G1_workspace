<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.PetImage.model.*"%>
<%
PetImageVO imageVO = (PetImageVO) request.getAttribute("picNo");
%>

<html>
<head>
<title>照片資料新增 -addPetInfo.jsp</title></head>
<link rel="stylesheet" type="text/css" href="js/calendar.css">
<script language="JavaScript" src="js/calendarcode.js"></script>
<div id="popupcalendar" class="text"></div>

<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>照片資料新增 --addPetInfo.jsp</h3>
		</td>
		<td>
		   <a href="select_page.jsp"><img src="images/tomcat.gif" width="100" height="100" border="1">回首頁</a>
	    </td>
	</tr>
</table>

<h3>照片資訊:</h3>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<FORM METHOD="post" ACTION="PetImage.do" name="form1">
<table border="0">

	<tr>
		<td>動物編號:</td>
		<td><input type="TEXT" name="petNo" size="45" 
			value="<%= (imageVO==null)? "10": imageVO.getPetNo()%>" /></td>
	</tr>
	<tr>
		<td>照片名稱:</td>
		<td><input type="TEXT" name="picName" size="45"
			value="<%= (imageVO==null)? "皇阿瑪好胖" : imageVO.getPicName()%>" /></td>
	</tr>
	<tr>
		<td>動物照片:</td>
		<td><input type="TEXT" name="picture" size="45"
			value="<%= (imageVO==null)? "null" :imageVO.getpetPicture()%>" /></td>
	</tr>
	<tr>
		<td>照片說明:</td>
		<td><input type="TEXT" name="picNote" size="45"
			value="<%= (imageVO==null)? "皇阿瑪真的好胖" :imageVO.getPicNote()%>" /></td>
	</tr>
	<tr>
		<td>照片編號:</td>
		<td><input type="TEXT" name="picNo" size="45"
			value="<%= (imageVO==null)? "100" : imageVO.getPicNo()%>" /></td>
	</tr>

	

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>

</html>
