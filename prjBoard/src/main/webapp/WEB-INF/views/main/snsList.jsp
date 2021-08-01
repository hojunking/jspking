<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>snsList</title>
<script>
function getRecord(n){
	frm.sNo.value=n;
	frm.submit();
}
</script>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th>순번</th>
				<th>제 목</th>
				<th>작성일자</th>
				<th>작성자</th>
				<th>댓글수</th>
			</tr>
			<c:forEach var="sns" items="${list }">
				<tr onclick="getRecord(${sns.sNo })">
					<td>${sns.sNo }</td>
					<td>${sns.sTitle}</td>
					<td>${sns.sDate }</td>
					<td>${sns.sWriter }</td>
					<td>${sns.sAno }</td>
				</tr>
			</c:forEach>
		</table>
		<form id="frm" name="frm" action="searchSns.do" method="post">
			<input type="hidden" id="sNo" name="sNo">
		</form>
	</div>
</body>
</html>