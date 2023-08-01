# 분산 환경에서의 세션 스토어


## 분산 환경에서 Session 처리
 - Server는 세션 정보를 저장해야 함
 - Server가 여러 대라면 최초 로그인한 Server가 아닌 Server는 세션 정보를 알지 못함
 - 세션 정보를 Server간에 공유할 방법이 필요(Session Clustering)

### 1. RDB 사용
 - 읽고쓰기 편하긴 하지만
 - 세션이 관계형 데이터 모델이 필요한가?
 - 영속성이 필요한가?
 - 성능 요구사항을 충족하는가?

<br>

### 2. Redis 사용
 - 세션 데이터는 단순 key-value 구조
 - 세션 데이터는 영속성이 필요 없음
 - 세션 데이터는 변경이 빈번하고 빠른 액세스 속도가 필요
 - 서버가 날라간다 해도 유저가 로그인을 다시 하는 정도의 불편함 뿐 -> 장애에 대한 리스크가 적음!

<br>

## 세션 관리를 위한 서버의 역할
 - 세션 생성: 요쳥이 들어왔을 때 세션이 없다면 만들어서 응답에 set-cookie로 넘겨줌
 - 세션 이용: 요청이 들어왔을 때 세션이 있다면 해당 세션의 데이터를 가져옴
 - 세션 삭제: 타임아웃이나 명시적인 로그아웃 API를 통해 세션을 무효화

<br>

### SpringBoot에서의 세션 관리
 #### HttpSession
  - 세션을 손쉽게 생성하고 관리할 수 있게 해주는 인터페이스
  - UUID로 세션ID를 생성
  - JSESSOINID라는 이름의 cookie를 설정해 내려줌
  -ㅁㄴㅇ

###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |PFADD|HyperLogLog에 값들을 추가|PFADD visit Jay Peter Jane|
   |PFCOUNT|HyperLogLog에 입력된 값들의 cardinality(유일값의 수) 반환|PFCOUNT visit|
   |PFMERGE|다수의 HyperLogLog 병합|PFMERGE result visit1 visit2|
   
