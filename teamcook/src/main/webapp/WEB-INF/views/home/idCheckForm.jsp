<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
var httpRequest = null;

// httpRequest 객체 생성
	function getXMLHttpRequest(){
	    var httpRequest = null;
	
	    if(window.ActiveXObject){
	        try{
	            httpRequest = new ActiveXObject("Msxml2.XMLHTTP");    
	        } catch(e) {
	            try{
	                httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	            } catch (e2) { httpRequest = null; }
	        }
	    }
	    else if(window.XMLHttpRequest){
	        httpRequest = new window.XMLHttpRequest();
	    }
	    return httpRequest;    
	}

	function pValue(){
		document.getElementById("idInput").value=opener.document.frm.id.value;
	}
	
	function idCheck(){
		var idToCheck=document.getElementById("idInput").value;
		console.log(idToCheck);
		
		if(!idToCheck){
			alert("Need to Enter Id");
			return false;
		} else{
			var param="id="+idToCheck;
			httpRequest=getXMLHttpRequest();
			httpRequest.onreadystatechange=callback;
			httpRequest.open("POST", "MemberIdCheckAction.do", true);
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
			httpRequest.send(param);
		}
	}
	
	function callback(){
		if(httpRequest.readyState ==4){
			var resultText = httpRequest.responseText;

			if(resultText == 0){
				alter("You can't use this Id");
				document.getElementById("cancelBtn").style.visibility='visible';
				document.getElementById("useBtn").style.visibility='hidden';
				document.getElementById("msg").innerHTML="";
			}else if(resultText ==1){
				document.getElementById("cancelBtn").style.visibility='hidden';
				document.getElementById("useBtn").style.visibility='visible';
				document.getElementById("msg").innerHTML="You can use this Id";
			}
		}
	}
	//click use btn -> send id value to register form
	function sendCheckValue(){
		//pass the idcheck value so idUncheck=> change to idCheck
		opener.document.frm.idDuplication.value="idCheck";
		//pass the actual id value to register form
		opener.document.frm.id.value=document.getElementById("idInput").value;
		
		if(opener !=null){
			opener.checkFrm = null;
			self.close();
		}
	}
</script>
</head>
<body onload="pValue()" class="bg-gradient-primary">

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
                                        <input type="text" class="form-control form-control-user" id="idInput" name="idInput">
                                        <input type="button" value="idCheck" onclick="idCheck()">
                                    </div>
                                </form>
                                <!-- form end -->
                                <hr>
                               <div id="msg"></div>
                               <br>
                               <input id="cancelBtn" type="button" value="취소" onclick="window.close()"><br>
                               <input id="useIdBtn" type="button" value="use this id" onclick="sendCheckValue()">
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

</body>
</html>