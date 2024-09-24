# issue #8 데이터베이스 접근 로직 테스트


1. database 선택 : [ranking](https://db-engines.com/en/ranking) 참조
2. mysql로 선택 후 설치
3. 인텔리제이에 database 연결, user 설정(****은 비밀번호)

- console에 입력한 명령어 내역
```mysql
show databases;

create database board;

show databases;

create user 'zena'@'localhost' identified by '****';
select `user` from `mysql`.`user`;

show grants for 'zena'@'localhost';
grant all on `board`.* to 'zena'@'localhost' with grant option;

show grants for 'zena'@'localhost';
flush privileges ;
```

4. build.gradle에 dependency 추가 ([Spring initializer](https://start.spring.io/)에서 필요한 dependencies 추가 후 EXPLORE 참조 )
   - Spring Data JPA
   - MySQL Driver
   - H2 Database

5. src/main/resources/application.properties -> application.yaml으로 변경, 작성
6. data.sql에 sql 쿼리를 작성하여 데이터 입력, 수정, 삭제 가능
7. test>java>...BoardProjectApplicationTests.java 실행하여 잘 되는지 확인
   - 안된다면
   1. application.yaml에서 username과 password가 맞는지 확인
   2. com.mysql.cj.jdbc.Driver 에러 -> dependency 오타 확인

8. article, articleComment 완성
9. article, articleComment의 repository (interface)작성
10. test에서 repository test해보기
   - [대량의 데이터 생성해주는(mock data) 웹페이지](https://mockaroo.com/)에서 테스트데이터 다운받기
   - database에 CRUD 잘 되는지 확인

* jdk 버전의 차이때문인지 `@jakarta.persistence.Id`를 넣어야 `@Id` 역할을 함
* application.yaml에서  `test.database.replace: none`는 testdb만 다른 걸 쓰고 싶을 때 넣음
  * ...test.java에서 @AutoConfigureTestDatabase 애노테이션을 넣는 것과 같은 효과
  