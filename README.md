# WSL2 환경 Redis 설치

```
~$ brew install redis
```


# Docker redis 설치

```
~$ docker pull redis
~$ docker version
~$ docker run --name [실행 이미지 이름] -d(demon으로 실행) -p(port번호 설정) 6379:6379 redis
~$ docker ps
~$ docker stop [이미지 이름]
~$ docker start [이미지 이름]
~$ docker rm [이미지 이름] (이미지 삭제)
~$ docker exec -it my-redis /bin/sh (쉘에서 docker 실행-> 컨테이너 진입)
# redis-cli (redis client 실행)

```

![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/f7a97cd8-27a5-4303-9adc-5a218ee1a098)
<br><br>
# 간단 예제
![image](https://github.com/SudalKing/Spring_Redis/assets/87001865/1d15c4c9-1e60-4a4a-a473-7d4c46324ab4)

# Redis의 자료형
 asdassda

## Strings
 - 가장 기본적인 데이터 타입
 - 바이트 배열 저장(binary-safe)
 - 바이너리로 변환할 수 있는 모든 데이터 저장 가능(JPG와 같은 파일등)
 - 최대 크기는 512MB

### Strings 주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |SET|특정 키에 문자열 값 저장|SET say hello|
   |GET|특정 키의 문자열 값을 받아옴|GET say|
   |INCR|특정 키의 값을 Integer로 취급해 1증가|INCR mycount|
   |DECR| // 1 감소|DECR mycount|
   |MSET|여러 키에 대한 값을 한번에 저장|MSET mine milk yours coffee|
   |MGET|여러 키에 대한 값을 한번에 받아옴|MGET mine yours|
   

## 


