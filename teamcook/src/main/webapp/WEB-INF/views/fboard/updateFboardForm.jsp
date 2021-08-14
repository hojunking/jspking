<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>자유게시판 글 수정</title>

        <!-- Custom fonts for this template from register.html-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
<script>
function getRecord(n) {
   frm.fNo.value = n;
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

                        <div class="col-lg-12">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">글 수정 </h1>
                                </div>
                                <!-- form start -->
                                <form class="user" id="frm" name="frm" action="fboardUpdate.do" method="post">
                                    <input type="hidden" id="fNo" name="fNo" >
                                    <div class="form-group">
                                        <span>글쓴이</span> <input type="text" class="form-control form-control-user" id="fWriter"
                                            name="fWriter" placeholder="${upDateBoard.fWriter }" disabled>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-lg-12 col-sm-12 mb-3 mb-sm-0">
                                            <span>제목</span><input type="text" class="form-control form-control-user" id="fTitle"
                                                name="fTitle" required placeholder="${upDateBoard.fTitle }">
                                        </div>
                                        </div>
                                         <div class="form-group row">
                                        <div class="col-lg-12 col-sm-12 mb-3 mb-sm-0">
                                            <span>내용</span>
                                            <textarea class="form-control" rows="15" id="fContents" name="fContents" placeholder="${upDateBoard.fContents }"></textarea>
                                        </div>
                                    </div>

                                    <button type="submit" type="button" onclick="getRecord('${upDateBoard.fNo}')" class="btn btn-success btn-user btn-block" >
                                        수정
                                    </button>
                                    <br>
                                    <div class="row">
                                        <div class="col-lg-6 col-sm-12 mb-3 mb-sm-0 "><button type="button" class="btn btn-danger btn-user btn-block" onclick="location.href='fboardMain.do'">돌아가기</button></div>
                                        <div class="col-lg-6 col-sm-12 mb-3 mb-sm-0 ">
                                            <input type="reset" class="btn btn-danger btn-user btn-block"
                                                value="취소">
                                        </div>
                                    </div>
                                </form>
                                <!-- form end -->
                                <hr>

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