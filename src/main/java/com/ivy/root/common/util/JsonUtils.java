package com.ivy.root.common.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.*;

/**
* @Description:    java类作用描述
* @Author:         matao
* @CreateDate:     2019/3/11 14:50

* @UpdateUser:     matao
* @UpdateDate:     2019/3/11 14:50
* @UpdateRemark:   修改内容

* @Version:        1.0
*/
public class JsonUtils {
    private final static JsonParser JSON_PARSER = new JsonParser();
    public static Map<String,Object> jsonToMap(String json){
        JsonElement element = JSON_PARSER.parse(json);
        if (! element.isJsonObject()){
            return null;
        }
        return (Map<String, Object>) jsonToObject(element);
    }
    public static Object jsonToObject(JsonElement element){
        if (element.isJsonPrimitive()){
            return element.getAsJsonPrimitive().getAsString();
        }
        if (element.isJsonObject()){
            Map<String, Object> map = new HashMap<>();
            for (String key :
                    element.getAsJsonObject().keySet()) {
                JsonElement jsonElement = element.getAsJsonObject().get(key);
                map.put(key, jsonToObject(jsonElement));
            }
            return map;
        }
        if (element.isJsonArray()){
            List<Object> list = new ArrayList<Object>();
            for (int i=0;i<element.getAsJsonArray().size();i++){
                JsonElement jsonElement = element.getAsJsonArray().get(i);
                list.add(jsonToObject(jsonElement));
            }
            return list;
        }
        return null;
    }
}