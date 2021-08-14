<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	function getRecord(n){
		frm.id.value = n;
		frm.submit();
	}
</script>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 전체 목록</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 목록</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered table-hover" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>PASSWORD</th>
							<th>NAME</th>
							<th>AGE</th>
							<th>GENDER</th>
							<th>AUTHOR</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="member" items="${list }">
							<tr onclick="getRecord(${member.id})">
								<td align="center">${member.id }</td>
								<td align="center">${member.password }</td>
								<td align="center">${member.name }</td>
								<td align="center">${member.age }</td>
								<td align="center">${member.gender }</td>
								<td align="center">${member.author }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div>
			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
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