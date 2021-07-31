<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board 상세보기 페이지</title>
</head>
<body>
	<div align="center">
		<div>
			<h2>${boards.bTitle }</h2>
		</div>
		<hr>
		<div>
			작성자 : ${boards.bWriter }<br> ${boards.bDate }&nbsp;조회수${boards.bHit }
		</div>
		<div>
			<hr>
			${boards.bContent }
		</div>
			<button onclick="location.href='boardList.do'">목록</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<div>
				<form id="frm" name="frm" action="updateForm.do" method="post">
					<input type="submit" value="수정"> <input type="hidden"
						name="bId" id="bId" value="${boards.bId }">
				</form>
			</div>
	</div>
</body>
</html>