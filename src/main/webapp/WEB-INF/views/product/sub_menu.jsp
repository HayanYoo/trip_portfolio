<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>  
<meta charset="UTF-8">   

<br>
  <nav id="sub_menu">
    <ul>
      <li><input id ="rcorners1" type="text" placeholder="지역" name="area"></li>
      <li><input id = "rcorners" type="date" name="startdate" required aria-required="true" data-placeholder="  시작" >
     	  <input id = "rcorners" type="date" name="enddate" required aria-required="true" data-placeholder="  종료"></li>
      <li><input id = "rcorners" type="text" name="adult" placeholder="대인">
     	   <input id = "rcorners" type="text" name="kid" placeholder="소인"></li>
      <li><input id = "rcorners" type="text" name="minbudget" placeholder="최소 예산">
          <input id = "rcorners" type="text" name="maxbudget" placeholder="최대 예산"></li>
      <li><input id = "rcorners" type="text" name="minpotion" placeholder="최소 옵션">
      	  <input id = "rcorners" type="text" name="maxoption" placeholder="최대옵션"></li>
      <li><a id = "rcorners2" href="product_list" role="button">특정옵션추가</a></li>
      <li style="text-align:center;"><button class="search_btn btn btn-primary text-center" type="submit" style=" font-size:10px;">검색</button></li>
    </ul>
  </nav> 