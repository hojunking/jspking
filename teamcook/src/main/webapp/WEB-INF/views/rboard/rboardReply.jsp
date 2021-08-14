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
		frm.rNo.value = n;
		frm.submit();
	}
	
	function update(n) {
		rupdate.rnum.value = n;
		rupdate.submit();
	}
	function rdelete(n) {
 		delfrm.rdel.value = n;
	  let result = confirm(" 정말 삭제하시겠습니까?? ");
	  if(result) {
	delfrm.submit(n);
	 	 }
 	}
	
	function you(n){
		rcUpdate.rup.value=n;
		console.log(rcUpdate.rup.value);
		rcUpdate.submit();
	}
	
	function rcDelete(n) {
 		delrcrm.rcdel.value = n;
 		let result = confirm(" 정말 삭제하시겠습니까?? ");
 		if(result) {
 			delrcrm.submit(n);
 		}
 	}	
</script>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">요 청 게 시 판</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<i class="fas fa-caret-square-right">${selectBoard.rNo}번 작성글&nbsp;
			
			 <input
				type="button" value="수정" onclick="update(${selectBoard.rNo})"> <input
				type="button" value="삭제" onclick="rdelete(${selectBoard.rNo})">
			</i>
			
		</div>
		<div class="card-body">
			<h6 class="m-0 font-weight-bold text-primary">작성자 :
				${selectBoard.rWriter} / 제목 :${selectBoard.rTitle} / 작성일자 :
				${selectBoard.rDate}</h6>
			<br />
			<p>${selectBoard.rContent}</p>
		</div>
		<div class="card-header py-3">
			<i class="far fa-caret-square-right"></i>댓글
		</div>
		
		<div class="card-body">
			<%-- <c:if test="${list != null}"> --%>
			<c:forEach var="rcomment" items="${selectComment}">
			
				<h6 class="m-0 font-weight-bold text-primary">작성자 :
					${rcomment.rcWriter} / 작성일자 : ${rcomment.rcDate}</h6>
				<br />
				<p>${rcomment.rcSubject}</p>
				<%-- 코멘트수정과 삭제 --%>
				 <input type="button" value="수정" onclick="you('${rcomment.rCno}')">
				<input type="button" value="삭제" onclick="rcDelete('${rcomment.rCno}')">
				
				
			</c:forEach>
			
		</div>
	</div>
	
	
				<div>
	<button type="button" onclick="getRecord('${selectBoard.rNo}')"
		class="btn btn-secondary btn-icon-split">
		<span class="icon text-white-50"><i class="fas fa-arrow-right"></i>
		</span> <span class="text">댓글 작성</span>
	</button>
	
			<!-- To do style again -->
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='rboardMain.do'">To List</button>&nbsp;&nbsp;&nbsp;
			</div>


<!-- 글 수정, 삭제 폼 -->
		<form id="rupdate" name="rupdate" action="rboardUpdateForm.do" method="post">
			<input type="hidden" id="rnum" name="rnum">
		</form>
			
		<form id="delfrm" name="delfrm" action="rboardDelete.do" method="post">
			<input type="hidden" id="rdel" name="rdel">
		</form>
	
	<!-- 댓글 작성 폼 -->
	<form name="frm" action="insertRcommentForm.do" method="post">
		<input type="hidden" id="rNo" name="rNo">
	</form>
	
	<!-- 댓글 수정, 삭제 폼 -->
	<form id="rcUpdate" name="rcUpdate" action="rcommentUpdateForm.do" method="post">
		<input type="hidden" id="rup" name="rup">
	</form>
				
	<form id="delrcrm" name="delrcrm" action="rcommentDelete.do" method="post">
		<input type="hidden" id="rcdel" name="rcdel">
	</form>
</div>
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

