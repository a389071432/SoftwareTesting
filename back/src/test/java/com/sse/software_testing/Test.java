package com.sse.software_testing;

import com.alibaba.fastjson.JSONArray;

/**
 * @author hq
 */
public class Test {
    public static void main(String[] args) {
//        String tableData = "[%7B%22a%22:0,%22b%22:50,%22c%22:50,%22ExpectedOutput%22:%22%E6%95%B0%E5%80%BC%E8%B6%8A%E7%95%8C%22,%22index%22:0%7D,%7B%22a%22:2.2,%22b%22:50,%22c%22:50,%22ExpectedOutput%22:%22%E7%AD%89%E8%85%B0%E4%B8%89%E8%A7%92%E5%BD%A2%22,%22index%22:1%7D]";
        String tableData = "[{\"a\":0,\"b\":50,\"c\":50,\"ExpectedOutput\":\"数值越界\",\"index\":0},{\"a\":2.2,\"b\":50,\"c\":50,\"ExpectedOutput\":\"等腰三角形\",\"index\":1}]";
//        String data = URLDecoder.decode( tableData,"utf-8");
//        System.out.println(data);
        String data = tableData;
        //转为json数组
        JSONArray jsonArray= JSONArray.parseArray(tableData);
        System.out.println(jsonArray);
//        String name = jsonArray.get("ExpectedOutput").toString();
    }
}
