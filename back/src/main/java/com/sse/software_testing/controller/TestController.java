package com.sse.software_testing.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sse.software_testing.model.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.sse.software_testing.service.Triangle;
/**
 * @author hq
 */
@RestController
@RequestMapping("/api")
public class TestController {
    Result res = new Result();

    @ApiOperation("测试Kit") //显示在接口的信息说明
    @PostMapping("/test")
    public String getTestResult(
            @RequestBody Map<String,Object> data)  {
        System.out.println(new Date());
        String question = (String) data.get("question");
        String jsonObj = (String) data.get("case");
        JSONObject jsonObject = JSONObject.parseObject(jsonObj);
        Map<String, Object> caseItem = (Map) jsonObject;
        System.out.println(question);
        if("triangle".equals(question)){
            System.out.println(caseItem.get("a"));
            System.out.println(caseItem.get("b"));
            res.setRealOutput(Triangle.getTriangleType(Double.parseDouble(caseItem.get("a").toString()),
                    Double.parseDouble(caseItem.get("b").toString()),
                    Double.parseDouble(caseItem.get("c").toString())));
            System.out.println(res.getRealOutput());
        }
        else if("calendar".equals(question)){

        }
        else if("computer".equals(question)){

        }
        else if("phone".equals(question)){

        }
        res.setResult((res.getRealOutput().equals(caseItem.get("ExpectedOutput")))?"correct":"wrong");
        return JSON.toJSONString(res);
    }
}
