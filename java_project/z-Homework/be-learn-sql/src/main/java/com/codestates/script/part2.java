package com.codestates.script;

// 명령 문사이 " " 공백 꼭 넣어주기.
public class part2 {
  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-1. user 테이블에 존재하는 모든 컬럼을 포함한 모든 데이터를 확인하기 위한 SQL을 작성해주세요.
  */
  public static final String PART2_1 = "SELECT * FROM USER";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-2. user 테이블에 존재하는 모든 데이터에서 name 컬럼만을 확인하기 위한 SQL을 작성해주세요.
  */
  public static final String PART2_2 = "SELECT NAME FROM USER";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-3. user 테이블에 데이터를 추가하기 위한 SQL을 작성해주세요.
          - 원하는 name, email을 사용하시면 됩니다.
  */
  public static final String PART2_3 = "INSERT INTO USER VALUES(100,'KYKKKK','awakekyu1@gmail.com',100)";
// "INSERT INTO USER (name, email) VALUES('KYKKKK','awakekyu1@gmail.com')";
// 특정 컬럼만 추가 가능

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-4. user 테이블에서 특정 조건을 가진 데이터를 찾기위한 SQL을 작성해주세요.
          - 조건 : name이 luckykim이여야 합니다.
  */
  public static final String PART2_4 = "SELECT * FROM USER " + "WHERE NAME = 'luckykim'";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-5. user 테이블에서 특정 조건을 가진 데이터를 찾기위한 SQL을 작성해주세요.
          - 조건 : name이 luckykim이 아니여야 합니다.
  */
  public static final String PART2_5 = "SELECT * FROM USER " + "WHERE NOT NAME = 'luckykim'";
// "SELECT * FROM USER " + "WHERE NAME <> 'luckykim'"
  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-6. content 테이블에 존재하는 모든 데이터에서 title 컬럼만을 찾기 위한 SQL을 작성해주세요.
  */

  public static final String PART2_6 = "SELECT TITLE FROM CONTENT";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-7. content의 title과 그 컨텐츠를 작성한 user의 name을 찾기 위한 SQL을 작성해주세요.
          - 저자가 없더라도, 켄턴츠의 title을 모두 찾아야합니다.
  */
  public static final String PART2_7 = "SELECT content.TITLE, user.name " +
          "FROM CONTENT " +
          "left JOIN user " +
          "ON CONTENT.userId = user.id";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-8. content의 title과 그 컨텐츠를 작성한 user의 name을 찾기 위한 SQL을 작성해주세요.
          - 저자가 있는 컨텐츠의 title만 찾아야합니다.
  */
  public static final String PART2_8 = "SELECT C.title, U.name " +
          "FROM CONTENT AS C " +
          "inner JOIN USER AS U " +
          "ON C.userId = U.id";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-9. content의 데이터를 수정하기 위한 SQL을 작성해주세요.
          - title이 database homework인 content 데이터에서 body를 database is very easy로 수정해야합니다.
  */
  public static final String PART2_9 = "UPDATE CONTENT " +
          "SET body='database is very easy' " +
          "WHERE TITLE='database homework'";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 2-10. content의 데이터를 추가하기 위한 SQL을 작성해주세요.
          - luckykim이 작성한 컨텐츠를 추가해주세요. 제목과 본문은 자유입니다. (참고: luckykim의 아이디는 1입니다.)
  */
  public static final String PART2_10 = "INSERT INTO CONTENT " +
          "VALUES(5, 'my project', 'my project is good', CURRENT_TIMESTAMP ,1);";
          // CURRENT_TIMESTAMP 를 넣으면, 현재 시간이 들어가도록 할 수 있다.(현재 시간을 return 해주는 함수 인듯)
          // insert 할때는 기존의 table에 있는 id와 겹치면 안됌.
}
