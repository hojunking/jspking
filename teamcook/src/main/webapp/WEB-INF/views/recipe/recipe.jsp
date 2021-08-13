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

<script type="text/javascript">
function updateLike(){
	let id=${recipe.rpId};
	let likeBtn=document.getElementById("likeBtn");
	likeBtn.style.color="pink";
	
	document.forms['likeFrm']['id'].value = id;
	console.log(likeFrm.id)
	likeFrm.submit();
	
	
}

</script>


</head>
<body>
	<!-- Begin Page Content -->
	<div class="container-fluid">
		<!-- DataTales Example -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				
				<h3 class="m-0 font-weight-bold text-dark" style="text-align: center;" >${recipe.rpTitle } <button class="btn btn-primary" onclick="updateLike()" style="float: right;"><i id="likeBtn" class="fab fa-gratipay fa-large"></i> Like  : ${recipe.rpLikes }</button></h3>
				<form id="likeFrm" name="likeFrm" action="updateLike.do" method="post">
				<input type="hidden" id="id" name="id">
				</form>				
			
			</div>
			<div class="card-body">
				<div>
					<img src="img/${recipe.rpImg }">
				</div>
				<br>
				<p>
					<h6 class="m-0 font-weight-bold text-primary"><span>Diet: </span> ${recipe.rpDiet }</h6>
				</p>
				<br />
				<p></p>
				<div class="card shadow mb-4">
				<div class="card-header py-3">Recipe ingredients</div>
				<div class="card-body">${recipe.rpIn }</div>
				</div>
				<p></p>
				<div class="card shadow mb-4">
				<div class="card-header py-3">Recipe method</div>
				<div class="card-body">${recipe.rpMethod }</div>
				</div>
				
			</div>
			
			<div>
			<!-- To do style again -->
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='home.do'">To Main</button> &nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;<button class="btn btn-secondary" style="float: right;" onclick="location.href='allRecipeList.do'">To List</button>&nbsp;&nbsp;&nbsp;
			</div>
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