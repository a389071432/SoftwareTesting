package com.sse.software_testing.controller;

/**
 * @author hq
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//  localhost:8090/demo/welcome?name=jade
@RestController
@RequestMapping(value = "/demo", method = RequestMethod.GET)
public class DemoController {
    @RequestMapping("welcome")
    @ResponseBody
    String DemoWorld(String name) {
        return "Welcome!" + name;
    }
}