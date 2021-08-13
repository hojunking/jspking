<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 댓글 삭제 폼</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>댓글 삭제</h1>

			<div>
				<form id="frm" name="frm" action="fcommentsDelete.do" method="post">
					<table border="1">
						<tr>
							<th width="250">삭제할 댓글 번호 입력</th>
							<td width="150"><input type="text" id="fCno" name="fCno"></td>
							<td width="100"><input type="submit" value="삭제"></td>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>