<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	function getRecord(n){
		frm.bId.value=n;
		frm.submit();
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 전체 목록</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>NUMBER</th>
							<th>WRITER</th>
							<th>TITLE</th>
							<th>DATE</th>
							<th>HIT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="boards" items="${boards }">
							<tr onclick="getRecord(${boards.bId })">
								<td>${boards.bId }</td>
								<td>${boards.bWriter }</td>
								<td>${boards.bTitle }</td>
								<td>${boards.bDate }</td>
								<td>${boards.bHit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<form id="frm" name="frm" action="selectBoard.do" method="post">
				<input type="hidden" id="bId" name="bId">
			</form>
		</div>
		<div align="center">
			<button onclick="location.href='home.do'" class="btn btn-dark mx-2">home</button>
			<c:if test="${session.author eq 'ADMIN' }">
				<button onclick="location.href='insertBoardForm.do'" class="btn btn-dark mx-2">새 글작성</button>
				<button onclick="location.href='deleteBoardForm.do'" class="btn btn-dark mx-2">글 삭제하기</button>
			</c:if>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Page level plugins -->
<script src="vendor/datatables/jquery.dataTables.min.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>