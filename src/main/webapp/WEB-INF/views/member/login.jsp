<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<br><br>
<h1 class="text-center">Login</h1><br><br>
    <form method="post" action="login" name = "formm">
    
      <div class="login">  			         
		                <input type="text" class="form-control" placeholder="아이디" name="user_id"><br>   
		                <input type="password" class="form-control" placeholder="비밀번호" name="pwd"> 
		                <p style="color: red;" class="text-center">${message}</p>
		      
			        <div id="buttons">
			            <input type="submit" value="로그인" class="submit btn btn-danger login-btn" style="margin-bottom: 10px;"><br>
			            <a href="#" style="margin: 10px 35px;">회원가입</a>
			            <a href="#">아이디/비밀번호 찾기</a>			      
			        </div>        
        </div>
    </form>  
<br><br>
<%@ include file="../footer.jsp"%>
