<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertForm</title>
</head>
<body>
	<form id="frm" name="frm" action="insertEvent.do" method="post">
	<table border="1">
				<tr>
					<th width="100">제목</th>
					<th width="100">이벤트</th>
					<th width="100">모집인원</th>
					<th width="100">날짜</th>
				</tr>
					<tr>
						<td width="200"><input type="text" name="eTitle"></td>
						<td width="200"><input type="text" name="eEvent"></td>
						<td width="200"><input type="text" name="eNumber"></td>
						<td width="200"><input type=text name="eDate"></td>
					</tr>
			</table>
			<div>
				<input type="submit" value="생성">
			</div>
			</form>
			<div>
				<button onclick="location.href='eventList.do'">목록</button>
			</div>
</body>
</html>