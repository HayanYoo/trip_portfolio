<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<%@ include file ="sub_menu.jsp" %>

<br>
<div class="product-center">
<h3>Activity</h3><br><br>
<form name="frm" method="post">
<table>
  <tr>
  <td width="700" style="text-align : right; border-right: 1px solid gray;">
     <input type="text" name="key" placeholder="검색어를 입력해주세요" size="40">
     <input class="btn" type="button" name="btn_search" value="검색" onClick="go_search()"></td>
  <td><input class="btn" type="button" name="btn_total" value="전체보기 " onClick="go_total()">
  </td>
  </tr>
</table>
<br><hr style="width:1000px;">
</form>
</div>
<%@ include file ="../footer.jsp" %>