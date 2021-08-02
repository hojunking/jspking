<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판</h1>
	<hr />
	<div>
		<h4>${list[0].sTitle }</h4>
		<br> 조회수 : ${list[0].sHit} <br> ${list[0].sWriter}<br />
		${list[0].sDate}<br />
		<hr>
		${list[0].sContents } <br />
		<form id="fra" name="fra" action="deleteSns.do" method="post">
			<input type="hidden" name="sNo" value="${list[0].sNo }" id="sNo">
			<input type="submit" value="게시글 삭제">
		</form>
		<br />
	</div>
	<div>
		<b>댓글</b>
		<c:if test="${not empty list[0].cName }">
			<c:forEach var="sns" items="${list }">
				<hr>
				<b>${sns.cName}</b>
				<br />
			${sns.cSubject}<br />
			${sns.cDate }<br/>
			${sns.cNo }
			<form id="frb" name="frb" action="deleteComments.do" method="post">
					<input type="hidden" name="cNo" value="${sns.cNo }" id="cNo">
					<input type="hidden" name="sNo" value="${list[0].sNo }" id="sNo">
					<input type="submit" value="댓글삭제">
				</form>
				<br />
			</c:forEach>
		</c:if>
	</div>
	<div>
		<form id="frm" name="frm" action="commentsForm.do" method="post">
			<hr>
			<b>댓글 작성</b><br> <input type="text" id="cname" name="cname"
				required placeholder="이름을 작성하세요."> <br>
			<!-- 댓글 내용 -->
			<textarea rows="7" cols="75" id="csubject" name="csubject" required
				placeholder="내용을 작성하세요."></textarea>
			<br>
			 <input type="hidden" name="sNo" value="${list[0].sNo }"
				id="sNo"> <input type="submit" value="등록">
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="reset">새로 작성</button>
		</form>
	</div>
	<br>
	<div>
		<button type="button" onclick="location.href='snsList.do'">취소</button>
	</div>

</body>
</html>