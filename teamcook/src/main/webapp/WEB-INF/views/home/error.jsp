<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- Custom fonts for this template from 404.html-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">


</head>
<body>

   <!-- Begin Page Content -->
      <div class="container-fluid py-5">

          <!-- 404 Error Text -->
          <div class="text-center pt-5">
            
              <br>
              <br>
              <h2 class="text-gray-800 mb-5">Something Went wrong, try again!!</h2>
              <div>${message }</div>
              <br>
              <br>
              
              <a href="loginForm.do">&larr; Back to Login page</a>
              
              <c:if test="${not empty sessionScope.id}">
               <a href="home.do">&larr; Back to Main page</a>
              </c:if>
          </div>

      </div>
      <!-- /.container-fluid -->

 <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>


</body>
</html>