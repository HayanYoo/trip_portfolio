<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<hr>
<div class="find">
<br><br><br>
<h4 class="text-center">아이디  찾기</h4><br>
    <form method="post" action="find_id" name = "findId"> 
      <div class="login">  			         
         <input type="text" class="form-control" placeholder="이름" name="name"/><br>   
         <input type="email" class="form-control" placeholder="이메일" name="email"/> 
         <p style="color: red;" class="text-center">${message}</p>
     
        <div id="buttons">
            <input type="button" value="아이디 찾기" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="find_id()"/><br>			            			      
        </div>        
      </div>
    </form>  
    
 <br><br>
<h4 class="text-center">비밀번호 찾기</h4><br>  
   <form method="post" action="find_pwd" name = "theForm">
      <div class="login">  
			<input type="text" class="form-control" placeholder="아이디" name="user_id"/><br>  				         
	        <input type="text" class="form-control" placeholder="이름" name="name"/><br>		             
	        <input type="email" class="form-control" placeholder="이메일" name="email"/> 
	        <p style="color: red;" class="text-center">${message}</p>		      
	       <div id="buttons">
	           <input type="button" value="비밀번호 찾기" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;" onclick="find_pwd()"/><br>      
	       </div>        
     	</div>
    </form> 
 </div>   
    
<br><br><br>
<%@ include file="../footer.jsp"%>
