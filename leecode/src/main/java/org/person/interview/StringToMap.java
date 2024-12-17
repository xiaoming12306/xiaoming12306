package org.person.interview;

import java.util.HashMap;
import java.util.Map;

public class StringToMap {

  public static void main(String[] args) {
    String jsonString =
        ""
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "v{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}"
            + "{\"key1\": \"value1\", \"key2\": \"value2\"}";
    try {
      Map<String, Object> testMap = new HashMap<String, Object>();
      testMap.put("test", jsonString.toString());
      System.out.println(testMap);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
