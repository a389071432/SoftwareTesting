package com.sse.software_testing.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;

/**
 * @author hq
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @ApiOperation("测试Kit") //显示在接口的信息说明
    @GetMapping("/test")
    public String getTestResult(
            @RequestParam("question") String question,
            @RequestParam("tableData") Object tableData) throws ParseException, UnsupportedEncodingException {
        System.out.println(new Date());
        String json=JSON.toJSONString(new Date());
        System.out.println(tableData);
        //URL解码
//        String data = URLDecoder.decode( tableData,"utf-8");
//        System.out.println(data);
//        //截取json字符串
//        String substring = data.substring(data.index0f( "[" ) );
//        //转为json数组
//        JSONArray jsonArray= JSONArray.parseArray( substring);
        return json;
    }
}
