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

