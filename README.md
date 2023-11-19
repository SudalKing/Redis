# Pub/Sub
 - Redis를 미들웨어로 사용하여 서버 사이의 메세지 중계

   <br>
   
## 실행 <br>
   ### 1. Redis -> Client(Pub) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/6dd3b14b-90d2-4e83-8ec7-e7611809bd12) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/1d329300-e947-47e3-9e5a-e04b8284b86e) <br>

 
   ### 2. Client -> Redis(Sub) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/99339ffe-9ad9-42b8-8af0-8433b720b760) <br>

   <br>
   
## 결론
 - Redis를 활용하면 채팅방같은 Pub/Sub 기능을 아주 간단하게 구현 가능
