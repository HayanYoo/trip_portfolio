<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<hr>
<div class="find">
<br><br><br>

    <form method="post" name = "formm" > 
      <div class="login">  	
      		<h4 class="text-center">비밀번호  변경</h4><br><br>
      		<div class="login"> 
      			<input type="hidden" name="user_id" value="${member.user_id}"/>			         
                <input type="password" class="form-control" placeholder="비밀번호" name="pwd"><br>   
                <input type="password" class="form-control" placeholder="비밀번호확인" name="pwdChk"><br><br>
            </div>
	        <div id="buttons" class="text-center">
	            <input type="button" value="비밀번호 변경" class="submit btn btn-danger login-btn w-50" style="margin-bottom: 10px;" onclick="change_pwd()"/><br>			            			      
	        </div>  
      </div>
    </form>  
</div>      
<br><br>
<%@ include file="../footer.jsp"%>
