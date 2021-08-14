<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
function getRecord(n) {
	frm.rNo.value = n;
	frm.submit();
}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">요 청 게 시 판</h1>
	<p class="mb-4">원하시는 레시피가 있거나, 기타 요청 및 문의 사항만 글 남겨 주세요.</p>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">요청게시판</h6>
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
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rboard" items="${list}">
							<tr onclick="getRecord(${rboard.rNo})">
								<td>${rboard.rNo}</td>
								<td>${rboard.rWriter}</td>
								<td>${rboard.rTitle}</td>
								<td>${rboard.rDate}</td>
								<td>${rboard.rContent}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<div>
	<!-- 테이블에서 글 클릭하면 본문으로 넘어가는 곳 -->
		<form name="frm" action="searchRboard.do" method="post">
			<input type="hidden" id="rNo" name="rNo">
		</form>
	</div>
			
			<!-- 요청글 작성 -->
			<div>
	<button type="button" onclick="location.href='insertRboardForm.do'" class="btn btn-warning btn-icon-split">
		<span class="icon text-white-50"> <i class="fas fa-arrow-right"></i>
	</span> <span class="text">글 작성</span>
	</button>
	
			<!-- To do style again -->
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='rboardMain.do'">To List</button>&nbsp;&nbsp;&nbsp;
			</div>
</div>
<!-- /.container-fluid -->