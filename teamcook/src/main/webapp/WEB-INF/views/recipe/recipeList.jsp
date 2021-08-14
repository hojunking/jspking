<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <!-- Custom fonts for this template from table.html -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">


<script type="text/javascript">
	function getRecipe(n) {
		frm.rpId.value = n;
		frm.submit();
	}
</script>

</head>
<body>
  <!-- Begin Page Content -->
		        <div class="container-fluid">
		            <!-- Page Heading -->
		            <h1 class="h3 mb-2 text-gray-800">All Recipes</h1>
		          
		            <!--table with all recipe-->
		            <div class="card shadow mb-4">
		                <div class="card-header py-3">
		                    <h6 class="m-0 font-weight-bold text-primary">All Recipe</h6>
		                </div>
		                <div class="card-body">
		                    <div class="table-responsive">
		                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
		                            <thead>
		                                <tr>
		                                    <th>No.</th>
		                                    <th>Title</th>
		                                    <th>Diet</th>
		                                    <th>Likes</th>
		                                    <th>Date</th>
		                                    <th>Recommended?</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                            <c:forEach var="recipe" items="${list }">
		                                <tr onmouseover="this.style.background='#ebebeb'; this.style.cursor='pointer'" onmouseout="this.style.background='white'" onclick="getRecipe(${recipe.rpId})">
		                                    <td>${recipe.rpId }</td>
		                                    <td>${recipe.rpTitle }</td>
		                                    <td>${recipe.rpDiet }</td>
		                                    <td>${recipe.rpLikes }</td>
		                                    <td>${recipe.rpDate }</td>
		                                    <td>${recipe.rpRecommend }</td>
		                                </tr>
		                            </c:forEach>
		                            </tbody>
				                        </table>
				                        <form id="frm" name="frm" action="searchRp.do" method="post">
								<input type="hidden" id="rpId" name="rpId">
							</form>
						 </div>
				       </div>
		                
		                <!-- return to menu btn...  and to the list btn -->
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

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>
</html>