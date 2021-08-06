<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>검색</h1>
		</div>
		<div>
			<form id="frm" name="frm" method="post" action="memberSelectResult.do">
				<input type="text" id="id" name="name">
				<input type="submit" value="입력">
			</form>
		</div>
	</div>
</body>
</html>