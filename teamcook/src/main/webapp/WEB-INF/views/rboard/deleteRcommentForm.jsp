<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청게시판 댓글 삭제 폼</title>
  <!-- Custom fonts for this template from register.html-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        
</head>
<body>
	<div align="center">
		<div>
			<h1>댓글 삭제</h1>

			<div>
				<form id="frm" name="frm" action="rcommentDelete.do" method="post">
					<table border="1">
						<tr>
							<th width="250">삭제할 댓글 번호 입력</th>
							<td width="150"><input type="text" id="rCno" name="rCno"></td>
							<td width="100"><input type="submit" value="삭제"></td>
					</table>
				</form>
			</div>
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