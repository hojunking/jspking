<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제하기</title>
<script type="text/javascript">
	function getRecord(n){
		var d =confirm("정말로 삭제하시겠습니까?")
		if(d== true){
		frm.bId.value=n;
		frm.submit();
		alert("삭제완료!!")
		}else{
			
		}
	}
</script>

</head>
<body>
	<div align="center">
		<div>
			<h2>삭제하기</h2>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">number</th>
					<th width="100">writer</th>
					<th width="100">title</th>
					<th width="100">date</th>
					<th width="100">hit</th>
				</tr>
				<c:forEach var="boards" items="${boards }">
					<tr onmouseover="this.style.background='red'"
						onmouseout="this.style.background='white'"
						onclick="getRecord(${boards.bId })">
						<td width="200">${boards.bId }</td>
						<td width="200">${boards.bWriter }</td>
						<td width="200">${boards.bTitle }</td>
						<td width="200">${boards.bDate}</td>
						<td width="200">${boards.bHit}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<form id="frm" name="frm" action="deleteBoard.do" method="post">
					<input type="hidden" id="bId" name="bId">
				</form>
			</div>
		</div>
		<hr>
		<div>
			<button onclick="location.href='boardList.do'">삭제완료</button>
		</div>
	</div>
</body>
</html>