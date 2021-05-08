package com.sse.software_testing;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author hq
 */
public class Test {
    public static void main(String[] args) {
//        String str = "{’id‘:’75‘,’shoppingCartItemList‘:[{’id‘:’407‘,’num’:‘10‘}]}";
        String str = "{\"id\":\"75\",\"shop\":{\"id\":\"407\",\"num\":\"10\"}}";
        JSONObject jsonObject = JSONObject.parseObject(str);
//        // 获取到key为shoppingCartItemList的值
//        String r = jsonObject.getJSONObject("shop").getString("num");
//        System.out.println(r);
        Map<Object, Object> map = (Map) jsonObject;
        System.out.println(map);
        System.out.println(map.get("shop"));
        System.out.println(map.get("shop"));
    }
}
