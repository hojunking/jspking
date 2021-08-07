<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileUploadForm</title>
</head>
<body>
	<div align="center">
		<div>
			<h3>파일등록하기</h3>
		</div>
		<div>
			<form id="frm" name="frm" action="fileUpload.do"
				enctype="multipart/form-data" method="post">
				<div>
					<table border="1">
						<tr>
							<td width="100" align="center">내용</td>
							<td width="400"><textarea rows="7" cols="60" id="subject"
									name="subject"></textarea></td>
						</tr>
						<tr>
							<td width="100" align="center">파일</td>
							<td width="400"><input type="file" id="fileName"
								name="fileName" size="60"></td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<input type="submit" value="파일전송">
				</div>
			</form>
		</div>
	</div>
</body>
</html>