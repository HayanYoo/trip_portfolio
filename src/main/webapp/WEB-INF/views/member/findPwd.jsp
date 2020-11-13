<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<hr>
<div class="find">
<br><br><br>
<h4 class="text-center">비밀번호  찾기 결과</h4><br>
    <form method="post" name = "formm" > 
      <div class="login">  	
      	<c:choose>		
      		<c:when test="${message == 1}">	
      		<div class="login">
      			<p>비밀번호 변경</p>  
      			<input type="hidden" name="user_id" value="${member.user_id}"/>			         
                <input type="password" class="form-control" placeholder="비밀번호" name="pwd"><br>   
                <input type="password" class="form-control" placeholder="비밀번호확인" name="pwdChk"><br><br>
            </div>
	        <div id="buttons" class="text-center">
	            <input type="button" value="비밀번호 변경" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onclick="change_pwd()"/><br>			            			      
	        </div>  
	        </c:when>
	        
	        <c:otherwise>
	        <div class="text-center">  
	        	입력하신 정보는 존재하지 않습니다.<br><br><br> 
			</div>	    	
	        <div id="buttons" class="text-center">
	            <a href="find_id_pwd"><input type="button" value="다시 찾기" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;"/></a><br>			            			      
	        </div> 
	        </c:otherwise> 
        </c:choose>     
      </div>
    </form>  
</div>      
<br><br>
<%@ include file="../footer.jsp"%>
