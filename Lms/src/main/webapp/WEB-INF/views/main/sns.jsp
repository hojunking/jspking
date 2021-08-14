<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
function getRecord(n){
	frm.sNo.value=n;
	frm.submit();
}
</script>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Community</h1>
	<p class="mb-4">
		여기는 커뮤니티 입니다.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Community 목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>순번</th>
							<th>제 목</th>
							<th>작성일자</th>
							<th>작성자</th>
							<th>댓글수</th>
						</tr>
					</thead>
					<tfoot>

					</tfoot>
					<tbody>
						<c:forEach var="sns" items="${list }">
							<tr onclick="getRecord(${sns.sNo })">
								<td>${sns.sNo }</td>
								<td>${sns.sTitle}</td>
								<td>${sns.sDate }</td>
								<td>${sns.sWriter }</td>
								<td>${sns.sAno }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
		<form id="frm" name="frm" action="searchSns.do" method="post">
			<input type="hidden" id="sNo" name="sNo">
			</form>
		</div>
</div>
<!-- /.container-fluid -->

<!-- End of Main Content -->