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
   
<br>

## Lists
 - Linked-list 형태의 자료구조 (조회는 느리지만 추가/삭제가 빠름)
 - Queue와 Stack으로 사용가능


### Lists 주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |LPUSH|리스트의 왼쪽(head)에 새로운 값 추가|LPUSH mylist apple|
   |RPUSH|리스트의 오른쪽(tail)에 새로운 값 추가|RPUSH mylist banana|
   |LLEN|리스트에 들어있는 아이템의 개수 반환|LLEN mylist|
   |LRANGE|리스트의 특정 범위 반환|LRANGE mylist 0-1|
   |LPOP|리스트의 왼쪽(head)에서 값을 삭제하고 반환|LPOP mylist|
   |RPOP|리스트의 오른쪽(tail)에서 값을 삭제하고 반환|RPOP mylist|

 <br>
 
## Sets
 - 순서가 없는 유니크한 값의 집합
 - 검색이 빠름
 - 개별 접근을 위한 인덱스가 존재하지 않고, 집합 연산이 가능(교, 합집합 등) Set[10, 20, A]


###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |SADD|데이터 추가|SADD myset apple|
   |SREM|데이터 삭제|SREM myset apple|
   |SCARD|아이템 개수 반환|SCARD myset|
   |SMEMBERS|저장된 아이템들 반환|SMEMBERS myset|
   |SISMEMBER|특정 값이 Set에 포함되어 있는지를 반환|SISMEMBER myset apple|

 <br>

## Hashes
 - 하나의 key 하위에 여러개의 field-value 쌍을 저장
 - 여러 필드를 가진 객체를 저장하는 것
 - HINCRBY 명령어를 사용해 카운터로 활용 가능(각각의 필드를 따로 사용할 때 효율↑)


###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |HSET|한개 또는 다수의 필드에 값을 저장|HSET user1 name bear age 10|
   |HGET|특정 필드의 값 반환|HGET user1 name|
   |HMGET|한개 이상의 필드 값을 반환|HMGET user1 name age|
   |HINCRBY|특정 필드의 값을 Integer로 취급하여 숫자를 증가|HINCRBY user1 viewcount1|
   |HDEL|한개 이상의 필드를 삭제|HDEL user1 name age|
   |HKEYS|모든 키값 조회|HKEYS user1|

<br>
   
## Sorted Sets
 - Set과 유사하게 유니크한 값의 집합
 - 각 값은 연관된 score를 가지고 정렬되어 있음
 - 정렬된 상태이기에 빠르게 최소/최대값을 구할 수 있음
 - 순위 계산, 리더보드 구현 등에 활용


###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |ZADD|한개 또는 다수의 값을 추가 또는 업데이트|ZADD myrank 10 apple 20 banana|
   |ZRANGE|특정 범위의 값을 반환(오름차순 정렬)|ZRANGE myrank 0 1|
   |ZRANK|특정 값의 위치(순위)를 반환(오름차순)|ZRANK myrank apple|
   |ZREVRANK|                    // (내림차순)|ZREVRANK myrank apple|
   |ZREM|한 개 이상의 값을 삭제|ZREM myrank apple|

<br>
   
## Bitmaps
 - 비트 벡터를 사용해 N개의 Set에 공간 효율적으로 저장(boolean 데이터 저장시 굉장히 효율적)
 - 하나의 비트맵이 가지는 공간은 약42억(2^32 - 1) 8byte
 - 비트 연산 가능


###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   |SETBIT|비트맵의 특정 오프셋의 값을 변경|SETBIT visit 10 1|
   |GETBIT|비트맵의 특정 오프셋의 값을 반환|GETBIT visit|
   |BITCOUNT|비트맵에서 set(1) 상태인 비트의 개수를 반환|BITCOUNT visit|
   |BITOP|비트맵들간의 비트 연산을 수행하고 결과를 비트맵에 저장|BITOP AND result today yesterday|

<br>
  
## 
 - 
 - 


###  주요 명령어
   |명령어|기능|예제|
   |:---:|:---:|:---:|
   ||||
   ||||
   ||||
   ||||
   ||||
   ||||
   
