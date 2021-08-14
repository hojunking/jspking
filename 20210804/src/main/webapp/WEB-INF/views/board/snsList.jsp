<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS List</title>
</head>
<body>
	<div align="center">
		<div><h3>SNS 리스트</h3></div>
		<div>
			<c:forEach var="sns" items="${lists }">
				타이틀 : ${sns.STitle }
			</c:forEach>
		</div>
		<form action="snsBoard.do" method="post" name="frm">
		<input type="button" value="상세보기">
		<input type=hidden value="${sns.SNo }">
		</form>
	</div>
</body>
</html>