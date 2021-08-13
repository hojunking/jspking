<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	function getRecord(n){
		frm.eId.value = n;
		frm.submit();
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">단체 관람</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">단체관람 목록</h6>
		</div>
		<c:if test="${not empty message }">
			<div class="alert alert-warning alert-dismissible fade show" role="alert">
			  <strong>알림!</strong> <br>
			  ${message }
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>	
		</c:if>
		<div class="card-body">
			<div class="table-responsive">
					<table class="table table-bordered table-hover" width="100%" cellspacing="0">
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>종목</th>
								<th>신청인원 수/총 인원수</th>
								<th>날짜</th>
								<th>참가</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="lists" items="${list}">
								<tr>
									<td width="200">${lists.eId}</td>
									<td width="200">${lists.eTitle}</td>
									<td width="200">${lists.eEvent}</td>
									<td width="200">
										${lists.eCount}/${lists.eNumber}
									</td>
									<td width="200">${lists.eDate}</td>
									<td>
										<input type="button" value="참가신청" onclick="getRecord(${lists.eId })"class="btn btn-dark mx-2">
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</div>
			<div>
				<form id="frm" name="frm" action="countEvent.do" method="post">
					<input type="hidden" id="eId" name="eId">
					<input type="hidden" id="eCount" name="eCount" value="${lists.eCount}">
					<input type="hidden" id="eNumber" name="eNumber" value="${lists.eNumber}">
				</form>
			</div>
		</div>
		<div align="center">
			<button onclick="location.href='home.do'" class="btn btn-dark mx-2">home</button>
			<button onclick="location.href='insertEventForm.do'" class="btn btn-dark mx-2">새 글작성</button>
			<button onclick="location.href='deleteEventForm.do'" class="btn btn-dark mx-2">글 삭제하기</button>
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