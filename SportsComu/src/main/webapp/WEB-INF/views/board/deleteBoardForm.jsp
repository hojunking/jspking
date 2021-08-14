<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function getRecord(n){
		var d = confirm("정말로 삭제하시겠습니까?")
		if(d == true){
			frm.bId.value = n;
			frm.submit();
			alert("삭제완료!!");
		}
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 삭제</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 삭제</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th width="100">NUMBER</th>
							<th width="100">WRITER</th>
							<th width="100">TITLE</th>
							<th width="100">DATE</th>
							<th width="100">HIT</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="boards" items="${boards }">
							<tr onmouseover="this.style.background='red'"
								onmouseout="this.style.background='white'"
								onclick="getRecord(${boards.bId })">
								<td width="200">${boards.bId }</td>
								<td width="200">${boards.bWriter }</td>
								<td width="200">${boards.bTitle }</td>
								<td width="200">${boards.bDate}</td>
								<td width="200">${boards.bHit}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
				<form id="frm" name="frm" action="deleteBoard.do" method="post">
					<input type="hidden" id="bId" name="bId">
				</form>
		</div>
		<hr>
		<div>
			<button onclick="location.href='boardList.do'">공지사항 목록</button>
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