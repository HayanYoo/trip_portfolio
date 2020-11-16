<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<hr>
<div class="find">
<br><br><br>
<h4 class="text-center">아이디  찾기 결과</h4><br>
      <div class="login">  	
      	<c:choose>	
      		<c:when test="${message == 1}">
      			<div class="text-center">         
	         	<span style="font-weight : bold;">${member.name}</span>님이 가입하신 ID는 <span style="font-weight : bold;">${member.user_id}</span>입니다.<br><br><br>
	         	</div>	    	
	        <div id="buttons" class="text-center w-200">
        		<input type="button" value="비밀번호 찾기" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onClick="location.href='find_id_pwd'"/>
            	<input type="button" value="로그인하기" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onClick="location.href='login_form'"/><br>			            			      
	        </div>  
	        </c:when>
	        
	        <c:otherwise>
	        <div class="text-center">  
	        	가입하신 ID가 존재하지 않습니다.<br><br><br> 
			</div>	    	
	        <div id="buttons" class="text-center w-200">
	      	  	<input type="button" value="다시 찾기" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onClick="location.href='find_id_pwd'"/>
	            <input type="button" value="회원가입" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onClick="location.href='contract'"/><br>			            			      
	        </div> 
	        </c:otherwise> 
        </c:choose>     
      </div>
  
</div>      
<br><br>
<%@ include file="../footer.jsp"%>
