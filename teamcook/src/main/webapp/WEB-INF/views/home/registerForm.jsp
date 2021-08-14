<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Register</title>

<!-- Custom fonts for this template from register.html-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

       
        <script>
           
            function checkValue(){
                
                var form = document.frm;

                if (!form.id.value) {
                    alert("아이디를 입력하세요.");
                    return false;
                }


                if (!form.password.value) {
                    alert("비밀번호를 입력하세요.");
                    return false;
                }
                // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
                if (form.password.value != form.passCheck.value) {
                    alert("비밀번호를 동일하게 입력하세요.");
                    return false;
                }
                 if (!form.name.value) {
                    alert("이름을 입력하세요.");
                    return false;
                }
                if (!form.mail1.value) {
                    alert("메일 주소를 입력하세요.");
                    return false;
                }
            }
            // cancel-> return to home/login page
            function goFirstForm() {
                    location.href = "home.do";
            }
            // 아이디 중복체크 화면open
            function openIdchk() {
            	var id=document.getElementById("id").value;
                window.name = "parentForm";
                window.open("idCheckForm.do?id="+id,
                    "chkForm", "width=500, height=300, resizable = no, scrollbars = no");
            }
        // 아이디 입력창에 값 입력시 hidden에 idUncheck를 세팅한다.
        // 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
        // 다시 중복체크를 하도록 한다.
        function inputIdChk() {
            document.frm.idDuplication.value = "idUncheck";
        }


        </script>

    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-5 d-none d-lg-block"><img src="img/lots.jpg"></div>
                        <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                                </div>
                                <!-- form start -->
                                <form class="user" id="frm" name="frm" action="register.do" method="post" onsubmit="return checkValue()">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="id" name="id"
                                            placeholder="Enter your id" onkeydown="inputIdChk()">
                                        <input type="hidden" name="idDuplication" id="idDuplication" value="idUncheck">
                                          
                                        <button  type="button"  id="idCheckBtn"  onclick="openIdchk()">Id check</button>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="name" name="name"
                                            placeholder="Name">
                                    </div>
                                    <div class="form-group row">
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user"
                                                    id="password" name="password" placeholder="Password">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control form-control-user"
                                                    id="passCheck" name="passCheck" placeholder="Repeat Password">
                                            </div>
                                        </div>

                                    </div>
                                    <div class="form-group">
                                        <input type="email" class="form-control form-control-user" id="email"
                                            name="email" placeholder="Email Address">
                                    </div>

                                    <button type="submit" class="btn btn-primary btn-user btn-block">
                                        Register Account
                                    </button>

                                </form>
                                <!-- form end -->
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="forgot-password.html">Forgot Password?</a>
                                </div>
                                <div class="text-center">
                                    <a class="small" href="loginForm.do">Already have an account? Login!</a>
                                </div>
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