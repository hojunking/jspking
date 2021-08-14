<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function getRecord(n){
		var d = confirm("정말로 삭제하시겠습니까?")
		if(d == true){
			frm.eId.value = n;
			frm.submit();
			alert("삭제완료!!");
		}
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">단체관람 목록 삭제</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">단체관람 목록 삭제</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th width="100">차례</th>
							<th width="100">제목</th>
							<th width="100">이벤트</th>
							<th width="100">카운트/숫자</th>
							<th width="100">날짜</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="lists" items="${list}">
							<tr onmouseover="this.style.background='red'"
								onmouseout="this.style.background='white'"
								onclick="getRecord(${lists.eId })">
								<td width="200">${lists.eId }</td>
								<td width="200">${lists.eTitle}</td>
								<td width="200">${lists.eEvent}</td>
								<td width="200">${lists.eCount }/${lists.eNumber}</td>
								<td width="200">${lists.eDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
				<form id="frm" name="frm" action="deleteEvent.do" method="post">
					<input type="hidden" id="eId" name="eId">
				</form>
		</div>
		<hr>
		<div>
			<button onclick="location.href='eventList.do'" class="btn btn-dark mx-2">삭제종료</button>
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