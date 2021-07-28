<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공 지 사 항</h1>
	<p class="mb-4">
		여기는 공지사항 페이지입니다.
	</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>순번</th>
							<th>제 목</th>
							<th>작성일자</th>
							<th>작성자</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tfoot>

					</tfoot>
					<tbody>
						<c:forEach var="board" items="${boards }">
							<tr>
								<td>${board.bId }</td>
								<td>${board.bTitle }</td>
								<td>${board.bDate }</td>
								<td>${board.bWriter }</td>
								<td>${board.bHit }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->

<!-- End of Main Content -->