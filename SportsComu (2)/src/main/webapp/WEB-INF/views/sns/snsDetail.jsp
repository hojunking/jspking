<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시판</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h5 class="m-0 font-weight-bold text-primary">게시판 목록</h5>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<div>
					<h4>${list[0].sTitle }</h4>
					<br> 조회수 : ${list[0].sHit} <br> ${list[0].sWriter}<br/>
					${list[0].sDate}<br/>
					<hr>
					<h4>${list[0].sContents }</h4> <br>
					<form id="fra" name="fra" action="deleteSns.do" method="post">
						<input type="hidden" name="sNo" value="${list[0].sNo }" id="sNo">
						<input type="submit" value="게시글 삭제" class="btn btn-secondary">
					</form><br/>
				</div>
			</div>
		</div>
	</div>
				
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">댓글</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<div>
					<c:if test="${not empty list[0].cName }">
						<c:forEach var="sns" items="${list }">
							<hr>
							<b>${sns.cName}</b>
							<br/>
							${sns.cSubject}<br/>
							${sns.cDate }<br/>
							<form id="frb" name="frb" action="deleteComments.do" method="post">
								<input type="hidden" name="cNo" value="${sns.cNo }" id="cNo">
								<input type="hidden" name="sNo" value="${list[0].sNo }" id="sNo">
								<input type="submit" value="댓글삭제" class="btn btn-secondary">
							</form> <br/>
						</c:forEach>
					</c:if>
				</div>
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
						id="sNo"> <input type="submit" value="등록" class="btn btn-secondary">
					&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-secondary">새로 작성</button>
				</form>
			</div>
			<br>
			<div>
				<button type="button" class="btn btn-secondary" onclick="location.href='snsList.do'">취소</button>
			</div>
		</div>
	</div>
</div>

<!-- /.container-fluid -->

<!-- End of Main Content -->

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>