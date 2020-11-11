<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
	
<link rel="stylesheet" href="css/main2.css">
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript" src="js/member.js"></script>

<style type="text/css">
body{   
 background-color : #dc3545;
  font-family: Verdana;
}
#wrap{     
  margin: 0 20px;
}
h1 {
  font-size: 22px;
  color: #ffffff;
  font-weight: normal;
}
input[type=button], input[type=submit] {
  float: right;
}
</style>
<script type="text/javascript">
function idok(){
  opener.formm.user_id.value="${user_id}"; 
  opener.formm.reid.value="${user_id}";
  self.close();
}
</script>
</head>
<body>
<br><br>
<div id="wrap">
  <h1 style="margin-bottom:20px;">ID 중복확인</h1>
  <form method=post name=formm style="margin-right:0 "
  		action="id_check_form" >
    User ID <input type=text name="user_id" value="${user_id}" size="15"> 
            <input type=submit value="검색" class="submit" ><br>     
    <div style="margin-top: 20px">   
      <c:if test="${message == 1}">
        <script type="text/javascript">
          opener.document.formm.user_id.value="";
        </script>
        ${user_id}는 이미 사용중인 아이디입니다.
      </c:if>
      <c:if test="${message==-1}">
        ${user_id}는 사용 가능한 ID입니다.
        <input type="button" value="사용" class="cancel" onclick="idok()">
      </c:if>
    </div>
  </form>
</div>  
</body>
</html>