import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * 1. Browser에 존재하는 stringify 함수를 직접 구현해 봅니다.
 * stringify 함수는 input 값을 JSON 형식으로 변환합니다.
 *
 * 2. stringify는 아래와 같이 작동합니다.
 * - Boolean이 input으로 주어졌을 경우
 * stringify(true);                // "true"
 * - String이 input으로 주어졌을 경우
 * stringify("foo");               // "foo"
 * - null이 주어졌을 경우
 * stringify(null)                 // "null"
 * - HashMap이 input으로 주어졌을 경우
 * HashMap<Object, Object> map = new HashMap<>();
 * map.put("null", 2);
 * map.put("true", "false");
 * stringify(map);                // "{"null":2,"true":"false"}"
 * Map 자료형의 Key는 항상 String으로 저장됩니다. null은 입력할 수 없습니다.
 *
 * 예시에 해당되지 않는 자료형의 경우 모두 null을 반환합니다.
 *
 * 3. test/java/stringifyJSON_test.java의 테스트에서 어떤 input 값들이 주어지고, 어떻게 stringify 주어야 할지 생각해 보세요.
 *
 *
 * 4. 입력받은 전달인자의 타입은 instanceof 메서드를 활용합니다.
 *
 * 5. 그냥 테스트 통과를 하고 싶으시다면, 다음과 같이 구현하면 될 거예요.
 * ObjectMapper mapper = new ObjectMapper();
 * return mapper.writeValueAsString(data);
 * 위의 코드는 ObjectMapper 메소드로 이미 구현되어 있습니다. main 클래스에서 직접 사용해보세요!
 *
 * 하지만 이 과제의 목적은 재귀를 공부하는 것이니, 처음부터 구현해봐야겠지요?:
 */
// 내 풀이지만, 꼭 head와 tail로 쪼갠다는 개념은 버리는게 좋다.
// 그냥 입력값을 이용해서 순회하고, 작은 문제 단위로 쪼갠다는 개념이 중요하다.
public class stringifyJSON {

  public String ObjectMapper(Object data) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(data);
  }

  public String stringify(Object data) {

    //입력된 값이 문자열일 경우
    if(data instanceof String){
      String res = "\"" + data + "\"";
      return res;
    }
    //입력된 값이 Integer일 경우
    if(data instanceof Integer){
      String res = String.valueOf(data);
      return res;
    }
    //입력된 값이 Boolean일 경우
    if(data instanceof Boolean){
      String res =  String.valueOf(data);
      return res;
    }

    //입력된 값이 Object[]일 경우
    // 입력값 : {1, 2 ,"abc", ["a","b","c","d"], 7}
    // 최종출력 결과 : "[1,2,"abc",["a","b","c","d"], 7]"
    if(data instanceof Object[]){
      //int len = ((Object[]) data).length;
      Object[] resArr = (Object[]) data;

      for(int i = 0; i < resArr.length; i++) {
        resArr[i] = stringify(resArr[i]);
      }

      return Arrays.toString(resArr).replaceAll(" ","");
    }

    //입력된 값이 HashMap일 경우
    // --------meta data---------
    // 입력값
    // map.put("null", 2);
    // map.put("true", "false");

    //출력값
    // {"null":2,"true":"false"}
    //----------------------------
    //입력된 값이 HashMap일 경우
    // --------meta data---------
    // 입력값
    // map.put("null", 2);
    // map.put("true", "false");

    //출력값
    // {"null":2,"true":"false"}
    //----------------------------
    if(data instanceof HashMap){
      HashMap<Object,Object> oridata = (HashMap<Object, Object>) data;
      HashMap<Object,Object> hashData = new HashMap<Object, Object>();
      // 원본 그대로 주입
      for (Map.Entry<Object, Object> entry : oridata.entrySet()) {
        hashData.put(entry.getKey(), entry.getValue());
      }

      // 더이상 쪼갤 수 없을때
      if(hashData.isEmpty()) return "{}";

      // 쪼갤수 있는 경우
      // head : 맨 처음의 key
      // tail : stringify(맨처음의 key를 제거한 hashMap)
      Set<Object> keys = hashData.keySet();
      System.out.println(keys);
      Iterator<Object> iterator =  keys.iterator();
      Object head = iterator.next();
      Object headValue = hashData.get(head);//

      hashData.remove(head);
      String tail = stringify(hashData); // {}

      // 최종 결과를 담아줄 res
      String res;
      if(tail.equals("{}")){
        res = "{" + stringify(head) + ":" + stringify(headValue) + "}";
      }else{
        res = "{" + stringify(head) + ":" + stringify(headValue) + tail.replace("{",",");
      }
      return res;
    }

    //지정되지 않은 타입의 경우에는 "null"을 리턴합니다.
    return "null";
  }
}
