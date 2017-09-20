<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>IBM Emp: Home</title></head>
<body bgcolor='white'>

<table border='1' cellpadding='5' cellspacing='0' width='400'>
  <tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
    <td><h3>IBM Emp: Home</h3><font color=red>( MVC )</font></td>
  </tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>資料查詢:</h3>
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

<ul>
  <li><a href='listAllPetImage.jsp'>List</a> all Emps. </li> <br><br>
  
  <li>
    <FORM METHOD="post" ACTION="ppp.do" >
        <b>輸入照片編號 8號:</b>
        <input type="text" name="picNo">
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>

  <jsp:useBean id="empSvc" scope="page" class="com.PetImage.model.PetImageService" />
   
  <li>
     <FORM METHOD="post" ACTION="PetImage.do" >
       <b>選擇員工編號:</b>
       <select size="1" name="">
         <c:forEach var="empVO" items="${empSvc.getAll()}" > 
          <option value="${empVO.petNo}">${empVO.petNo}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="emp.do" >
       <b>選擇員工姓名:</b>
       <select size="1" name="empno">
         <c:forEach var="empVO" items="${empSvc.getAll()}" > 
          <option value="${empVO.petNo}">${empVO.petNo}
         </c:forEach>   
       </select>
       <input type="submit" value="送出">
       <input type="hidden" name="action" value="getOne_For_Display">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addPetInfo.jsp'>Add</a> a new Emp.</li>
</ul>

</body>

</html>
