<%@page import="com.kitri.member.model.MemberDetailDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String root = request.getContextPath();
MemberDetailDto memberDetailDto = (MemberDetailDto)session.getAttribute("memberDetailDto");



if(memberDetailDto!=null){
	String[] tel1 = {"010","02","031","032","041","051","061"};

%>
<!doctype html>
<html lang="ko">
	<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="<%=root%>/css/style.css" type="text/css"> <!--"../css/style.css"-->
		<script type="text/javascript">
		
		function modify(){			
//			나중에 정규표현식 적용
//			if(document.joinform.name.value ==""){ 요건 예전방법
			if(document.getElementById("name").value.trim().length== 0){ //요런게 dom scrip
				alert("이름을 입력해 주세요!");
				return;
			}else if(document.getElementById("pass").value.trim().length== 0){
				alert("비밀번호를 입력해 주세요!");
				return;			
			}else if(document.getElementById("pass").value != document.getElementById("passcheck").value){
				alert("비밀번호를 확인해 주세요");
				return;
			}else {
				alert("회원 정보가 수정되었습니다.");
				document.getElementById("modifyform").setAttribute("action", "<%=root%>/user");
				document.getElementById("modifyform").submit();				
			}
		}
		
		
		function openzip(){
			window.open("<%=root%>/user?act=mvzip","zip","top=200, left=300, width=400, height=300, menubar=no, status=no, toolbar=no, location=no, scrollbars=yes");
		}
		

		</script>
	</head>
	<body>
	<div class="testbox box1">
		<h1>회원가입</h1>
		<form name ="modifyform" id="modifyform" method="post" action="">
		<input type="hidden" name="act" value="modify">
		<hr>	
		<div class="accounttype" align="left">
		필수입력<br>
		<input type="text" name="name" id="name" value="<%=memberDetailDto.getName()%>" size="12" placeholder="Name"  required/>
		<input type="text" name="id" id="id" value="<%=memberDetailDto.getId()%>" size="12" readonly="readonly" required/>	
		<input type="password" name="pass" id="pass" size="12" maxlength="12" placeholder="Password" required/>
	    <input type="password" name="passcheck" id="passcheck" size="12" maxlength="12" placeholder="Check Password"  required/>
	    <br>	
	    <select name="tel1" id="tel1" >
	    <%
	    int len = tel1.length;
	    String read = "";
	    for(int i = 0;i<len;i++){
	    	if(memberDetailDto.getTel1().equals(tel1[i])){
	    		read = " selected=\"selected\"";
	    	}else{read="";}  
	    %>   	
	    <option value="<%=tel1[i]%>"<%=read%>><%=tel1[i]%></option>
	   <%}
	    %>				 
	    </select> -
	    <input type="text" name="tel2" id="tel2" value="<%=memberDetailDto.getTel2()%>" size="4" maxlength="4"  required/> -
	    <input type="text" name="tel3" id="tel3" value="<%=memberDetailDto.getTel3()%>" size="4" maxlength="4"  required/>
	    
	    <input type="text" name="emailid" id="emailid" value="<%=memberDetailDto.getEmailId()%>" placeholder="Email" required/> @
	    <!--<input type="text" name="direct" value="" size=12>-->
	    <select name="emaildomain" id="emaildomain">
	    <!--<option value="naver.com">직접입력</option>-->
	    <option value="naver.com">naver</option>
	    <option value="hanmail.net">hanmail</option>
	    <option value="gmail.com">gmail</option>
	    <option value="nate.com">nate</option>
	   
	    </select>
	    <hr>
	    <div class="choice">선택입력 <br>
	    <input type="text" name="zipcode" id="zipcode" value="<%=memberDetailDto.getZipCode()%>" maxlength="5" readonly="readonly">&nbsp;&nbsp;
	    <input type="button" value="우편번호검색" onclick="javascript:openzip();">   
	    <input type="text" name="address" id= "address" value="<%=memberDetailDto.getAddress()%>" placeholder="Address" readonly="readonly"/>
	    <input type="text" name="address_detail" id="address_detail" value="<%=memberDetailDto.getAddressDetail()%>" size="100" placeholder="Address2" />    
	    </div>
	    <br>
	    <input type="button" value="정보수정" class="button" onclick="javascript:modify();"/>&nbsp;&nbsp;
	    <input type="reset" value="취소" class="button"/>
	    
	<!--
				<tr>
				 <td class="td2">주민등록번호<font color="red">*</font></td>
				 <td class="td4"><input type="text" name="reginum1" value="" size="12" maxlength="6"> -
				 <input type="text" name="reginum2" value="" size="12" maxlength="7"></td>
				</tr>
	
				<tr>
				 <td class="td1">닉네임(별명)<font color="red">*</font></td>
				 <td class="td3"><input type="text" name="nickname" value="" size="12">&nbsp;&nbsp; 실명을 사용하지 않는 서비스에서 사용되는 <font color="#3cb371">별명</font>입니다.<br>입력하지 않으실 경우 회원님의 이름이 등록됩니다.</td>
				</tr>
	-->
	<!--
	            <tr>
				 <td width="120" class="td1">비밀번호 재발급<font color="red">*</font><br>질문 선택</td>
				 <td class="td3">
				  <select name="question">
				   <option value="">가장 좋아하는 색상은?(예: 빨강)</option>
				   <option value="">어릴 적 단짝 친구의 이름은?</option>
				   <option value="">가장 좋아하는 음식은?</option>
				   <option value="">가장 여행하고 싶은 나라는?</option>
				   <option value="">기억에 남는 추억의 장소는?</option>
				   <option value="">가장 좋아하는 연예인은?</option>
				  <option value="">친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
				  </select><br>
				  혹시 비밀번호를 잊어버리신 경우 여기에서 선택한 질문을 하게됩니다.
				 </td>
				</tr>
	
				<tr>
				 <td width="120" class="td2">비밀번호 재발급<font color="red">*</font><br>답변 입력</td> 
		         <td class="td4"><input type="text" name="answer" size="35"><br>
				 위에서 선택하신 질문에 대한 답변을 입력하세요.<br>
				 비밀번호를 잊어버리신 경우 이 답변을 이용하여 비밀번호를 재발급 받으실 수 있습니다.</td>
				</tr>
	-->
	<!--
				  유선전화&nbsp;<select name="tel1">
				   <option value="">----</option>
			       <option value="010">02</option>
				   <option value="010">031</option>
				   <option value="010">032</option>
				   <option value="010">033</option>
				   <option value="010">041</option>
				  </select> -
						<input type="text" name="tel2" value="" size="4" maxlength="4" > -
						<input type="text" name="tel3" value="" size="4" maxlength="4" >
						<input type="radio" name="location" value="집" checked>집
	        	        <input type="radio" name="location" value="회사">회사
						<br>휴대폰이나 유선전화 중에서 <font color="#3cb371">하나는 반드시 입력하셔야 합니다.</font>
	-->
	<!--			
				<tr>
				 <td class="td2">성별<font color="red">*</font></td> 
		         <td class="td4"><input type="radio" name="gender" value="남" checked>남자
	        	        <input type="radio" name="gender" value="여">여자</td>
				</tr>
	
				<tr>
				 <td class="td1">결혼여부<font color="red">*</font></td> 
		         <td class="td3"><input type="radio" name="married" value="미혼" checked>미혼 
					<input type="radio" name="married" value="기혼">기혼</td>
	        	   
				</tr>
	
				<tr>
				 <td class="td2">취미 & 관심사항</td>
				 <td class="td4"><input type="checkbox" name="컴퓨터">컴퓨터&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="게임">게임&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="음악">음악&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="checkbox" name="연예">연예&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="뉴스">뉴스&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">IT&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="맛집">맛집&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" name="IT">맛집
				</tr>
	-->
	    </div>
	   </form>  
	  </div>
	 </body>
</html>


<%
		}else{
			response.sendRedirect(root+"/user?act=mvlogin");
		}
%>