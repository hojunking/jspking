<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- Custom fonts for this template from card.html-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">



</head>
<body>
       <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">My page :) </h1>
                    </div>
                    
                     <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h4 class="h3 mb-0 text-gray-800">Welcome ${id }</h4>
                    </div>                   

                    <div class="row">

                        <div class="col-lg-6">

                        <!-- Basic Card Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h6 class="m-0 font-weight-bold text-primary">자기소개</h6>
                            </div>
                            <div class="card-body">
                                내 이름은 장유정<br>
                                거꾸로 하면 정유장<br>
                                주윤언니는 장인영이라고 부르지<br>
                                정유정이라고도 부르지<br>
                                저언니는 내이름을 언제쯤 외울까 Yo~<br>
                            </div>
                        </div>

                            <!-- Basic Card Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">좋아하는 것</h6>
                                </div>
                                <div class="card-body">
                                    조원덕 교수님 ^____________^<br>
                                    커피<br>
                                    국밥<br>
                                    노래부르기<br>
                                </div>
                            </div>

                        </div>

                        <div class="col-lg-6">

                                <!-- Basic Card Example -->
                                <div class="card shadow mb-4">
                                    <div class="card-header py-3">
                                        <h6 class="m-0 font-weight-bold text-primary">싫어하는 것</h6>
                                    </div>
                                    <div class="card-body">
                                          조원덕 교수님 T^T<br>
                                       자바<br>
                                       이클립스<br>
                                         톰캣<br>
                                    </div>
                                </div>

                            <!-- Basic Card Example -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">글을 마치며....</h6>
                                </div>
                                <div class="card-body">
                                    뭐 쓰라고 해서 쓰긴 썼는데 뭘 써야 될지 1도 모르겠어서 아무말이나 써봐씀돠....<br>
                                    이렇게 쓰면 주윤언니한테 혼날거 같긴 한데...<br>
                                    혼나지뭐....<br>
                                    다슬기국밥 사줘짜나.....<br>
                                </div>
                            </div>

                        </div>

                    </div>

                </div>
                <!-- /.container-fluid -->

                
                  <div>
                        <button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button>
                  </div>  


            </div>
            <!-- End of Main Content -->

           

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->
 

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>




</body>
</html>