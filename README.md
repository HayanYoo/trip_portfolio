<!-- TABLE OF CONTENTS -->
# Table of Contents

* [프로젝트](#프로젝트)
  * [Built With](#built-with)
* [사용법](#사용법)
  * [MakeTrip](#MakeTrip)
  * [Activity](#Activity)
  * [로그인](#로그인)
  * [마이페이지](#마이페이지)
  * [Q&A](#Q&A)
* [Roadmap](#roadmap)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
# 프로젝트

![Product Name Screen Shot](https://user-images.githubusercontent.com/73471529/100403991-9dca1080-30a3-11eb-814e-49746bf6a03b.png)
  


여행은 가고싶고 가서 구경도 하고싶지만, 내가 직접 검색하기는 귀찮을 때!

여행갈 시간과 돈은 있지만 여행 일정 짤 시간과 여력은 없을 때! 

무슨 활동을 할지 고민될 때 !

여행지, 날짜, 인원, 예산, 몇가지 활동을 하고싶은지만 입력하면 여행 일정을 대신 짜드립니다!

남들과 똑같은 관광지 훑기 여행은 그만! 랜덤 여행으로 생각지 못한 투어를 발견할수 있습니다.  

원하는 활동을 넣어서 일정을 만들 수도 있습니다.

### Built With
* [Java](https://www.oracle.com)
* [Spring](https://spring.io/)
* [Oracle](https://www.oracle.com)
* JavaScript
* [Bootstrap](https://getbootstrap.com)
* [JQuery](https://jquery.com)
* Kakao API



<!-- 사용법 EXAMPLES -->
# 사용법
![condition](https://user-images.githubusercontent.com/73471529/100405488-1088bb00-30a7-11eb-8058-a8d196dc4273.PNG)
메인 페이지에 내가 원하는 조건을 입력한 뒤 검색하면
  1) 로그인 상태가 아닐 경우 로그인 창으로 이동
  2) 로그인 상태일 시 일정을 만들어주는 페이지로 이동합니다.  
<br>
<br>

## MakeTrip
<br>
  <image width="800" src="https://user-images.githubusercontent.com/73471529/100406177-9fe29e00-30a8-11eb-9f10-271a2bc2b1e1.png"><br>
   1) 검색결과가 존재하지 않을 시 : 검색하신 조건의 결과를 찾을 수 없습니다<br><br><br>
  <image width="800" src="https://user-images.githubusercontent.com/73471529/100405887-e08de780-30a7-11eb-8161-337037224d6d.png">
  2) 검색결과가 존재할시 : 조건에 맞는 일정을 짜줍니다.
  <br><br>
  <h4>modal</h4>
    이미지를 클릭하면 상세정보를 포함하는 modal 창이 뜹니다.
   <image width="600" src="https://user-images.githubusercontent.com/73471529/100406374-ff40ae00-30a8-11eb-8b45-1929c9ea09dc.PNG">
   
   <h4>재검색</h4>
   검색 결과가 마음에 들지 않는다면, 재검색을 통해 새로운 여행일정을 짤 수 있습니다.
   <br>
   <h4>저장</h4>
   여행 일정이 마음에 든다면, 저장을 통해 저장된일정에 여행을 저장할 수 있습니다.<br><br>
   
 
## Activity
  
  
  가고싶은 특정 관광지가 있다면, 상단 우측 Activity 혹은 메인페이지의 일정짜기 버튼 위에 있는 특정옵션추가를 통해 Activity로 들어가 특정 옵션을 추가 한뒤, 일정을 만들 수 있습니다.<br>
  <div>
  <img width="500" src="https://user-images.githubusercontent.com/73471529/100407541-04ebc300-30ac-11eb-8a36-13fb3da2fb4b.png">
  <img width="400" src="https://user-images.githubusercontent.com/73471529/100407321-7a0ac880-30ab-11eb-9657-c8dc661c3ed6.png">
  </div>  
     
  * Acitivity에는 상품 리스트가 페이지당 10개씩 나열되어 있습니다. 
  * 검색을 통해 내가 원하는 상품명을 검색해 볼수 있습니다.
  * 전체보기를 통해 모든 리스트로 돌아갈 수 있습니다.
  <br><br><br>
 
 ><h3>Detail Product</h3>
  <img src="https://user-images.githubusercontent.com/73471529/100410278-96116880-30b1-11eb-9574-91bd1439af99.png">  
     
  * 상품을 클릭하면, 상품에 대한 자세한 정보를 볼수 있습니다.
  * KakaoMap API를 사용하여 위치를 조금 더 편하게 확인 할 수 있도록 하였습니다.
  * 담기를 누르게 되면 해상 상품이 내 정보에 저장되게 되고, 취소를 누르면 Activity 리스트로 돌아가게 됩니다. 
  * Paging 기능에 페이지에 대한 정보를 저장하여 들어왔던 페이지 번호로 되돌아가게 됩니다.
   <br><br><br>
   
   
   <img src="https://user-images.githubusercontent.com/73471529/100410138-17b4c680-30b1-11eb-8931-5b0e46600201.png">  
     
  * 원하는 상품을 담은 뒤 일정을 짤 수 있습니다.
  * 좌측 상단의 선택된 옵션 우측에 x표시를 누르면 옵션을 삭제할 수 있습니다. 
  * X를 누르면 옵션은 삭제되고 일정이 다시 짜여집니다.<br><br><br><br>
   
   ><h3>저장된일정</h3>
   
  
   <img src="https://user-images.githubusercontent.com/73471529/100410821-2ac89600-30b3-11eb-887e-8e81f407aae6.png">  
   
     
  * MakeTrip에서 담기를 누르게 되면 일정이 저장된 후 저장된일정으로 이동합니다. 
  * 우측상단의 Mypage를 눌러 저장된일정으로 이동 할 수도 있습니다.
  * 저장된 일정은 여행시작일이 가장 빠른 순서부터 보여지게 됩니다. 
  * 각 일정마다 상단에 번호가 매겨져 있어서 편하게 일정을 확인 할 수 있습니다.
  * 사진을 누르면 modal창을 통해 상세정보를 확인 할 수 있습니다.
  * 관광지는 한행당 세개씩 출력되며, 3개마다 다음 행으로 넘어가게 됩니다.
  * 삭제 버튼을 통해 저장된 일정을 삭제할 수 있습니다.

<br><br>
## 로그인
   <img src="https://user-images.githubusercontent.com/73471529/100423850-0c24c800-30d0-11eb-8ebc-948533d385b3.png">  
   
     
  * 로그인 및 회원가입이 가능합니다. 
  * 아이디와 비밀번호를 찾을 수 있습니다. 
  * 아이디 또는 비밀번호 오류시 비밀번호 입력란 아래에 빨간글씨로 "아이디 또는 비밀번호가 틀렸습니다" 라는 문구가 뜹니다.
     
     
<br><br>
><h3>아이디 및 비밀번호 찾기</h3>
  <img src="https://user-images.githubusercontent.com/73471529/100423769-e39cce00-30cf-11eb-90fc-2ac685f18f4d.png">  
  개인정보를 통해 아이디와 비밀번호를 찾을 수 있습니다.<br><br>
  
  <div>
  <img width="450" src="https://user-images.githubusercontent.com/73471529/100424007-4ee6a000-30d0-11eb-898b-fab53188318c.png">
  <img width="450" src="https://user-images.githubusercontent.com/73471529/100424376-d9c79a80-30d0-11eb-8775-459424fab097.png">
 </div>  
     
  * 인적사항일 일치할 경우 아이디 찾기시 내 아이디를 확인할 수 있습니다.
  * 인적사항이 일치할 경우 비밀번호 찾기시 비밀번호를 변경할 수 있습니다.<br><br><br>
  
><h3>회원가입</h3>
<img src="https://user-images.githubusercontent.com/73471529/100425164-0d56f480-30d2-11eb-9549-0a7dfb0c2fc7.png">  
   
     
  * 로그인 페이지 또는 우측 상단의 회원가입을 눌러서 진행합니다. 
  * 약관에 동의하지 않고 Next버튼을 누를 시, 알림창이 뜨며 화면이 넘어가지 않습니다.
  
  <br><br><br>
  <div>
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100425630-ea791000-30d2-11eb-9f62-2873a6e9948e.png">
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100425959-7ab75500-30d3-11eb-85b7-775f402f54ec.png">
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100425958-7a1ebe80-30d3-11eb-950a-ad85514a567e.png">
  
  </div>
   
     
  * 회원가입시 사진을 업로드 할수도 있고, 하지 않을 수도 있습니다
  * 나머지 정보를 입력하지 않을 시, 알람창이 뜨며 다음으로 넘어갈 수 없습니다.
  * 아이디 중복확인을 하지 않으면 알림창이 뜨며 다음으로 넘어갈 수 없습니다.

<br><br><br>
><h3>아이디 중복확인</h3>  
  <div>
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100427418-c1a64a00-30d5-11eb-8888-2a0c8777ba4f.png">
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100427447-cb2fb200-30d5-11eb-8c76-72e45c09ac81.png">
  <img width="32%" src="https://user-images.githubusercontent.com/73471529/100427473-d97dce00-30d5-11eb-8c59-54d361410b4c.png">
  
  </div>
     
  * 아이디 중복확인 버튼을 누를 시 중복확인 팝업창이 뜹니다.
  * 아이디가 중복되지 않으면 "사용"을 눌러서 사용할 수 있습니다.
  * 아이디가 이미 존재한다면 사용할 수 없습니다.
   
  <br><br><br>
## 마이페이지
  로그인 후, 우측 상단을 통해 들어갈 수 있습니다.
<br>
   ><h3>회원정보</h3>
 <img src="https://user-images.githubusercontent.com/73471529/100428066-c1f31500-30d6-11eb-9c1b-792908b3df85.png">  
   
  * 회원정보를 확인 할 수 있습니다.
  * 탈퇴하기를 누를 경우, 확인 알람창이 뜹니다. 확인을 누르면 탈퇴가 가능합니다.
   
<br><br><br>
  ><h3>회원정보 수정</h3>
<img src="https://user-images.githubusercontent.com/73471529/100428029-b9024380-30d6-11eb-93e8-e5e5ba712351.png">  
   
  * 회원정보를 수정 할 수 있습니다.
  * 입력란에 공백이 있을 경우, 알람창이 생성되며 수정이 불가능합니다.
  * 비밀번호 변경을 누를 경우, 비밀번호 변경창으로 이동합니다.
  
  
  <br><br><br>
## Q&A
  관리자에게 질문을 할 수 있고 답변을 받을 수 있습니다.
<br>
   ><h3>질문 목록</h3>
   <img src="https://user-images.githubusercontent.com/73471529/100429006-11861080-30d8-11eb-9d04-fe847d0417cf.png">  
   
  * 1:1 질문을 할 수 있습니다.
  * 답변이 완료된 경우 답변완료처리가 됩니다.
  <br><br>
  
   ><h3>1:1 질문하기</h3>
   <img src="https://user-images.githubusercontent.com/73471529/100429243-6590f500-30d8-11eb-8ce3-eed63edd8a13.png">  
   
  제목과 내용을 입력하여 질문을 등록할 수 있습니다.
  <br><br><br>
  
   ><h3>질문상세보기</h3>
   <div>
   <img width="45%" src="https://user-images.githubusercontent.com/73471529/100429278-6fb2f380-30d8-11eb-85ed-21c5a7a2f092.png">
   <img width="45%" src="https://user-images.githubusercontent.com/73471529/100429296-79d4f200-30d8-11eb-9fd6-dd50563f9855.png">
   </div>
   
  * 답변이 완료인 경우 질문과 답변을 함께 볼 수 있습니다.
  * 답변이 미완료인 경우 질문만 볼 수 있습니다.
  * 삭제가 가능합니다.








<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of proposed features (and known issues).



<!-- CONTACT -->
## Contact

My Email - hayanyoo.dev@gmail.com

Project Link: [https://github.com/HayanYoo/trip_portfolio](https://github.com/HayanYoo/trip_portfolio.git)


