<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">공지사항 수정</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">공지사항 수정</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form name="frm" id="frm" action="updateBoard.do" method="post">
					<div>
					<table class="table table-bordered">
						<tr>
							<th width="100">글 번호</th>
							<td width="150">${boards.bId }
							<input type="hidden" id="bId" name="bId" value="${boards.bId }">
							</td>
							<th width="100">작성자</th>
							<td width="150">${boards.bWriter }</td>
							<th width="100">작성일자</th>
							<td width="150">${boards.bDate }</td>
							<th width="100">조회수</th>
							<td width="150">${boards.bHit }</td>
						</tr>
						<tr>
							<th width="100">글제목</th>
							<td colspan="8"><textarea rows="2" cols="140" id="bTitle"name="bTitle">${boards.bTitle }</textarea> </td>
						</tr>
						<tr>
							<th align="center">글 내용</th>
							<td colspan="8"><textarea rows="10"cols="140" id="bContent" name="bContent">${boards.bContent }</textarea></td>
						</tr>
					</table>
				</div><br/>
				<div>
					<input type="submit" value="저장" class="btn btn-dark mx-2">
				</div>
				</form>
				<br>
				<div>
					<button onclick="location.href='boardList.do'" class="btn btn-dark mx-2">취소</button>
				</div>
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