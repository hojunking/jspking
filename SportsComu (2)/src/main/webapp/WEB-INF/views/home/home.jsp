<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
/* Make the image fully responsive */
.carousel-inner img {
    width: 100%;
    height: 100%;
}
</style>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">SPORT COMMUNITY</h1>
	<br>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="2000">
			<!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
                <li data-target="#myCarousel" data-slide-to="4"></li>
                <li data-target="#myCarousel" data-slide-to="5"></li>
            </ul>
            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/sc.jpg" alt="soccer" width="1000" height="500">
                </div>
                <div class="carousel-item">
                    <img src="img/ba.jpg" alt="basketball" width="1000" height="400">
                </div>
                <div class="carousel-item">
                    <img src="img/bs.jpg" alt="baseball" width="1000" height="400">
                </div>
                <div class="carousel-item">
                    <img src="img/vb.jpg" alt="volleyball" width="1000" height="400">
                </div>
                <div class="carousel-item">
                    <img src="img/ryu.jpg" alt="volleyball" width="1000" height="400">
                </div>
                <div class="carousel-item">
                    <img src="img/sk.jpg" alt="volleyball" width="1000" height="400">
                </div>
            </div>
            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#myCarousel" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#myCarousel" data-slide="next"> 
                <span class="carousel-control-next-icon"></span>
            </a>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>