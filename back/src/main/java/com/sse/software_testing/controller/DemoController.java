package com.sse.software_testing.controller;

/**
 * @author hq
 */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("hello")
    public String sayHello(){
        return "hello Beijing";
    }
}
