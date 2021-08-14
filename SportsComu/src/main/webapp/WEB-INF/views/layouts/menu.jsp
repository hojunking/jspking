<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Wrapper -->
<div id="wrapper">

	<!-- Sidebar -->
	<ul
		class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
		id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a class="sidebar-brand d-flex align-items-center justify-content-center"
		   href="home.do">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-running"></i>
			</div>
			<div class="sidebar-brand-text mx-3">Sports Community</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item active"><a class="nav-link" href="home.do">
				<i class="fas fa-fw fa-user-alt"></i> <span>My Page</span>
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">목차</div>

		<!-- 공지사항이 body에 뜨게 하기 -->
		<li class="nav-item"><a class="nav-link collapsed" href="boardList.do"> 
			<i class="fas fa-fw fa-table"></i> <span>공지사항</span></a>
		</li>

		<!-- 게시판이 body에 뜨게 하기 -->
			<li class="nav-item"><a class="nav-link collapsed" href="snsList.do"> 
				<i class="fas fa-fw fa-table"></i> <span>게시판</span></a>
			</li>
			
		<!-- 단체관람게시판 body에 뜨게 하기 -->
		<li class="nav-item">
			<a class="nav-link" href="eventList.do">
				<i class="fas fa-fw fa-table"></i> 
				<span>단체관람</span>
			</a>
		</li>

		<!-- Divider -->
		<hr class="sidebar-divider">
		
		<!-- Nav Item - Charts -->
		<c:if test="${session.author eq 'ADMIN' }">
			<!-- Heading -->
			<div class="sidebar-heading">개인정보</div>
		
			<li class="nav-item"><a class="nav-link" href="memberList.do">
				<i class="fas fa-fw fa-book-open"></i> <span>회원정보</span>
			</a></li>
		</c:if>		

		
		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
	<!-- End of Sidebar -->
</div>