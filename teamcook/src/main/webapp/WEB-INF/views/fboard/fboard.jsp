<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <!-- Custom fonts for this template from table.html -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

<script>
function getRecord(n) {
	frm.fNo.value = n;
	frm.submit();
}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">자 유 게 시 판</h1>
	<p class="mb-4">자유롭게 의견을 나누는 곳입니다. 문의사항은 별도의 게시판에 남겨주세요.</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">자유게시판</h6>
		</div>

		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" id="dataTable"
					width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>글번호</th>
							<th>작성자</th>
							<th>글 제 목</th>
							<th>작성 일자</th>
							<th>내용</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="fboard" items="${list}">
							<tr onclick="getRecord(${fboard.fNo})">
								<td>${fboard.fNo}</td>
								<td>${fboard.fWriter}</td>
								<td>${fboard.fTitle}</td>
								<td>${fboard.fDate}</td>
								<td>${fboard.fContents}</td>
								<td>${fboard.fCno}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
		<div>
			<form name="frm" action="searchFboard.do" method="post">
				<input type="hidden" id="fNo" name="fNo">
			</form>
		</div>
		<div>
	<button type="button" onclick="location.href='insertFboardForm.do'" class="btn btn-warning btn-icon-split">
		<span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
	</span> <span class="text">글 작성</span>
	</button>
	
			<!-- To do style again -->
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='fboardMain.do'">To List</button>&nbsp;&nbsp;&nbsp;
			</div>
</div>
<!-- /.container-fluid -->
              
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>
	