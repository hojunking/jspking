<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList</title>
</head>
<body>
	<div align="center">
		<div><h2>공지사항리스트</h2></div>
		<div>
		<c:forEach var="boards" items="${boards }">
		아이디:${boards.bId }
		<br>
		title:${boards.bTitle }
		<br>
		content:${boards.bContent}
		<br>
		writer:${boards.bWriter }
		<br>
		date:${boards.bDate}
		<br>
		hit:${boards.bHit}
		</c:forEach>
		</div>
	</div>
</body>
</html>