<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD

<head>
<meta charset="UTF-8">
<title>fileList</title>

<script type="text/javascript">
	function fileDown(orgFile, downFile) {
		frm.orgFile.value = orgFile;
		frm.downFile.value = downFile;
		frm.submit();
	}
</script>

</head>
<body>
	<div align="center">
		<div>
			<h3>파일 목록입니다</h3>
		</div>
		<div>
			<table border="1">
				<c:forEach var="file" items="${files }">
					<tr>
						<th width="100">내용</th>
						<td width="400"><textarea rows="7" cols="80" id="subject">
						${file.subject }
						</textarea></td>

					</tr>
					<tr>
						<td width="70" align="center">첨부파일</td>
						<td width="300" style="cursor: pointer;"
							onclick="fileDown('${file.fileName}','${file.downFile}')">
							${file.fileName} <input type="hidden" value="${file.fileName}">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<form id="frm" name="frm" action="fileDownLoad.do" method="post">
			<input type="hidden" id="orgFile" name="orgFile"> <input
				type="hidden" id="downFile" name="downFile">
		</form>
	</div>
</body>

=======
<head>
<meta charset="UTF-8">
<title>fileList</title>
<script type="text/javascript">
	function fileDown(orgFile, downFile) {
		frm.orgFile.value = orgFile;
		frm.downFile.value = downFile;
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h3>파일 목록입니다</h3>
		</div>
		<div>
			<table border="1">
				<c:forEach var="file" items="${files }">
					<tr>
						<th width="100">내용</th>
						<td width="400"><textarea rows="7" cols="80" id="subject">
						${file.subject }
						</textarea></td>

					</tr>
					<tr>
						<td width="70" align="center">첨부파일</td>
						<td width="300" style="cursor: pointer;"
							onclick="fileDown('${file.fileName}','${file.downFile}')">
							${file.fileName} <input type="hidden" value="${file.fileName}">
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<form id="frm" name="frm" action="fileDownLoad.do" method="post">
			<input type="hidden" id="orgFile" name="orgFile"> <input
				type="hidden" id="downFile" name="downFile">
		</form>
	</div>
</body>
>>>>>>> branch 'master' of https://github.com/gkwlal3/jspking.git
</html>