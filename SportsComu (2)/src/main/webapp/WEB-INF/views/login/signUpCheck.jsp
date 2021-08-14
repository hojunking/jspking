<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="co.yedam.sportscomu.member.vo.MemberBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkok(){
		opener.parent.location="loginForm.lo";
		window.close();
	}
</script>
</head>
<body>
	
	<% 
	// 한글 깨짐을 방지하기 위한 인코딩 처리
    request.setCharacterEncoding("utf-8"); 
	%>
	<%-- 자바빈 관련 액션태그 사용 --%>
	<jsp:useBean id="member" class="co.yedam.sportscomu.member.vo.MemberBean"/>
	<jsp:setProperty property="*" name="member"/>
	
	<div id="wrap">
        <br><br>
        <b><font size="5" color="gray">회원가입 정보를 확인하세요.</font></b>
        <br><br>
        <font color="blue"><%=member.getName() %></font>님 가입을 축하드립니다.
        <br><br>
        
        <table>
            <tr>
                <td id="title">아이디</td>
                <td><%=member.getId() %></td>
            </tr>
                        
            <tr>
                <td id="title">비밀번호</td>
                <td><%=member.getPassword() %></td>
            </tr>
                    
            <tr>
                <td id="title">이름</td>
                <td><%=member.getName() %></td>
            </tr>
                   
            <tr>
                <td id="title">나이</td>
                <td><%=member.getAge() %></td>
            </tr>
             
            <tr>
                <td id="title">성별</td>
                <td><%=member.getGender() %></td>
            </tr>
        </table>
        
        <br>
        <input type="button" value="확인" onclick="checkok()">
    </div>
</body>
</html>