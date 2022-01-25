# backend quickstart

Recorder-Project/backend 경로 이동 및 빌드
```
cd backend 
./gradlew clean bootJar
```

실행
```
java -jar -Dspring.profiles.active=local build/libs/*.jar
혹은 루트에서
$ ./gradlew bootRun
```
