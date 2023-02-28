##  해당 과제에서 알게된 점을 적어 둔 MD 입니다.

1. 아래 코드를 왜 user table을 생성할때 써주지 않았을까?
```java
ALTER TABLE `user` ADD roleId int;
ALTER TABLE `user` ADD FOREIGN KEY (`roleId`) REFERENCES `role` (`id`);
```

+ 아직 role table을 생성하지 않았는데, FK로 설정할 수는 없다. 그래서 나중에 추가해주는 것

2. 가능하면 String 속에 있는 쿼리문에 ";" 를 붙여주자. Mysql에서도 ";" 를 사용하기 때문에 
코드를 copy & paste 하기 편하다.

3. ``를(Tab 위의 글자) 사용하면 SQL에서 사용하는 예약어도 변수로 사용할 수 있다. 하지만 왠만하면 예약어는 안쓰는게 좋다.

4. 쿼리문은 대문자로 작성해주고, 변수명은 소문자로 쓰려고 노력하자.
   + sql이 딱히 대소문자 구별을 하지는 않지만, 개발자들이 잘 볼수있도록 하는 관례이다.

5. 문자열 더하기로 더할때 쿼리문 사이사이 " "이 잘 들어가도록 작성해주자.
   + 그렇지 않으면 SQL syntaxError를 만난다.

6. inner Join으로 완벽하게 매칭되는 부분만 가져올 것인지, 
Left(Right) Outer Join 으로 일부분에 Null 값이 들어가더라도 결합할 것인지 고려한다.
   + 성능적으로는 inner join이 더 좋으니, 둘다 가능한 경우에는 inner join을 사용하자.

7. 서브쿼리는 JOIN보다 훨씬 비용이 높다. 정말 필요한 경우가 아니라면, 사용하지 말자.