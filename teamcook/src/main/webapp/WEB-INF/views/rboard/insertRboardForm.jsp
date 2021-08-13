<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 하는 곳</title>

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
			<h1>요청게시판</h1>
			<p class="mb-4">원하시는 레시피가 있거나, 기타 요청 및 문의 사항만 글 남겨 주세요.</p>
		</div>
		<div>
			<form id="frm" name="frm" action="insertRboard.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150"><input type="text" id="rWriter"
								name="rWriter" value="${session.name}"></td>
							<!-- 여기 인풋 바꿀거임 -->
						</tr>
						<tr>
							<th width="100">제목</th>
							<td colspan="3"><input type="text" id="rTitle" name="rTitle"
								size="60" required></td>
						</tr>
						<tr>
							<th width="100">내용</th>
							<td colspan="3"><textarea rows="7" cols="65" id="rContent"
									name="rContent" required placeholder="이곳에다 내용을 써 주세용"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="submit">등록</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='rboardMain.do'">돌아가기</button>
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