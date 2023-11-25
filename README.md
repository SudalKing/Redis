# Backup
 - Redis를 활용한 백업방식

   <br>
   
## 1. RDB <br>
  
  ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/5a6066d4-3bc4-4d3c-89e9-4bd487bb9ff8) <br>
    
  - 장점: 파일 사이즈가 작음, fork를 사용해 child를 만들어 백업하므로 현재 성능에 영향x, 데이터 스냅샷 방식으로 빠른 복구 가능
  - 단점: 데이터 무결성이나 정합성에 대한 요구가 크지 않은 경우 좋음, fork를 사용하기에 시간이 걸릴 수 있고 CPU 메모리 자원을 많이 소모, 
            스냅샷을 저장하는 시점(저장주기) 사이의 데이터 변경사항이 유실될 수 있음

   <br>
   
   ### 1-1 Docker를 사용한 Redis 설정 파일 적용 <br>
   ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/18acf3a6-592a-40fc-96af-f9252ec5e42c) <br>

## 2. AOF <br>

 ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/4b4bd01d-5372-408f-95ba-519ef1f7a927) <br>

 - 장점: 모든 변경이 기록되어 안정적, 백업 파일이 손상될 위험이 적음, 수행된 명령어가 저장되어 사람이 보고 이해할 수 있고 수정도 가능
 - 단점: RDB 대비 파일이 커짐, 백업&복구 속도가 느림 

<br>

### 2-1 AOF 설정 <br>
![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/5edd5206-1014-4f1b-9fce-13c981af8a85) <br>

### 2-2 fsync 정책
![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/2647b13a-327e-4a84-89b7-86493702ebea) <br>


## 3. Redis replication <br>

 ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/73c921bc-fb44-4a79-af52-f400ab6ad680) <br>

 ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/f6fa033f-545b-44df-8ccc-3afa526de949) <br>



## 번외. Docker-Compose <br>

 ![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/879be561-94b6-49f8-9bad-b73083831107) <br>

   
## 결론
 - Redis를 활용하면 채팅방같은 Pub/Sub 기능을 아주 간단하게 구현 가능
