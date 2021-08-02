<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이벤트 리스트</title>
<script type="text/javascript">
function getRecord(n){
	var d =confirm("정말로 삭제하시겠습니까?")
	if(d== true){
	frm.eId.value=n;
	frm.submit();
	alert("삭제완료!!")
	}else{
		
	}
}
</script>
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
					<th width="100">카운트/숫자</th>
					<th width="100">날짜</th>
				</tr>
				<c:forEach var="lists" items="${list}">
					<tr onmouseover="this.style.background='red'"
						onmouseout="this.style.background='white'"
						onclick="getRecord(${lists.eId })">
						<td width="200">${lists.eId }</td>
						<td width="200">${lists.eTitle}</td>
						<td width="200">${lists.eEvent}</td>
						<td width="200">${lists.eCount }/${lists.eNumber}</td>
						<td width="200">${lists.eDate }</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<form id="frm" name="frm" action="deleteEvent.do" method="post">
					<input type="hidden" id="eId" name="eId">
				</form>
			</div>
		</div>
		<br>
		<div>
			<div>
			<button onclick="location.href='eventList.do'">삭제종료</button>
		</div>
		</div>
	</div>
</body>
</html>