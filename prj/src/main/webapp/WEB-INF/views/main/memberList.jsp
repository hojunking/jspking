<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>맴버리스트</h1>
		</div>

		<div>
			<table border="1">
				<tr>
					<th width="100">아 이 디</th>
					<th width="100">패 스 워 드</th>
					<th width="100">이 름</th>
					<th width="100">나 이</th>
					<th width="100">취 미</th>
					<th width="100">권 한</th>
					<th width="100">상 태</th>
				</tr>
				<c:forEach var="list" items="${list }">
					<tr>
						<td width="200">${list.id }</td>
						<td width="200">${list.password }</td>
						<td width="200">${list.name }</td>
						<td width="200">${list.age}</td>
						<td width="200">${list.hobby }</td>
						<td width="200">${list.author }</td>
						<td width="200">${list.state }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>