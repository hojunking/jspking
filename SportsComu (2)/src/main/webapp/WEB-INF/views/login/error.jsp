<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkok() {
		window.close();
	}
</script>
</head>
<body>
	<div align="center">
		<h3>${message }</h3>
		<div>
			<input type="button" value="확인" onclick="checkok()">
		</div>
	</div>
</body>
</html>