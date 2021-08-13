<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	function getRecord(n){
		frm.sNo.value = n;
		frm.submit();
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시판</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">게시판 목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>순 번</th>
							<th>제 목</th>
							<th>작성일자</th>
							<th>작성자</th>
							<th>댓글수</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sns" items="${list }">
							<tr onclick="getRecord(${sns.sNo })">
								<td>${sns.sNo }</td>
								<td>${sns.sTitle}</td>
								<td>${sns.sDate }</td>
								<td>${sns.sWriter }</td>
								<td>${sns.sAno }</td>
								<td>${sns.sHit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<form id="frm" name="frm" action="searchSns.do" method="post">
				<input type="hidden" id="sNo" name="sNo">
			</form>
		</div>
		<div><br/>
			<button onclick="location.href='snsInsertForm.do'" class="btn btn-dark mx-2">글작성하기</button>
			<button onclick="location.href='home.do'" class="btn btn-dark mx-2">홈으로</button>
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