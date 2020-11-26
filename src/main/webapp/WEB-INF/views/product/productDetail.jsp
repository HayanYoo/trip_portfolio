<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="../header.jsp" %>
<hr>

<form name="frmm">
<br><br><br>

<div class="detail-center"><br><br>
			
			<input type="hidden" name="pseq" value="${product.pseq}"/>				
			<img src="product_images/${product.image}"  class='img-fluid' ><br><br>	
			<span class="parea" >${product.parea} </span><h3>[${product.name}]</h3><br><br>
			<c:choose>
				<c:when test="${product.aprice == 0 && product.kprice ==0}">
					<p><span class="detail-price" style="color : #ff4a52;">무료</span></p>
				</c:when>
				<c:otherwise>
					<p><span class="detail-price" style="color : #ff4a52;">성인 ${product.aprice}, 아동  ${product.kprice }</span></p>
				</c:otherwise>
			</c:choose>
			
			
			<br><br><br><br>
			<p>${product.des}</p><br>
				
			<p class="address">오시는 길 : ${product.address}</p>
			<p style="margin-top:-12px">
			    <em class="link">
			        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
			            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
			        </a>
			    </em>
			</p>
			<div id="map" style="width:100%;height:350px;"></div>

			<script>
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			    mapOption = {
			        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			        level: 3 // 지도의 확대 레벨
			    };  
	
				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption); 
		
				// 주소-좌표 변환 객체를 생성합니다
				var geocoder = new kakao.maps.services.Geocoder();
			
		
				// 주소로 좌표를 검색합니다
				geocoder.addressSearch('${product.address} 가로수길', function(result, status) {
		
				    // 정상적으로 검색이 완료됐으면 
				     if (status === kakao.maps.services.Status.OK) {
		
				        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
				        // 결과값으로 받은 위치를 마커로 표시합니다
				        var marker = new kakao.maps.Marker({
				            map: map,
				            position: coords
				        });
		
				        // 인포윈도우로 장소에 대한 설명을 표시합니다
				        var infowindow = new kakao.maps.InfoWindow({
				            content: '<div style="width:150px;text-align:center;padding:6px 0;">${product.name}</div>'
				        });
				        infowindow.open(map, marker);
		
				        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
				        map.setCenter(coords);
				    } 
				});    
			</script>
			<br>
			
			<input type="hidden" name ="pageNum" value="${criteria.pageNum}"/>
			<input type="hidden" name ="numPerPage" value="${criteria.numPerPage}"/>
	
			<input type="hidden" name="area" value="${condition.area}"/>
			<input type="hidden" name="startdate" value="${condition.startdate}"/>
			<input type="hidden" name="enddate" value="${condition.enddate}"/>
			<input type="hidden" name="adult" value="${condition.adult}"/>
			<input type="hidden" name="kid" value="${condition.kid}"/>
			<input type="hidden" name="minbudget" value="${condition.minbudget}"/>
			<input type="hidden" name="maxbudget" value="${condition.maxbudget}"/>
			<input type="hidden" name="minoption" value="${condition.minoption}"/>
			<input type="hidden" name="maxoption" value="${condition.maxoption}"/>
			
			<input type="submit" value="담기" class="submit btn btn-danger login-btn" style="margin-right: 5px;" onClick="insert_product()">
			<input type="button" value="취소" class="btn btn-secondary" onClick="go_list()">
					

</div>


</form>



<br><br>
<%@ include file = "../footer.jsp"%>