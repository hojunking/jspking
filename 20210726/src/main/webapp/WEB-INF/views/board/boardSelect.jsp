<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지글 상세보기</title>
<script type="text/javascript">
	function path(n){
		if(n==1){
		frm.action('updateForm.do');
		}else{
		frm.action("deleteBoard.do");
		}
	frm.submit();}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 상세보기</h1>
		</div>
		<div>
			<div>
				<form id="frm" name="frm" action="" method="post">
					<table border="1">
						<tr>
							<th width="100">글 번호</th>
							<td width="150">${board.bId }</td>
							<th width="100">작성자</th>
							<td width="150">${board.bWriter }</td>
							<th width="100">작성일자</th>
							<td width="150">${board.bDate }</td>
							<th width="100">조회수</th>
							<td width="150">${board.bHit }</td>
						</tr>
						<tr>
							<th width="100">글제목</th>
							<td colspan="8">${board.bTitle }</td>
						</tr>
						<tr>
							<th align="center">글 내용</th>
							<td colspan="8"><textarea rows="10" cols="140">${board.bContent }</textarea></td>
						</tr>
					</table>
					<br />
					<button type="button" onclick="location.href='boardList.do'">목록</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="path(1)">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="path(2)">삭제</button>
					<input type="hidden" id="bId" name="bId" value="${board.bId }">
				</form>
			</div>
			<form id="frc" name="frc" action="deleteBoard.do" method="post">
				
				
			</form>

		</div>
	</div>
</body>
</html>