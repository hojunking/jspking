<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 정보 수정</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">회원 정보 수정</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form id="frm" name="frm" action="memberUpdateOk.do" method="post">
					<div>
					<table class="table table-bordered">
						<tr>
							<th width="100">ID</th>
							<td width="70" align="center">
								${member.id }
								<input type="hidden" id="id" name="id" value="${member.id }">
							</td>
						</tr>
						<tr>
							<th>PASSWORD</th>
							<td align="center">
								<input type="password" id="password" name="password" value="${member.password }">
							</td>
						</tr>
						<tr>
							<th>NAME</th>
							<td align="center">
								<input type="text" id="name" name="name" value="${member.name }">
							</td>
						</tr>
						<tr>
							<th>AGE</th>
							<td align="center">${member.age }</td>
						</tr>
						<tr>
							<th>GENDER</th>
							<td align="center">${member.gender }</td>
						</tr>
					</table>
				</div><br/>
				<div>
					<button type="submit" class="btn btn-secondary">수정완료</button>
				</div>
				</form>
			</div>
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