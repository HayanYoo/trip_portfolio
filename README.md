<!-- TABLE OF CONTENTS -->
# Table of Contents

* [프로젝트](#프로젝트)
  * [Built With](#built-with)
* [사용법](#사용법)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
# 프로젝트

![Product Name Screen Shot](https://user-images.githubusercontent.com/73471529/100403991-9dca1080-30a3-11eb-814e-49746bf6a03b.png)
  
<br>
여행은 가고싶고 가서 구경도 하고싶지만, 내가 직접 검색하기는 귀찮을 때!
여행갈 시간과 돈은 있지만 여행 일정 짤 시간과 여력은 없을 때! 
여행지, 날짜, 인원, 예산, 몇가지 활동을 하고싶은지만 입력하면 여행 일정을 대신 짜드립니다!  
  
<br><br>  
* 남들과 똑같은 관광지 훑기 여행은 그만! 랜덤 여행으로 생각지 못한 투어를 발견할수 있습니다.  
* 무슨 활동을 할지 고민될 때  
* 다 귀찮아! 남는건 돈이니 일정이나 대신 짜줘  

물론, 원하는 활동을 넣어서 일정을 만들 수도 있습니다.

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

<h2> MakeTrip </h2>
<br>
  <image width="800" src="https://user-images.githubusercontent.com/73471529/100406177-9fe29e00-30a8-11eb-9f10-271a2bc2b1e1.png"><br>
   1) 검색결과가 존재하지 않을 시 : 검색하신 조건의 결과를 찾을 수 없습니다<br><br><br>
  <image width="800" src="https://user-images.githubusercontent.com/73471529/100405887-e08de780-30a7-11eb-8161-337037224d6d.png">
  2) 검색결과가 존재할시 : 조건에 맞는 일정을 짜줍니다.
  <br><br>
  <h4>modal</h4>
  일정에 대한 자세한 정보가 궁금하다면, 이미지를 클릭하면 정보를 포함하는 modal 창이 뜹니다.
   <image width="600" src="https://user-images.githubusercontent.com/73471529/100406374-ff40ae00-30a8-11eb-8b45-1929c9ea09dc.PNG">
   
   <h4>재검색</h4>
   검색 결과가 마음에 들지 않는다면, 재검색을 통해 새로운 여행일정을 짤 수 있습니다.
   <br><br>
   <h4>저장</h4>
   여행 일정이 마음에 든다면, 저장을 통해 저장된일정에 여행을 저장할 수 있습니다.<br>
   
   
  ><h3>Activity</h3>
  
  
  가고싶은 특정 관광지가 있다면, 상단 우측 Activity 혹은 메인페이지의 일정짜기 버튼 위에 있는 특정옵션추가를 통해 Activity로 들어가 특정 옵션을 추가 한뒤, 일정을 만들 수 있습니다.<br>
  <div>
  <img width="400" src="https://user-images.githubusercontent.com/73471529/100407541-04ebc300-30ac-11eb-8a36-13fb3da2fb4b.png">
  <img width="400" src="https://user-images.githubusercontent.com/73471529/100407321-7a0ac880-30ab-11eb-9657-c8dc661c3ed6.png">
  </div><br>
  Acitivity에는 상품 리스트가 페이지당 10개씩 나열되어 있습니다. 검색을 통해 내가 원하는 상품명을 검색해 볼수도 있으며, 전체보기를 통해 모든 리스트로 돌아갈 수 있습니다.
  <br><br><br>
 
  <img src="https://user-images.githubusercontent.com/73471529/100410278-96116880-30b1-11eb-9574-91bd1439af99.png"><br>
   상품을 클릭하면, 상품에 대한 자세한 정보를 볼수 있습니다.
   KakaoMap API를 사용하여 위치를 조금 더 편하게 확인 할 수 있도록 하였습니다.
  담기를 누르게 되면 해상 상품이 내 정보에 저장되게 되고, 취소를 누르면 Activity 리스트로 돌아가게 됩니다. 
  또한 Paging 기능에 페이지에 대한 정보를 저장하여 들어왔던 페이지 번호로 되돌아가게 됩니다.
   <br><br><br>
   
   
   <img src="https://user-images.githubusercontent.com/73471529/100410138-17b4c680-30b1-11eb-8931-5b0e46600201.png">
   원하는 상품을 담은 뒤 일정을 짤 수 있습니다.
   좌측 상단의 선택된 옵션 우측에 x표시를 누르면 옵션을 삭제할 수 있습니다. X를 누르면 옵션은 삭제되고 일정이 다시 짜여집니다.<br><br>
   
   ><h3>저장된일정</h3>
   
   <br>
   <img src="https://user-images.githubusercontent.com/73471529/100410821-2ac89600-30b3-11eb-887e-8e81f407aae6.png">  
   
     
  * MakeTrip에서 담기를 누르게 되면 일정이 저장된 후 저장된일정으로 이동합니다. 
  * 우측상단의 Mypage를 눌러 저장된일정으로 이동 할 수도 있습니다.
  * 저장된 일정은 여행시작일이 가장 빠른 순서부터 보여지게 됩니다. 
  * 각 일정마다 상단에 번호가 매겨져 있어서 편하게 일정을 확인 할 수 있습니다.
  * 사진을 누르면 modal창을 통해 상세정보를 확인 할 수 있습니다.
  * 관광지는 한행당 세개씩 출력되며, 3개마다 다음 행으로 넘어가게 됩니다.


<h2>로그인</h2>
   
  
  

  
  



<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



<!-- CONTACT -->
## Contact

My Email - hayanyoo.dev@gmail.com

Project Link: [https://github.com/HayanYoo/trip_portfolio](https://github.com/HayanYoo/trip_portfolio.git)


