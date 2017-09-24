<%@ page contentType="text/html; charset=Big5"%>
<%@ page import="com.PetImage.model.*"%>

<%


PetImageVO PetImageVO = (PetImageVO)request.getAttribute("picVO"); //PetImageServlet.java(Concroller), 存入req的empVO物件

%>
<html>

<title>員工資料 - listOnePic.jsp</title>
</head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='600'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td>
		<h3>照片清單 - ListOnePic.jsp</h3>
		<a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
		</td>
	</tr>
</table>

<table border='1' bordercolor='#CCCCFF' width='600'>
	<tr>
		<th>照片編號</th>
		<th>動物編號</th>
		<th>照片</th>
		<th>說明</th>
		<th>照片名稱</th>
		
	</tr>
	<tr align='center' valign='middle'>
		<td>${picVO.picNo}</td>
		<td>${picVO.petNo}</td>
		<td>${picVO.petPicture}</td>
		<td>${picVO.picNote}</td>
		<td>${picVO.picName}</td>
	</tr>
	
	
</table>

</body>
</html>
