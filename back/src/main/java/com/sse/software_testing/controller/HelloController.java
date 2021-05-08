package com.sse.software_testing.controller;

/**
 * @author hq
 */
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(tags = "测试-HelloWorld") //这个controller下的所有接口的描述
public class HelloController {

    @ApiOperation("测试Swagger2") //显示在接口的信息说明
    @RequestMapping(value = "/hello", method = RequestMethod.GET) //请求路径和类型
    public void testSwagger(){

    }
}
