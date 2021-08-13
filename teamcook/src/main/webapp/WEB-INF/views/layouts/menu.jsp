<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>


</head>
<body>
        <!-- Topbar -->
    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

 
<!-- Topbar Navbar -->
<ul class="navbar-nav ml-auto">
<c:if test="${empty sessionScope.id}">
 <li class="nav-item">
         <a class="nav-link" href="loginForm.do">Login!!</a>
     </li>
</c:if>
<!-- general links -->
<!-- Log in check if logged in : show menu bar -->
<c:if test="${not empty sessionScope.id}">

	<!-- to check user authority -->
	<c:if test="${sessionScope.author eq 'USER'}">
		
	 <li class="nav-item">
         <a class="nav-link" href="home.do">Team Cook!</a>
     </li>
      <li class="nav-item">
         <a class="nav-link" href="allRecipeList.do">모든요리법</a>
     </li>
     <li class="nav-item"><a class="nav-link active" aria-current="page" href="toMyPage.do">나의 페이지</a></li>
     <li class="nav-item"><a class="nav-link" href="fboardMain.do">자유게시판</a></li>
     <li class="nav-item"><a class="nav-link" href="rboardMain.do">요청게시판</a></li>
     
       <div class="topbar-divider d-none d-sm-block"></div>

    <!-- Nav Item - User Information -->
    <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${session.id }</span>
        </a>
        <!-- Dropdown - User Information -->
        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="toMyPage.do">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
            </a>
            <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Settings
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
            </a>
        </div>
    </li>
    </c:if>
    <c:if test="${sessionScope.author eq 'ADMIN'}">
		
	 <li class="nav-item">
         <a class="nav-link" href="home.do">Team Cook!</a>
     </li>
      <li class="nav-item">
         <a class="nav-link" href="allRecipeList.do">모든요리법</a>
     </li>
     <li class="nav-item"><a class="nav-link active" aria-current="page" href="toMyPage.do">나의 페이지</a></li>
     <li class="nav-item"><a class="nav-link" href="fboardMain.do">자유게시판</a></li>
     <li class="nav-item"><a class="nav-link" href="rboardMain.do">요청게시판</a></li>
      <li class="nav-item"><a class="nav-link" href="recipeInsertForm.do">레시피 입력</a></li>
     
       <div class="topbar-divider d-none d-sm-block"></div>

    <!-- Nav Item - User Information -->
    <li class="nav-item dropdown no-arrow">
        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown"
            aria-haspopup="true" aria-expanded="false">
            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${session.id }</span>
        </a>
        <!-- Dropdown - User Information -->
        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
            <a class="dropdown-item" href="toMyPage.do">
                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                Profile
            </a>
            <a class="dropdown-item" href="#">
                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                Settings
            </a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                Logout
            </a>
        </div>
    </li>
    </c:if>
    
    
    
</c:if>
</ul>
</nav>




<!-- End of Topbar -->
        
      <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="logout.do">Logout</a>
                </div>
            </div>
        </div>
    </div>

        
        
        


</body>
</html>