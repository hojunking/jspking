<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
<link rel="stylesheet" href="css/menu.css">
</head>
<body>
	<div align="center">
		<div>
			<!-- 메뉴부분 -->
			<ul>
				<li><a class="active" href="home.do">Home</a></li>
				<c:if test="${empty name }">
					<li><a href="loginForm.do">Login</a></li>
				</c:if>
				<c:if test="${not empty name }">
					<li><a href="logout.do">LogOut</a></li>
					<li><a href="#contact">Contact</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="#about">Product</a></li>
					<li><a href="#about">Service</a></li>
					<c:if test="${author eq'ADMIN' }">
						<li><a class="active" href="#about">MANAGEMENT</a></li>
					</c:if>
				</c:if>
			</ul>
		</div>
	</div>
</body>
</html>