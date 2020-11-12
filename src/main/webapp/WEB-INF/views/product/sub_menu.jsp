<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="UTF-8">   

<form name="formm">
<br>
  <nav id="sub_menu">
    <ul>
      <li><input id ="rcorners1" type="text" placeholder="지역" name="area"  value="${condition.area}"></li>
      <li><input id = "rcorners1" type="date" name="startdate" required aria-required="true" data-placeholder="&nbsp;시작" value="${condition.startdate}"></li>
     <li><input id = "rcorners1" type="date" name="enddate" required aria-required="true" data-placeholder="&nbsp;종료" value="${condition.enddate}"></li>
      
      <c:choose>
      	<c:when test="${condition.adult == 0 && condition.kid == 0}">
		      <li><input id = "rcorners" type="text" name="adult" placeholder="대인" >
		     	   <input id = "rcorners" type="text" name="kid" placeholder="소인"></li>
     	  </c:when>
     	  <c:otherwise>
     	  	<li><input id = "rcorners" type="text" name="adult" placeholder="대인" value="${condition.adult}">
		     	   <input id = "rcorners" type="text" name="kid" placeholder="소인" value="${condition.kid}"></li>
     	  </c:otherwise>
     </c:choose>
     
     <c:choose>
      	<c:when test="${condition.minbudget == 0 && condition.maxbudget == 0}">	   
	      <li><input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산" >
	      		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산"></li>
      	</c:when>
      	<c:otherwise>
      		<li><input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산" value="${condition.minbudget}">
	      		<input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산" value="${condition.maxbudget}"></li>	      		
      	</c:otherwise>
      </c:choose>
      
      <c:choose>
      	<c:when test="${condition.minoption == 0 && condition.maxoption == 0}">	   
	      <li><input id = "rcorners" type="text" name="minoption" placeholder="최소 옵션">
	      	  <input id = "rcorners" type="text" name="maxoption" placeholder="최대옵션" ></li>
      	  </c:when>
      	  <c:otherwise>
      	   <li><input id = "rcorners" type="text" name="minoption" placeholder="최소 옵션" value="${condition.minoption}">
	      	  <input id = "rcorners" type="text" name="maxoption" placeholder="최대옵션" value="${condition.maxoption}"></li>
      	  </c:otherwise>
      </c:choose>
      <li><input type="button" id = "rcorners2" class="submit w-60"  onclick="addoption()"  value="특정옵션추가"/></li>
      <li style="text-align:center;"><button class="search_btn btn btn-primary text-center" type="submit" style=" font-size:10px;">검색</button></li>
    </ul>
  </nav>
 </form> 