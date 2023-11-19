# 캐싱(Sorted-Set)
 - Redis의 Sorted-Set 성능 테스트

<br>

## 테스트
 ### 100만개의 무작위 숫자 삽입 후 Collections.sort() 이용 <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/78902386-4b2e-45ca-90b8-5011cfb1f19f) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/dc096736-2948-49fa-aa2e-63d89381c7b1)

   <br>
   
### Redis <br>
   #### 1. 캐시데이터 삽입 <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/8f0e8e4c-4a26-4c78-b6f6-eceaf7c0ffbf) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/e652b56c-9de4-48d4-8550-af6b186b9480) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/77283793-8f22-4752-b1df-2aaf4743c642) <br>
   
   #### 2. 성능 비교 <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/ca66de85-ecaa-454b-93fe-e3e55e5f6d91) <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/788774b7-4019-4340-92c3-57a69b64ad20) <br>


   <br>
   
## 결론
 - 
