<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<FORM method="POST" ACTION="<%=request.getContextPath()%>/checkbox">
<BR>
<font size=5 color="red">
Check all Favorite fruits: <br>

<input TYPE="checkbox" name="fruit" VALUE="apples"> ī�G <BR>
<input TYPE="checkbox" name="fruit" VALUE="grapes"> ���� <BR>
<input TYPE="checkbox" name="fruit" VALUE="oranges"> ��l <BR>
<input TYPE="checkbox" name="fruit" VALUE="melons"> ���� <BR>


<br> <INPUT TYPE="submit" name="submit" Value="Submit">

</font>
</FORM>
</body>
</html>