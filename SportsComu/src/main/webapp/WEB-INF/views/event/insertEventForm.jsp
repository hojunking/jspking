<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">단체관람 글 쓰기</h1>
	<br>
	
	<div class="card shadow mb-4">
		<div class="card-body">
			<div class="table-responsive">
				<form id="frm" name="frm" action="insertEvent.do" method="post">
					<table class="table table-bordered table-hover" width="100%" cellspacing="0">
						<tr>
							<th>제목</th>
							<th>종목</th>
							<th>모집인원</th>
							<th>날짜</th>
						</tr>
						<tr>
							<td><input type="text" name="eTitle"></td>
							<td><input type="text" name="eEvent"></td>
							<td><input type="text" name="eNumber"></td>
							<td><input type=text name="eDate"></td>
						</tr>
					</table>
					<div>
						<input type="submit" value="생성" class="btn btn-dark mx-2">
					</div>
				</form>
				<br>
				<div>
					<button onclick="location.href='eventList.do'" class="btn btn-dark mx-2">목록</button>
				</div>
			</div>
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