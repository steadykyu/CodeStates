import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;

public class main {
  public static void main(String[] args) throws JsonProcessingException {
//    stringifyJSON test = new stringifyJSON();
//
//    System.out.println(test.stringify(new HashMap<>(){{
//      put("foo", true);
//      put("bar", false);
//      put("baz", null);
//    }}));

//-------------------------hashmap ObjectMapper() 결과 값 -------------------------------------
    ObjectMapper mapper = new ObjectMapper();
    HashMap<Object, Object> map = new HashMap<>(){{
            put("foo", true);
      put("bar", false);
      put("baz", null);
    }};
    System.out.println(mapper.writeValueAsString(map));


  }
}
//---------------------배열 - ObjectMapper() 결과 값  ----------------------
//    ObjectMapper mapper = new ObjectMapper();
//    //빈 배열 입력시
//    System.out.println("-".repeat(10) + "빈 배열 입력시" );
//    System.out.println(mapper.writeValueAsString(new Object[]{}));
//    // 배열 값 입력시
//    System.out.println("-".repeat(10) + "값 배열 입력시" );
//    Object[] objects = new Object[]{
//            true, 1, 2, "abc",new String[]{"a", "b", "c", "d"}
//    };
//    String json = mapper.writeValueAsString(objects);
//    System.out.println(json);
//    System.out.println(json.charAt(0)); // [
//    System.out.println(json.charAt(2)); //

//-------------------------hashmap ObjectMapper() 결과 값 -------------------------------------
//    ObjectMapper mapper = new ObjectMapper();
//    HashMap<Object, Object> map = new HashMap<>(){{
//      ut("foo", true);
//      put("bar", false);
//      put("baz", null);
//    }};
//    System.out.println(mapper.writeValueAsString(map));