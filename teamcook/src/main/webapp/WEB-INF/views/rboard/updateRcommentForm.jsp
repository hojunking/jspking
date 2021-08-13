<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>요청게시판 댓글 수정</title>

  <!-- Custom fonts for this template from register.html-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        
        <script>
            function returnToList(fNo) {
            	returnFrm.returnNo.value=fNo;
                frm.submit();
            }
        </script>

</head>
<body>
	<div align="center">
		<div>
			<h1>댓글 수정</h1>

		</div>
		<div>
			<form id="frm" name="frm" action="rcommentUpdate.do" method="post">
				<div>
				<input type="hidden" id="rCno" name="rCno" value="${upDatedComment.rCno}">
					<table border="1">
						<tr>
							<th width="100">작성자</th>
							<td width="150"><input type="text" id="rcWriter"
								name="rcWriter" value="${session.name }"></td>
								
								<td>${upDatedComment.rCno}번 댓글</td>
							<!-- 여기 인풋 바꿀거임 -->
						</tr>
						<tr>
							<th width="100">내용</th>
							<td colspan="3"><textarea rows="7" cols="65" id="rcSubject"
									name="rcSubject" required placeholder="${upDatedComment.rcSubject}"></textarea>
							</td>
						</tr>
					</table>
				</div>
				<br>
				<div>
					<button type="submit" class="btn btn-secondary btn-icon-split"><span class="icon text-white-50"><i class="fas fa-arrow-right"></i></span> 수정</button>
					&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='searchRboard.do'" class="btn btn-secondary btn-icon-split">
					
					<span class="text">돌아가기</span></button>
					
					<div class="col-lg-3 col-sm-4 mb-3 mb-sm-0 "><button type="button"
                                                class="btn btn-danger btn-user btn-block"
                                                onclick="returnToList(${currentMain})">
                                                <span class="icon text-white-50"><i class="fas fa-arrow-right"></i></span>
                                                돌아가기</button></div>
					
				</div>
			</form>
			
			<form id="returnFrm" name="returnFrm" action="searchFboard2.do" method="post">
                                      <input type="hidden" id="returnNo" name="returnNo">
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