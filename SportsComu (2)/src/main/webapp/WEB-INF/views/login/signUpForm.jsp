<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>회원가입</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.css" rel="stylesheet">

	<script type="text/javascript">
	<!-- 필수 입력정보인 아이디, 비밀번호가 입력되었는지 확인하는 함수 -->
		function checkValue(){
			if(!document.frm.id.value){
				alert("아이디를 입력하세요.");
				return false;
			}
			
			if(!document.frm.password.value){
				alert("비밀번호를 입력하세요.");
				return false;
			}
			<!-- 비밀번호와 비밀번호 확인이 같은 값인지 확인 -->
			if(document.frm.password.value != document.frm.passwordok.value){
				alert("비밀번호를 동일하게 입력하세요.");
				return false;
			}
		}
		
		function winopen(){
			window.open("idCheckForm.lo", "아이디 중복 체크", "width=400, height=350");
		}
		
		function winopen1(){
			frm = document.getElementById('frm');
			window.open("", "a", "width=600, height=600");
			frm.action="signUpCheck.lo";
			frm.method="post";
			frm.submit();
		}
	</script>
	
</head>

<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create New ID!</h1>
                            </div>
                            <form class="user" id="frm" name="frm" action="signUpCheck.lo" target="a" method="post" onsubmit="return checkValue()">
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="id" name="id"
                                            placeholder="아이디" required="required">
                                    </div>
                                    <div class="col-sm-6">
                                        <a href="" onclick="winopen()" class="btn btn-primary btn-user btn-block">
                                    	중복체크 </a>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="password" name="password" placeholder="비밀번호" required="required">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="passwordok" name="passwordok" placeholder="비밀번호 확인">
                                    </div>
                                </div>
                                <div class="form-group row">
                                	<div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"
                                            id="name" name="name" placeholder="이름">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="number" class="form-control form-control-user"
                                            id="age" name="age" placeholder="나이">
                                    </div>
                                </div>
                                <div class="form-group">
                                	성별: &nbsp;&nbsp;
                                	<label><input type="checkbox" id="gender" name="gender" value="남자">남자</label>&nbsp;&nbsp;&nbsp;
									<label><input type="checkbox" id="gender" name="gender" value="여자">여자</label>
                                </div>
                                <button type="submit" onclick="winopen1()" class="btn btn-primary btn-user btn-block">
                                    회원 가입
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
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