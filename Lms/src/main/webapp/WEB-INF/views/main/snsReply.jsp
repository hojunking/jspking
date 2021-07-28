<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">
	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Community</h1>
	<hr/>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">${list[0].sTitle }</h4>
		</div>
		<div class="card-body">
			${list[0].sWriter}<br />  ${list[0].sDate}<br />
			<hr>
			${list[0].sContents } <br /> <br />
		</div>
	</div>
	<div class="card-body">
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
</div>