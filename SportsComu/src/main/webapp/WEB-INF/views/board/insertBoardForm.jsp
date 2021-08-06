<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 작성하기</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 작성</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form id="frm" name="frm" action="insertBoard.do" method="post">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>작성자</th>
								<td>
									<input type="text" id="bWriter" name="bWriter" required="required">
								</td>
							</tr>
							<tr>
								<th>공지사항 제목</th>
								<td colspan="2">
									<input type="text" id="bTitle" name="bTitle" required="required">
								</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th>공지사항 내용</th>
								<td colspan="2">
									<textarea rows="7" cols="75" id="bContent" name="bContent" 
										required="required" placeholder="내용을 작성하세요."></textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div>
						<button type="submit">등록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="reset">취소</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" onclick="location.href='boardList.do'">목록</button>
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