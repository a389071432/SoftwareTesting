package com.sse.software_testing.controller;

import com.alibaba.fastjson.JSON;
import com.sse.software_testing.service.TriangleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @author hq
 */
@RestController
//这个controller下的所有接口的描述
@Api(tags = "三角形测试")
public class TriangleController {
    @ApiOperation("测试Triangle") //显示在接口的信息说明
    @ResponseBody
    @RequestMapping(value = "/api/triangle/{edgeA}/{edgeB}/{edgeC}", method = RequestMethod.GET) //请求路径和类型
    public String getTriangleType(@PathVariable String edgeA, @PathVariable String edgeB, @PathVariable String edgeC) throws ParseException {
        String str = TriangleService.getTriangleType(
                Double.parseDouble(edgeA),Double.parseDouble(edgeB),Double.parseDouble(edgeC)
        );
//        JSONObject res = JSONObject.parseObject("{'result':'correct','msg':"+str+"}");
        String res = JSON.toJSONString("{'result':'correct','msg':"+str+"}");
        return res;
    }
}
