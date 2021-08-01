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
	<hr/><div>
			<h4>${list[0].sTitle }</h4>
			${list[0].sWriter}<br />  ${list[0].sDate}<br />
			<hr>
			${list[0].sContents } <br /> <br />
		</div>
	<div>
		<b>댓글</b>
		<c:if test="${not empty list[0].cName }">
			<c:forEach var="sns" items="${list }">
				<hr>
			<b>${sns.cName}</b><br />
			${sns.cSubject}<br />
			${sns.cDate }<br />
			</c:forEach>
		</c:if>
	</div>

</body>
</html>