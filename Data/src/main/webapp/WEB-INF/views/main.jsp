<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<link href="../bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container box">
	<div align="center">
		<h1>일단 메인페이지 완성</h1>
		<div>
		<form id="frm" method="post" action="InsertServlet">
			이메일<input type="text"id="id" name="id" ><br>
			 이름<input type="text"id="name" name="name"><br>
			 전화번호<input type="text" id="phone"name="phone" ><br>
			 주소<input type="text"id="address" name="address" ><br>
			 생년월일<input type="date"id="birth" name="birth" ><br>
				<button type="submit" id="insert" class="btn btn-warning">등록</button>
				</form>
				</div><div>
				<button id="select" class="btn btn-warning">조회</button>
				<button id="update" class="btn btn-warning">수정</button>
			</div>
			<br>
			<table border="1">
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>연락처</th>
					<th>생년월일</th>
					<th>주소</th>
				</tr>
				<c:forEach var="list" items="${list }">
					<tr onclick="showDetail()">
						<th>${list.id }</th>
						<th>${list.name }</th>
						<th>${list.phone }</th>
						<th>${list.birth }</th>
						<th>${list.address }</th>
					</tr>
				</c:forEach>
				

			</table>
		</div>
	</div>
</body>
	<script>
	$('#frm').on('submit', function (event) {
		event.preventDefault();
		
		console.log($('#frm').attr('action'))
		let s = $('#frm').serialize();

		//폼 전송처리
		$.ajax({
			url: $('#frm').attr('action'),
			method: 'post',
			data: $('#frm').serialize(), //파라미터로 넘김
			dataType: 'json', //받아오는 값
			success: insert,
			error: function (reject) {
				console.error(reject);
			}
		})
	});
	
	function showDetail(){
	    let inputs = document.getElementsByTagName('input');
	    console.log(inputs);
	    for(let i =0; i < inputs.length; i++){
	        inputs[i].value= this.childNodes[i].childNodes[0].nodeValue;
	    }

	}


	</script>
</html>