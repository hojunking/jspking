<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

   <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">


 
<script>
function getRecipe(id){
	getRp.rpid.value=id;
	getRp.submit();
}


</script>

</head>
<body>
<section>
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<!-- 추천메뉴레시피 카드로 보여주기!! -->	
			<!-- 아직 추천메뉴 보여주는거 아님.일단 전체 디비목록 출력. -->
			<c:forEach var="recipe" items="${recipes}">
	            <div class="col mb-5">
	                <div class="card h-100">
	                    <!-- recommend badge-->
	                    <div class="badge bg-danger text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Recommend
	                    </div>
	                    <!-- recipe image-->
	                    <img class="card-img-top" src="img/${recipe.rpImg }" alt="burger" />
	                    <!-- recipe details-->
	                    <div class="card-body p-4">
	                        <div class="text-center">
	                            <!-- recipe name-->
	                            <h5 class="fw-bolder">${recipe.rpTitle}</h5>
	                            <!-- recipe reviews-->
	                            <div class="d-flex justify-content-center small text-warning mb-2">
	                                <div class="bi-star-fill"></div>
	                                <div class="bi-star-fill"></div>
	                                <div class="bi-star-fill"></div>
	                                <div class="bi-star-fill"></div>
	                                <div class="bi-star-fill"></div>
	                            </div>
	                            <!-- recipe diet-->
	                            ${recipe.rpDiet }
	                        </div>
	                    </div>
	                    <!-- Product actions-->
	                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
	                        <div class="text-center"><button type="button" class="btn btn-outline-dark mt-auto" onclick="getRecipe(${recipe.rpId})">Read more</button></div>
	                    </div>
	                    <form id="getRp" name="getRp" action="recipeSelect.do" method="post">
	                    	<input type="hidden" id="rpid" name="rpid">
	                    </form>
	                </div>
	            </div>
			</c:forEach>
        </div>
    </div>
</section>


    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

 
</body>
</html>