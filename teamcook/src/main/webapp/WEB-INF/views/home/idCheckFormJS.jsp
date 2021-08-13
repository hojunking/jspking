<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Id check result</title>
<script>

</script>
</head>
<body  class="bg-gradient-primary">

        <div class="container">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                       <div class="col-lg-7">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4">Id check!</h1>
                                </div>
                                <!-- form start -->
                                <form class="user" id="checkFrm" name="checkFrm" action="checkId.do" method="post">
                                    <div class="form-group">
                                        <input type="text" class="form-control form-control-user" id="checkId" name="checkId" value="${checkId }">
                                        <input type="submit" value="중복체크">
                                    </div>
                                </form>
                                <!-- form end -->
                                <hr>
                               <br>
                               <input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br>
                          
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

</body>
</html>