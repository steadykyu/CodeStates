package com.codestates.script;

public class part3 {
  /*
  ----------------------------------------------------------------------------------------------
      TODO: 유어클래스의 requirement를 참조하여, migration/schema.sql에 추가로 구성해주세요.
  */

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-1. category 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 category 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_1 = "DESCRIBE CATEGORY";
  // DESC 도 가능

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-2. content_category 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 content_category 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_2 = "DESCRIBE CONTENT_CATEGORY";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-3. role 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 role 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_3 = "DESCRIBE ROLE";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-1-4. user 테이블의 구조를 보기위한 SQL을 작성해주세요.
          - 요구사항에 맞는 user 테이블을 작성해야만, 테스트를 통과합니다.
  */
  public static final String PART3_1_4 = "DESCRIBE USER";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-1. category 테이블에 존재하는 데이터에서 id, name을 찾는 SQL을 작성해주세요.
  */

  public static final String PART3_2_1 = "SELECT ID, NAME FROM CATEGORY";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-2. user의 name과 email 그리고 그 user가 속한 role name(컬럼명: roleName)을 찾기 위한 SQL을 작성해주세요.
          - 속한 role이 없더라도, user의 name과 email,role name을 모두 찾아야합니다.
  */
  public static final String PART3_2_2 = "SELECT U.NAME, U.EMAIL, R.NAME AS ROLENAME " +
          "FROM USER AS U " +
          "LEFT JOIN ROLE AS R " +
          "ON U.ROLEID = R.ID";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-3. 어느 role에도 속하지 않는 user의 모든 컬럼 데이터를 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_3 = "SELECT * " +
          "FROM USER AS U " +
          "LEFT JOIN ROLE AS R " +
          "ON U.ROLEID = R.ID " +
          "WHERE R.ID IS NULL;";

  //"SELECT * FROM USER AS U where USER.roleid is null"
  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-4. content_category 테이블에 존재하는 모든 칼럼의 데이터를 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_4 = "SELECT * FROM CONTENT_CATEGORY";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-5. minsanggu이 작성한 content의 title을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_5 = "SELECT C.TITLE " +
          "FROM CONTENT AS C " +
          "INNER JOIN USER AS U " +
          "ON C.USERID = U.ID " +
          "WHERE U.NAME = 'minsanggu'";
  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-6. minsanggu이 작성한 content의 category name을 찾기위한 SQL을 작성해주세요.
      3개 이상의 join을 연결 할 수 있다.
      어느 쪽에 WHERE을 쓸 것인가로 시작점을 정할 수 있다.
  */
  public static final String PART3_2_6 = "SELECT CG.NAME " +
          "FROM USER AS U " +
          "inner JOIN CONTENT AS C " +
          "ON U.id = C.userId " +

          "inner JOIN CONTENT_CATEGORY AS CC " +
          "ON CC.contentId = C.id " +

          "inner JOIN CATEGORY AS CG " +
          "ON CC.categoryId = CG.id " +

          "WHERE U.NAME = 'minsanggu';";
// 위 코드같은 테이블 순서 보다는 최종 column이 사용되는 테이블을 FROM 으로 가져와서 Join으로 붙여가는게 가독성이 좋다.


  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-7. category의 name이 java인 content의 title, body, created_at을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_7 = "SELECT C.title, C.body, C.created_at " +
          "FROM CONTENT AS C " +
          "INNER JOIN CONTENT_CATEGORY AS CC " +
          "ON C.ID = CC.contentId " +

          "INNER JOIN CATEGORY AS CG " +
          "ON CG.ID = CC.CATEGORYID " +
          "WHERE CG.NAME = 'java';";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-8. category의 name이 java인 content의 title, body, created_at, user의 name을 찾기위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_8 = "SELECT C.title, C.body, C.created_at, U.NAME " +
          "FROM USER AS U " +
          "INNER JOIN CONTENT AS C " +
          "ON U.ID = C.USERID " +

          "INNER JOIN CONTENT_CATEGORY AS CC " +
          "ON C.ID = CC.contentId " +

          "INNER JOIN CATEGORY AS CG " +
          "ON CG.ID = CC.CATEGORYID " +
          "WHERE CG.NAME = 'java';";

  /*
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-9. teawoongna가 작성한 글의 개수 (컬럼명: ContentCount)를 출력하기 위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_9 = "SELECT COUNT(C.ID) AS ContentCount " +
          "FROM USER AS U " +
          "INNER JOIN CONTENT AS C " +
          "ON U.ID = C.USERID " +
          "WHERE U.NAME = 'teawoongna'";

  /*
  // 한 유저의 정보만 구해주면 되므로 inner join으로 해결 가능하다.
  ----------------------------------------------------------------------------------------------
      TODO: Q 3-2-10. 각 user(컬럼명: name)가 작성한 글의 개수 (컬럼명: ContentCount)를 출력하기 위한 SQL을 작성해주세요.
  */
  public static final String PART3_2_10 = "SELECT U.NAME, COUNT(C.id) AS ContentCount " +
          "FROM USER AS U " +
          "LEFT JOIN CONTENT C ON U.ID = C.userId " +
          "GROUP BY U.NAME";
}
// 현재 문제의 기준은 user이다. 그러므로 비록 글의개수가 null값이 들어가더라도 "모든 유저를 구해주어야한다."
// 단 null값인 부분을 카운트 해주지 않기 위해 COUNT(*) 가 아니라, COUNT(C.id) - 글의 개수 를 써야한다.
// user로 left join하여 각 user들의 글의 개수를 구한다.
