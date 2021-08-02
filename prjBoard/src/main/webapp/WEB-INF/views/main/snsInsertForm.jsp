<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 만들기</title>
</head>
<body>
	<div align="center">
		<div>
			<form id="frm" name="frm" action="snsInsert.do" method="post">
			<div>
				<h1>게시글 작성</h1>
		</div>
		<table border="1">
			<tr>
				<th width="200">작성자</th>
				<td width="150"><input type="text" id="sWriter" name="sWriter"
					required></td>
			</tr>
			<tr>
				<th width="100">글제목</th>
				<td colspan="3"><input type="text" id="sTitle" name="sTitle"
					required></td>
			</tr>
			<tr>
				<th width="150" align="center">글 내용</th>
				<td colspan="3"><textarea rows="7" cols="75" id="sContents"
						name="sContents" required placeholder="내용을 작성하세요."></textarea></td>
			</tr>
		</table>
		<br />
		<div>
			<button type="submit">등록</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset">취소</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='snsList.do'">목록</button>
		</div>
		</form>
		</div>
	</div>
</body>
</html>