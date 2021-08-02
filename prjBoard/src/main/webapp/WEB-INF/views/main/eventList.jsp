<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 리스트</title>
<script>
	function getRecord() {
		var d = confirm("신청하시겠습니까?")
		var c = '${lists.eCount }';
		var n = '${lists.eNumber}';
		if (d == true) {
			if (n > c) {
				alert("마감되었습니다.")
			} else {
				frm.eId.value;
				frm.submit();
			}
		}
	}
</script>
</head>
<body>
	<div align="center">
		<h1>이벤트 리스트</h1>
		<div>
			<form id="frm" name="frm" action="countEvent.do" method="post">
				<table border="1">
					<tr>
						<th width="100">차례</th>
						<th width="100">제목</th>
						<th width="100">이벤트</th>
						<th width="100">카운트/숫자</th>
						<th width="100">날짜</th>
						<th width="100">참가</th>
					</tr>
					<c:forEach var="lists" items="${list}">
						<tr>
							<td width="200">${lists.eId }</td>
							<td width="200">${lists.eTitle}</td>
							<td width="200">${lists.eEvent}</td>
							<td width="200">${lists.eCount }/${lists.eNumber}</td>
							<td width="200">${lists.eDate }</td>
							<td><input type="button" value="참가신청" onclick="getRecord()"></td>
						</tr>
						<input type="hidden" id="eId" name="eId" value="${lists.eId}">
						<input type="hidden" id="eCount" name="eCount"
							value="${lists.eCount }">
						<input type="hidden" id="eNumber" name="eNumber"
							value="${lists.eNumber}">
					</c:forEach>
				</table>
			</form>
		</div>
		<br>
		<div>
	
			<button onclick="location.href='home.do'">home</button>
			&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='insertEventForm.do'">새 글작성</button>
			&nbsp;&nbsp;&nbsp;
			<button onclick="location.href='deleteEventForm.do'">글 삭제하기</button>
		</div>
	</div>
</body>
</html>