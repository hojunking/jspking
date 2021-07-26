<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>
	<div align="center">
		<div>
			<form name="frm" id="frm" action="updateBoard.do" method="post">
				<div>
					<h1>게시글 수정하기</h1>
				</div>

				<table border="1">
					<tr>
						<th width="100">글 번호</th>
						<td width="150">${board.bId }
						<input type="hidden" id="bId" name="bId" value="${board.bId }">
						</td>
						<th width="100">작성자</th>
						<td width="150">${board.bWriter }</td>
						<th width="100">작성일자</th>
						<td width="150">${board.bDate }</td>
						<th width="100">조회수</th>
						<td width="150">${board.bHit }</td>
					</tr>
					<tr>
						<th width="100">글제목</th>
						<td colspan="8"><textarea rows="2" cols="140" id="bTitle"name="bTitle">${board.bTitle }</textarea> </td>
					</tr>
					<tr>
						<th align="center">글 내용</th>
						<td colspan="8"><textarea rows="10"cols="140" id="bContent" name="bContent">${board.bContent }</textarea></td>
					</tr>
				</table>
				<br />
				<div>
					<button type="submit" >수정완료</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>