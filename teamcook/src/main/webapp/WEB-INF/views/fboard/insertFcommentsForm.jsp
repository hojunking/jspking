<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>댓글 작성 하는 곳</title>

        <!-- Custom fonts for this template from register.html-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
       <script>
       function returnToList(n){
    	   	document.forms['returnFrm']['returnNo'].value = n;
    		console.log(returnFrm.returnNo)
    		returnFrm.submit();
    	   
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
                                    <h1 class="h4 text-gray-900 mb-4">자유게시판</h1>
                                    <p class="mb-4">자유롭게 의견을 나누는 곳입니다. 문의사항은 별도의 게시판에 남겨주세요.</p>
                                </div>
                                <!-- form start -->
                                <form class="user" id="frm" name="frm" action="insertFcomments.do" method="post">
                                    <div class="form-group">
                                        <input type="hidden" id="fNo" name="fNo" value="${insertComment.fNo}">
                                        <span>글쓴이</span> <input type="text" class="form-control form-control-user"
                                            id="fcName" name="fcName" placeholder="${session.name}"
                                            value="${session.name}">
                                            <span>${insertComment.fNo}번 작성글</span>
                                        <!-- 여기 나중에 disable줄거야 엇 안주니까 넘어갘ㅋㅋㅋ-->
                                    </div>

                                  
                                    <div class="form-group row">
                                        <div class="col-lg-12 col-sm-12 mb-3 mb-sm-0">
                                            <span>내용</span>
                                            <textarea class="form-control" rows="7" id="fcSubject" name="fcSubject"
                                                placeholder="이곳에다 내용을 써 주세용"></textarea>
                                        </div>
                                    </div>

                                    <button type="submit" 
                                        class="btn btn-success btn-user btn-block">
                                        등록
                                    </button>
                                    <br>
                                    <div class="row">
                                        <div class="col-lg-6 col-sm-4 mb-3 mb-sm-0 "></div>
                                        <div class="col-lg-3 col-sm-4 mb-3 mb-sm-0 "><button type="button"
                                                class="btn btn-danger btn-user btn-block"
                                                onclick="returnToList(${insertComment.fNo})">게시판으로</button></div>
                                                
                                        <div class="col-lg-3 col-sm-4 mb-3 mb-sm-0 ">
                                            <input type="reset" class="btn btn-danger btn-user btn-block"
                                                value="내용 지우기">
                                        </div>
                                    </div>
                                </form>
                                <!-- form end -->
                                <hr>
									<form id="returnFrm" name="returnFrm" action="searchFboard2.do" method="post">
                                      <input type="hidden" id="returnNo" name="returnNo">
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