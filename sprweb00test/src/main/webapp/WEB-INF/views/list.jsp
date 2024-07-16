<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 1은 ${username}<br>
결과 2는 ${requestScope.username}<br>
<%
String ss = (String)request.getAttribute("msg");
out.println("결과 3은 " + ss);
%>
</body>
</html>