<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청게시판 글 수정</title>

  <!-- Custom fonts for this template from register.html-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

<script>
function getRecord(n) {
	frm.rNo.value = n;
	frm.submit();
}

function
</script>


</head>
<body>
	<div align="center">
		<div>
			<h1>글 수정</h1>

		</div>
		<div>
			<form id="frm" name="frm" action="rboardUpdate.do" method="post">
				<div>
					<input type="hidden" id="rNo" name="rNo" value="${upList[0].rNo}">
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150">${upDateBoard.rWriter}</td>
						<td>${upDateBoard.rNo}번 작성글</td>
						</tr>
						<tr>
							<th width="100">제목</th>
							<td colspan="3"><input type="text" id="rTitle" name="rTitle"
								size="60" required placeholder="${upDateBoard.rTitle}"></td>
						</tr>
						<tr>
							<th width="100">내용</th>
							<td colspan="3"><textarea rows="7" cols="65" id="rContent"
									name="rContent" required placeholder="${upDateBoard.rContent}"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="submit" class="btn btn-secondary btn-icon-split" type="button" onclick="getRecord('${upDateBoard.rNo}')">
					<span class="icon text-white-50"><i
							class="fas fa-arrow-right"></i></span> <span class="text">수정</span>
					</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='searchRboard.do'">돌아가기</button>
					
				
				
				</div>
			</form>
			
			
		</div>
	</div>
	
	  <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>
	
	
</body>
</html>