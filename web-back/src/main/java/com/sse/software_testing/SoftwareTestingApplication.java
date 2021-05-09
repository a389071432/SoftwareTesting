package com.sse.software_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class SoftwareTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareTestingApplication.class, args);
    }

}