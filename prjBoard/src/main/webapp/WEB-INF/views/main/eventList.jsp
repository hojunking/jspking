<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 리스트</title>
</head>
<body>
	<div align="center">
		<h1>이벤트 리스트</h1>

		<div>
			<table border="1">
				<tr>
					<th width="100">차례</th>
					<th width="100">제목</th>
					<th width="100">이벤트</th>
					<th width="100">숫자</th>
					<th width="100">카운트</th>
					<th width="100">날짜</th>
				</tr>
				<c:forEach var="lists" items="${list}">
					<tr>
						<td width="200">${lists.eId }</td>
						<td width="200">${lists.eTitle}</td>
						<td width="200">${lists.eEvent}</td>
						<td width="200">${lists.eNumber}</td>
						<td width="200">${lists.eCount }</td>
						<td width="200">${lists.eDate }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>