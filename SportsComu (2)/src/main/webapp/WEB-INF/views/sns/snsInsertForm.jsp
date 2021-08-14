<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">게시판</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">새 게시판 작성</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form id="frm" name="frm" action="snsInsert.do" method="post">
					<table class="table table-bordered table-hover" width="100%" cellspacing="0">
						<tr>
							<th width="200">작성자</th>
							<td width="150"><input type="text" id="sWriter" name="sWriter"
								required></td>
						</tr>
						<tr>
							<th width="100">글제목</th>
							<td colspan="3"><input type="text" id="sTitle" name="sTitle"
								required></td>
						</tr>
						<tr>
							<th width="150" align="center">글 내용</th>
							<td colspan="3"><textarea rows="7" cols="75" id="sContents"
									name="sContents" required placeholder="내용을 작성하세요."></textarea></td>
						</tr>
					</table><br/>
					<div>
						<button type="submit">등록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="reset">취소</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="location.href='snsList.do'">목록</button>
					</div>
				</form>
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