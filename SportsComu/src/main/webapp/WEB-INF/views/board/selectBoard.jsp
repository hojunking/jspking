<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 상세보기</h1>
	<br>
	
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">
				${boards.bTitle }
			</h4>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<h4>${boards.bWriter }</h4>
				${boards.bDate }&nbsp;&nbsp; 조회수: ${boards.bHit }
				<hr>
				<h2>${boards.bContent }</h2><br>
				<hr>
			</div>
		</div>
		<div>
			<form id="frm" name="frm" action="updateForm.do" method="post">
				<input type="submit" value="수정" class="btn btn-dark mx-2"> 
				<input type="hidden" name="bId" id="bId" value="${boards.bId }">
			</form>
		</div>
		<br>
		<div align="left" width="20%">
			<button onclick="location.href='boardList.do'" class="btn btn-dark mx-2">목록</button>
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