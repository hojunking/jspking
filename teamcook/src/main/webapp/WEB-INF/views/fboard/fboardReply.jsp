<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">



<script>
	function getRecord(n) {
		frm.fNo.value = n;
		frm.submit();
	}
	//메인글 수정
	function update(n) {
		
		document.forms['fupdate']['fnum'].value = n;
		fupdate.submit();
	}
	function fDelete(n) {
	 	delfrm.fdel.value = n;
		  let result = confirm(" 정말 삭제하시겠습니까?? ");
		  if(result) {
		delfrm.submit(n);
		 	 }
	 	} 
   

	function fcUpdate(n,currentNo) {
		console.log(n);
		fcupdate.fup.value = n;
		fcupdate.currentMain.value=currentNo;
		fcupdate.submit();
	}
	function fcDelete(n) {
 		delfcrm.fcdel.value = n;
 		let result = confirm(" 정말 삭제하시겠습니까?? ");
 		if(result) {
 			delfcrm.submit(n);
 		}
 	}	
	
</script>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">자 유 게 시 판</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">

		<div class="card-header py-3">
			<i class="fas fa-caret-square-right">${selectBoard.fNo}번 작성글&nbsp;
			<input type="button" value="수정" onclick="update(${selectBoard.fNo})">
			<input type="button" value="삭제" onclick="fdelete(${selectBoard.fNo})"></i>
		</div>

		<div class="card-body">
			<h6 class="m-0 font-weight-bold text-primary">
			작성자 : ${selectBoard.fWriter} / 제목 :  ${selectBoard.fTitle}  / 작성일자 : ${selectBoard.fDate}</h6>
			<br />
			<p>${selectBoard.fContents}</p>
		</div>

		<!--  댓글 ...포이치 돌려서 메인 글에 달린 댓글 구현 -->
		<div class="card-header py-3">
			<i class="far fa-caret-square-right">댓글</i>
		</div>

		<div class="card-body">
			<c:forEach var="fcomments" items="${selectComments}">
				<h6 class="m-0 font-weight-bold text-primary">작성자 : ${fcomments.fcName} / 작성일자 : ${fcomments.fcDate}</h6>
				<br />
				<p>${fcomments.fcSubject}</p>
					<button type="button" value="수정" onclick="fcUpdate('${fcomments.fCno}', '${selectBoard.fNo}')">수정</button>
					<button type="button" value="삭제"  onclick="fcDelete('${fcomments.fCno}')">삭제</button>
				
			</c:forEach>
		</div>
	</div>
<div>
	<button type="button" onclick="getRecord('${selectBoard.fNo}')" class="btn btn-warning btn-icon-split">
		<span class="icon text-white-50"><i class="fas fa-arrow-right"></i></span>
		<span class="text">댓글 작성</span>
	</button>
		<!-- To do style again -->
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='fboardMain.do'">To List</button>&nbsp;&nbsp;&nbsp;
			</div>
	
	<!-- 글 수정, 삭제 폼 -->
		<form id="fupdate" name="fupdate" action="fboardUpdateForm.do" method="post">
			<input type="hidden" id="fnum" name="fnum">
		</form>

		<form id="delfrm" name="delfrm" action="fboardDelete.do" method="post">
			<input type="hidden" id="fdel" name="fdel" value="${list[0].fNo}">
		</form>

	<!-- 댓글작성 폼 -->
	<form name="frm" action="insertFcommentsForm.do" method="post">
		<input type="hidden" id="fNo" name="fNo">
	</form>
</div>
<!-- 댓글수정 -->
<form id="fcupdate" name="fcupdate" action="fcommentsUpdateForm.do" method="post">
		<input type="hidden" id="fup" name="fup">
		<input type="hidden" id="currentMain" name="currentMain">
	</form>
				
	<form id="delfcrm" name="delfcrm" action="fcommentsDelete.do" method="post">
		<input type="hidden" id="fcdel" name="fcdel">
	</form>
<!-- /.container-fluid -->

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/chart-area-demo.js"></script>
	<script src="js/demo/chart-pie-demo.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>