<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">회원 상세 정보</h1>
	<br>
	
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h4 class="m-0 font-weight-bold text-primary">
				이름: ${list.name }
			</h4>
		</div>
		<form id="frm" name="frm" action="memberUpdate.do" method="post">
			<div class="card-body">
				<div class="table-responsive">
					아이디: ${list.id } <br> 
					<input type="hidden" id="id" name="id" value="${list.id }">
					비밀번호: ${list.password} <br>
					나이: ${list.age }<br>
					성별: ${list.gender }<br>
				</div>
			</div>
			<div>
				<button type="submit" class="btn btn-secondary mx-3">수정</button>
			</div>
		</form>
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