<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">   

<form name="formm">
<br>
  <nav id="sub_menu">
    <ul>
      <li><input id ="rcorners1" type="text" placeholder="지역" name="area"  value="${sessionScope.condition.area}"></li>
      <li><input id = "rcorners1" type="date" name="startdate" required aria-required="true" data-placeholder="&nbsp;시작" value="${sessionScope.condition.startdate}"></li>
     <li><input id = "rcorners1" type="date" name="enddate" required aria-required="true" data-placeholder="&nbsp;종료" value="${sessionScope.condition.enddate}"></li>
      
      <c:choose>
      	<c:when test="${sessionScope.condition.adult == 0 && sessionScope.condition.kid == 0}">
		      <li><input id = "rcorners" type="text" name="adult" placeholder="대인" >
		     	   <input id = "rcorners" type="text" name="kid" placeholder="소인"></li>
     	  </c:when>
     	  <c:otherwise>
     	  	<li><input id = "rcorners" type="text" name="adult" placeholder="대인" value="${sessionScope.condition.adult}">
		     	   <input id = "rcorners" type="text" name="kid" placeholder="소인" value="${sessionScope.condition.kid}"></li>
     	  </c:otherwise>
     </c:choose>
     
     <c:choose>
      	<c:when test="${sessionScope.condition.minbudget == 0 && sessionScope.condition.maxbudget == 0}">	   
	      <li><input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산" >
	      		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산"></li>
      	</c:when>
      	<c:otherwise>
      		<li><input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산" value="${sessionScope.condition.minbudget}">
	      		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산" value="${sessionScope.condition.maxbudget}"></li>	      		
      	</c:otherwise>
      </c:choose>
      
      <c:choose>
      	<c:when test="${sessionScope.condition.minoption == 0 && sessionScope.condition.maxoption == 0}">	   
	      <li><input id = "rcorners" type="text" name="minoption" placeholder="최소 옵션">
	      	  <input id = "rcorners" type="text" name="maxoption" placeholder="최대옵션" ></li>
      	  </c:when>
      	  <c:otherwise>
      	   <li><input id = "rcorners" type="text" name="minoption" placeholder="최소 옵션" value="${sessionScope.condition.minoption}">
	      	  <input id = "rcorners" type="text" name="maxoption" placeholder="최대옵션" value="${sessionScope.condition.maxoption}"></li>
      	  </c:otherwise>
      </c:choose>
      <div style="font-size:10px; margin-top:3px;">
	      <c:forEach items="${selectedProduct}" var="selected">
	      	<li style="width:200px;">${selected.name} 
		      	<button type="button" class="btn size" style="padding:0; border:0;"> 
		      	<span class="badge badge-danger size">x</span>
				</button>
			</li>
	      </c:forEach>
      </div>
     
      <li style="margin-left:40px;"><button class="search_btn btn btn-primary text-center" type="submit" style=" font-size:10px;">일정짜기</button></li>
    </ul>
  </nav>
 </form> 